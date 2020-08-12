package com.gm.content.commens.expection;

import com.gm.content.domain.ResponseResult;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

/**
 * 抓住的是找不到的错误
 */
@RestController
@RequestMapping("${server.error.path:${error.path:/error}}")
public class BaseErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return null;
    }

    @RequestMapping(produces = "text/html;charset=UTF-8")
    @ResponseBody
    public ResponseResult handleError() {
        return new ResponseResult(ResultEnum.PAGE_NOT_EXIT);
    }

//    @RequestMapping(produces = ,consumes = )
}
