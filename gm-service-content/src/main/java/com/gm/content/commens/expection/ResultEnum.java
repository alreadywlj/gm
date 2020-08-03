package com.gm.content.commens.expection;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
public enum ResultEnum  implements StatusCode{

    PAGE_NOT_EXIT(404,"页面不存在"),
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(3001,"成功"),
    ERROR(3002,"失败"),
    ;

    private Integer code;
    private String msg;

    ResultEnum(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }


}
