package com.gm.content.commens.expection;

public class BussinessExecption extends RuntimeException {
    //自定义错误码
    private Integer code;

    //自定义构造器,必须输入错误码内容
    public BussinessExecption(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
