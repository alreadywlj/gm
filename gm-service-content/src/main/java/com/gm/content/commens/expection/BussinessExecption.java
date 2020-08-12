package com.gm.content.commens.expection;

/**
 * @author: wlj
 * @description: 自定义异常处理类
 * @time : 2020/08/12
 */
//继承运行时异常，程序可主动抛出BussinessExecption，进行统一的返回
public class BussinessExecption extends RuntimeException {
    //自定义错误码
    private Integer code;

    //自定义构造器,必须输入错误码内容 方法的重载
    public BussinessExecption(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public BussinessExecption(StatusCode statusCode) {
        super(statusCode.getMsg());
        this.code = statusCode.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
