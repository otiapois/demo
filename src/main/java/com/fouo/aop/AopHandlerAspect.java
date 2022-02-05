package com.fouo.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * 日志切面
 *
 * @author fouo
 * @date 2022/1/31 18:40
 */
@Component    //把切面类加入到IOC容器中
@Aspect        //使之成为切面类
@Slf4j
public class AopHandlerAspect {
    //为了记录执行时间 方便调试 如果不需要可以去掉
    ThreadLocal<Long> time = new ThreadLocal<>();

    //定义一个切入点 我这里是从controller切入 不是从注解切入
    //详情看下方的 切入点表达式
//    @Pointcut("execution(public * com.fouo.aop.MathCalculator.*(..))")
//    public void pointCut() {
//    }
    @Pointcut("@annotation(com.fouo.aop.AopAnnotation)")
    public void pointCut() {
    }

    //在进入方法前执行 可以对参数进行限制或者拦截
    //通常在这边做日志存储存到数据库中
    @Before("pointCut()")
    public void before(JoinPoint joinPoint) throws Throwable {
        log.info("==================前置执行=====================>");
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        log.info("请求来源： =》" + request.getRemoteAddr());
        log.info("请求URL：" + request.getRequestURL().toString());
        log.info("请求方式：" + request.getMethod());
        log.info("响应方法：" + joinPoint.getSignature().getDeclaringTypeName() + "." + joinPoint.getSignature().getName());
        log.info("请求参数：" + Arrays.toString(joinPoint.getArgs()));
        log.info("==================前置执行完成==================>");
        time.set(System.currentTimeMillis());
    }

    //环绕执行
//定义需要匹配的切点表达式，同时需要匹配参数
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        log.info("==================方法环绕前置start=====================>");
        //这句必须有 往下执行方法
        Object result = pjp.proceed();

        log.info("==================方法环绕后置start=====================>");
        log.info("耗时（毫秒）：" + time);
        log.info("返回数据：{}", result);
        log.info("==================方法环绕end======================>");
        return result;
    }

    //在方法执行后执行 可以打印返回的数据 判断数据是否是自己需要的
    @After("pointCut()")
    public void after(JoinPoint point) {
        if (time.get() == null) {
            time.set(System.currentTimeMillis());
        }
        log.info("==================后置执行======================>");
        log.info("耗时（毫秒）：" + (System.currentTimeMillis() - time.get()));
        log.info("返回数据：{}", point.getArgs());
        log.info("==================后置执行完成==================>");
    }
}
