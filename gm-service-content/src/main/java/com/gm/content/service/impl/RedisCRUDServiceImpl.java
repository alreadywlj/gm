package com.gm.content.service.impl;

import com.gm.content.dao.mapper.DictionaryMapper;
import com.gm.content.domain.Dictionary;
import com.gm.content.service.IRedisCRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = "dictionaries")
public class RedisCRUDServiceImpl implements IRedisCRUDService {

    @Autowired
    DictionaryMapper dictionaryMapper;

    @Override
    @Cacheable(key = "#p0")
    public Dictionary selectDictionary(String id) {
        Dictionary byId = dictionaryMapper.findById(id);
        return byId;
    }


}
