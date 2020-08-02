package com.gm.content.service.impl;

import com.gm.content.dao.mapper.DictionaryMapper;
import com.gm.content.dao.repository.DictionaryRepository;
import com.gm.content.domain.Dictionary;
import com.gm.content.service.IDictionariesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class DictionariesServiceImpl implements IDictionariesService {

    @Autowired
    DictionaryRepository dictionaryRepository;

    @Autowired
    DictionaryMapper dictionaryMapper;

    @Override
    public String queryAllDictionnaries() {
        List<Dictionary> all = dictionaryMapper.findAllDic();
        return  all.toString();
    }
}
