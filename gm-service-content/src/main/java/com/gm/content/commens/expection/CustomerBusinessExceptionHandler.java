package com.gm.content.commens.expection;

import com.gm.content.domain.ResponseResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * 这个注解他将所有控制器作为一个切面,利用切面技术来实现
 * 抓住controller中的错误进行统一的错误处理
 */
@RestControllerAdvice
public class CustomerBusinessExceptionHandler {

    @ExceptionHandler({BussinessExecption.class})
    public ResponseResult bussinessExceptionHandler(BussinessExecption e) {
        return new ResponseResult(e.getCode(),e.getMessage());
    }

    @ExceptionHandler({SQLException.class})
    public ResponseResult tranSqlException(SQLException e) {
        return new ResponseResult(e.getErrorCode(),e.getMessage());
    }
}
