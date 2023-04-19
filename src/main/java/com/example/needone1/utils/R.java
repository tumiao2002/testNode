package com.example.needone1.utils;

import lombok.Data;

@Data
public class R {
    private Object data;
    private String msg;
    private int code;
//    private boolean flag;
    public R(){}
    public R(Object data,String msg,int code)
    {
        this.data = data;
        this.msg = msg;
        this.code = code;
    }
}
