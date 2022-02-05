package com.fouo.ext;

import lombok.Data;
import lombok.Getter;

/**
 * 枚举使用演示
 *
 * 可以把枚举看成一张数据库的表
 * 每个枚举对象都可以看成是表中的一行数据
 * @author fouo
 * @date 2020/10/29 17:19
 */
public enum CountryEnum {
    ZERO(0, "孔"),
    ONE(1, "赵"),
    TWO(2, "钱"),
    THREE(3, "孙"),
    FOUR(4, "李");

    @Getter
    private Integer retCode;
    @Getter
    private String retName;

    CountryEnum(int retCode, String retName) {
        this.retCode = retCode;
        this.retName = retName;
    }

    public static CountryEnum forEachCountryName(int index) {
        CountryEnum[] array = CountryEnum.values();
        for (CountryEnum element : array) {
            if (index == element.getRetCode()) {
                return element;
            }
        }
        return null;
    }
}
