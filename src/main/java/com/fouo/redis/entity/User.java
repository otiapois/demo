package com.fouo.redis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Date;

@Data
@TableName("fouo_user")
public class User {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String name;
    private String password;
    private Date createTime;
}
