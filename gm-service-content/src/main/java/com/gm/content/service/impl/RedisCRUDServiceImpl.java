package com.gm.content.service.impl;

import com.gm.content.commens.expection.BussinessExecption;
import com.gm.content.commens.expection.ResultEnum;
import com.gm.content.dao.mapper.DictionaryMapper;
import com.gm.content.dao.repository.DictionaryRepository;
import com.gm.content.domain.Dictionary;
import com.gm.content.service.IRedisCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@CacheConfig(cacheNames = "dictionaries")  //指定存放名称
public class RedisCRUDServiceImpl implements IRedisCRUDService {

    @Autowired
    DictionaryMapper dictionaryMapper;

    @Autowired
    DictionaryRepository dictionaryRepository;

    //#参数名”或者“#p参数index

    @Override
    @Cacheable(key = "#p0")
    public Dictionary selectDictionary(int id) {
        Dictionary byId = dictionaryMapper.findById(id);
        return byId;
    }

    @Override
//    @CacheEvict(key = "#id")
    @CacheEvict(key = "#p0")
    public void delDictionary(int id) {
        dictionaryMapper.delById(id);
        return;
    }

    @Override
    @CachePut(key = "#p0")
    /**
     * CachePut 存入redis中的数据是以,return的返回值作为 放入redis中的数据,key就是redis中key的名称
     */
    public Dictionary updateDictionary(int id, Dictionary dictionary) {

        dictionary.setDId(id);

        Optional<Dictionary> byId = dictionaryRepository.findById(dictionary.getDId());

        if (!byId.isPresent()) {
            throw new BussinessExecption(ResultEnum.ERROR);
        }

        dictionaryMapper.updateDictionary(dictionary);

        return dictionary;
    }


}
