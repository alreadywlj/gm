package com.gm.content.controller;

import com.gm.content.commens.expection.ResultEnum;
import com.gm.content.domain.Dictionary;
import com.gm.content.domain.ResponseResult;
import com.gm.content.service.IDictionariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dictinaries")
public class DictionaryController {

    @Autowired
    IDictionariesService dictionariesService;

    @GetMapping
    public String getDictinaries() {
        return dictionariesService.queryAllDictionnaries();
    }


    @PostMapping
    public ResponseResult createDictionary(@Validated @RequestBody Dictionary dictionary) {


        return new ResponseResult(ResultEnum.SUCCESS);
    }


}
