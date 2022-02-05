package com.fouo.design.creation.prototype;

/**
 * 原型模式测试类
 * 1.FouoMybatis:操作数据库，查出很多记录。（70%的记录改变很少）
 * 2.每次查数据库，查到后，把所有数据都封装一个对象返回
 *  10000thread：查询一个记录：new User("张三",18);
 *  每次创建一个对象封装并返回，那么系统里面就会有10000个User对象
 *  浪费内存
 * 3.解决:设计一个缓存,如果查询过就保存，如果再查的是相同的记录
 * 那么就会拿到原来的原型对象。
 * 4.此时再次查询到某个对象，会直接从缓存中获取，但是这样会很危险
 * @author fouo
 * @date 2022/2/1 13:50
 */
public class PrototypeTest {

    public static void main(String[] args) throws CloneNotSupportedException {
        FouoMybatis fouoMybatis = new FouoMybatis();
        //第一次查询
        //得到的是克隆体
        User user1 = fouoMybatis.getUser("张三");
        System.out.println("1====>"+user1.getName());
        user1.setName("李四2");
        //得到的是克隆体
        User user2 = fouoMybatis.getUser("张三");
        System.out.println("2====>"+user2.getName());
        //得到的是克隆体
        System.out.println("3====>"+user1.getName());
        System.out.println(user1==user2);

    }

}
