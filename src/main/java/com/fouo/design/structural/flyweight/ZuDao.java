package com.fouo.design.structural.flyweight;

import com.fouo.xs.day03.HashMapTreeMap;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 足道店 ：相当于享元工厂
 * 店里面很多服务员
 *
 * @author fouo
 * @date 2022/2/2 21:12
 */
public class ZuDao {

    private static Map<String, AbstractWaitressFlyweight> pool = new HashMap<>();

    //享元，池子中已经有一些对象
    static {
        pool.put("1111", new BeautifulWaitress("1111", "zhangsan", 18));
        pool.put("2222", new BeautifulWaitress("2222", "lisi", 26));
    }

    public void addWaitress(AbstractWaitressFlyweight waitressFlyweight) {
        pool.put(UUID.randomUUID().toString(), waitressFlyweight);
    }

    public static AbstractWaitressFlyweight getWaitress(String name) {
        AbstractWaitressFlyweight waitress = pool.get(name);
        if (waitress == null) {
            for (AbstractWaitressFlyweight value : pool.values()) {
                if (value.canService) {
                    return value;
                }
            }
        }else if(waitress.canService){
            return waitress;
        }
        return null;
    }

}
