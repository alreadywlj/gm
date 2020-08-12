package com.gm.content.dao.redis.impl;

import com.gm.content.dao.mapper.DictionaryMapper;
import com.gm.content.dao.redis.DictionariesRedis;
import com.gm.content.domain.Dictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DictionariesRedisImpl implements DictionariesRedis {

    @Autowired
    DictionaryMapper dictionaryMapper;

    @Override
    public Dictionary update(Dictionary dictionary) {
        return null;
    }

    @Override
    public void deleteDictionariesBySno(String sno) { }

    @Override
    public Dictionary queryDictionariesBySno(String sno) {
        return null;
    }
}
