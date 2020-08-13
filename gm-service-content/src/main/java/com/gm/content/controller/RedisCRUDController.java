package com.gm.content.controller;


import com.gm.content.domain.Dictionary;
import com.gm.content.domain.ResponseResult;
import com.gm.content.service.IRedisCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/redis")
@RestController
public class RedisCRUDController {

    @Autowired
    IRedisCRUDService redisCRUDService;

    @GetMapping("/{id}")
    public ResponseResult selectDictionary(@PathVariable("id") String id) {

        Dictionary dictionary = redisCRUDService.selectDictionary(id);

        return new ResponseResult(dictionary);
    }

}
