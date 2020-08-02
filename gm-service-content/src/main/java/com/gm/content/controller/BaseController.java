package com.gm.content.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class BaseController  implements ErrorController {

    @Override
    public String getErrorPath() {
        return null;
    }

    @RequestMapping
    public Map<String,Object> handleError(){
        Map<String,Object> map = new HashMap<String,Object>();

        map.put("code",404);

        map.put("msg","不存在");

        return map;
    }
}
