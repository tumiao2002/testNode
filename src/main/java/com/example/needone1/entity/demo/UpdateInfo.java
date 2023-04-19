package com.example.needone1.entity.demo;

import lombok.Data;

import java.util.Date;

@Data
//项目设置页面数据
public class UpdateInfo {
    private String pid;//唯一id
    private String name;//项目名称
    private String path;//原型目录
    private String password;//访问密码
    private Date createTime;//创建时间
}
