package com.example.needone1.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Project {
    private String pid;//id
    private String name;//项目名称
    private String path;//项目路径
    private Date createTime;//项目创建时间
    private Date updateTime;//项目最新修改时间
    private Date generateTime;//项目归档时间
    private Date deleteTime;//项目被删除的时间
    private boolean isUpdateNotice;//更新后是否通知
    private boolean isFiled;
    private boolean isAutogenerate;//是否自动进行归档
    private boolean softWare;
    private String password;
}
