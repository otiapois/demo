package com.fouo.design.creation.prototype;

import java.util.HashMap;
import java.util.Map;

/**
 * 模拟mybatis框架
 *
 * @author fouo
 * @date 2022/2/1 13:57
 */
public class FouoMybatis {
    //user缓存
    private Map<String,User> userCache = new HashMap<>();

    //获取User对象
    public User getUser(String name) throws CloneNotSupportedException {
        User user = null;
        if(!userCache.containsKey(name)){
            //从数据库查
            user = getUserFromDb(name);
            if(user!=null){
                //存入缓存（克隆体）
                userCache.put(name,user.clone());
            }
        }else{
            //从缓存中直接拿，脏缓存问题，就是当某个线程修改对象后,缓存中的对象也会跟着变化
            //原型已经拿到，但是不能直接给（本人） 从缓存当中获取到的就是一个克隆体
            user = userCache.get(name);
//            //从这个对象快速得到一个克隆体（克隆人）
//            user =  user.clone();

        }
        return user;
    }

    private User getUserFromDb(String name) {
        System.out.println("从数据库查到："+name);
        User user = new User();
        user.setName("张三");
        user.setAge(27);
        return user;
    }

}
