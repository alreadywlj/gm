package com.gm.content.controller;

import com.gm.content.service.IDictionariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dictinaries")
public class DictionaryController {

    @Autowired
    IDictionariesService dictionariesService;

    @GetMapping
    public String getDictinaries() {
        return dictionariesService.queryAllDictionnaries();
    }



    

}
