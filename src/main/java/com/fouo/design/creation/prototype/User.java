package com.fouo.design.creation.prototype;

import lombok.Data;

/**
 * 用户对象
 * User implements Cloneable  代表当前对象是可克隆的
 * @author fouo
 * @date 2022/2/1 13:57
 */
@Data
public class User implements Cloneable {
    private String name;
    private Integer age;

    /**
     * 重现Object克隆方法
     * 再创建一个人赋予所有属性
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected User clone() throws CloneNotSupportedException {
        User user = new User();
        user.setAge(this.age);
        user.setName(this.name);
        return user;
    }
}
