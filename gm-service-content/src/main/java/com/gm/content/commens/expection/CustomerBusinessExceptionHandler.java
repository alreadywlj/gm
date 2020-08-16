package com.gm.content.commens.expection;

import com.gm.content.domain.ResponseResult;
import org.apache.ibatis.binding.BindingException;
import org.hibernate.exception.DataException;
import org.hibernate.exception.GenericJDBCException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.UnexpectedTypeException;
import java.sql.SQLException;
import java.util.stream.Collectors;

/**
 * @author: wlj
 * @time: 2020/08/12
 * @description: 抓住切面中的所有错误，对其进行统一的处理
 * 抓住controller中的错误进行统一的错误处理
 */
@RestControllerAdvice  //这个注解他将所有控制器作为一个切面,利用切面技术来实现cglib
public class CustomerBusinessExceptionHandler {

    @ExceptionHandler({BussinessExecption.class})
    public ResponseResult bussinessExceptionHandler(BussinessExecption e) {
        return new ResponseResult(e.getCode(), e.getMessage());
    }

    @ExceptionHandler({SQLException.class})
    @ResponseBody
    public ResponseResult tranSqlException(SQLException e) {
        return new ResponseResult(e.getErrorCode(), e.getMessage());
    }

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseResult tryHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        return new ResponseResult(ResultEnum.ERROR, e.getMessage());
    }

    @ExceptionHandler({UnexpectedTypeException.class})
    public ResponseResult tryUnexpectedTypeException(UnexpectedTypeException e) {
        return new ResponseResult(ResultEnum.ERROR, e.getMessage());
    }

    //处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是
    @ExceptionHandler({ConstraintViolationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ResponseResult tryConstraintViolationException(ConstraintViolationException e) {
        String message = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining());
        return new ResponseResult(ResultEnum.ERROR, message);
    }

    //事务异常
    @ExceptionHandler({TransactionSystemException.class})
    public ResponseResult tryTransactionSystemException(TransactionSystemException e) {
        return new ResponseResult(ResultEnum.ERROR, e.getMessage());
    }

    //处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常，
    @ExceptionHandler({BindException.class})
    @ResponseBody
    public ResponseResult tryBindException(BindException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return new ResponseResult(ResultEnum.ERROR, message);
    }

    //处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    public ResponseResult MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
        return new ResponseResult(ResultEnum.ERROR, message);
    }

    @ExceptionHandler({DataException.class})
    @ResponseBody
    public ResponseResult tryDataException(DataException e) {
        String message = e.getSQLException().getMessage();
        return new ResponseResult(ResultEnum.ERROR, message);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    @ResponseBody
    public ResponseResult tryDataIntegrityViolationException(DataIntegrityViolationException e) {
        String message = e.getMostSpecificCause().getMessage();
        return new ResponseResult(ResultEnum.ERROR, message);
    }

    @ExceptionHandler({GenericJDBCException.class})
    @ResponseBody  //数据库字段和传入的字段不匹配
    public ResponseResult tryDataIntegrityViolationException(GenericJDBCException e) {
        String message = e.getMessage();
        return new ResponseResult(ResultEnum.ERROR, message);
    }

    @ExceptionHandler({Exception.class})
    public ResponseResult tryException(Exception e) {
        String message = e.getMessage();
        return new ResponseResult(ResultEnum.ERROR, message);
    }

}
