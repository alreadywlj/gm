package com.gm.content.controller;


import com.gm.content.commens.expection.ResultEnum;
import com.gm.content.domain.Dictionary;
import com.gm.content.domain.ResponseResult;
import com.gm.content.service.IRedisCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RequestMapping("/redis")
@RestController
public class RedisCRUDController {

    @Autowired
    IRedisCRUDService redisCRUDService;

    @GetMapping("/{id}")
    public ResponseResult selectDictionary(@PathVariable("id") int id) {

        Dictionary dictionary = redisCRUDService.selectDictionary(id);

        return new ResponseResult(dictionary);
    }

    @DeleteMapping("/{id}")
    public ResponseResult delDictionary(@PathVariable("id") int id) {
        redisCRUDService.delDictionary(id);
        return new ResponseResult(ResultEnum.SUCCESS);
    }

    @PutMapping("/{id}")
    public ResponseResult updateDictionary(@PathVariable(value = "id", required = true) int id, @Validated @RequestBody Dictionary dictionary) {
        dictionary.setUpdTime(new Date());
        redisCRUDService.updateDictionary(id,dictionary);
        return new ResponseResult(ResultEnum.SUCCESS);
    }
}
