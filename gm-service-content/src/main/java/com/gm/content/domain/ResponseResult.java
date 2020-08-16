package com.gm.content.domain;

import com.gm.content.commens.expection.ResultEnum;
import com.gm.content.commens.expection.StatusCode;
import lombok.Data;

@Data
public class ResponseResult {

    private int code;

    private String msg;

    private Object data;

    private long timeStamp;


    //手动设置 一个参数
    public ResponseResult(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.timeStamp = System.currentTimeMillis();
    }

    //默认返回成功  这里是方法的重载
    public ResponseResult(Object data) {
        this.code = ResultEnum.SUCCESS.getCode();
        this.msg = ResultEnum.SUCCESS.getMsg();
        this.data = data;
        this.timeStamp = System.currentTimeMillis();
    }

    // 返回指定状态码，数据对象
    public ResponseResult(StatusCode statusCode, Object data) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = data;
        this.timeStamp = System.currentTimeMillis();
    }

    //只返回状态码
    public ResponseResult(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
        this.data = null;
        this.timeStamp = System.currentTimeMillis();
    }

    //返回自定义的状态码
    public ResponseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
        this.data = null;
        this.timeStamp = System.currentTimeMillis();
    }

//    public ResponseResult(Page data) {
//        this.code = code;
//        this.msg = msg;
//        this.data = this.format(data);
//        this.timeStamp = System.currentTimeMillis();
//    }

    /**
     * 转换format
     * @param data
     * @return
     */
//    private PageInfo format(Page data) {
//
//        PageInfo pageInfo = new PageInfo();
//
//        pageInfo.setData(data.getContent());
//
//        pageInfo.setPageable(data.getPageable());
//
//        pageInfo.setTotalElements(data.getTotalElements());
//
//        pageInfo.setTotalPages(data.getTotalPages());
//
//        return pageInfo;
//
//    }


}
