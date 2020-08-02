package com.gm.content.dao.redis;

import com.gm.content.domain.Dictionary;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

@CacheConfig(cacheNames = " Dictionaries")
@Repository
public interface DictionariesRedis {

    @CachePut(key = "#p0.sno")
    Dictionary update(Dictionary dictionary);

    @CacheEvict(key = "#p0", allEntries = true)
    void deleteDictionariesBySno(String sno);

    @Cacheable(key = "#p0")
    Dictionary queryDictionariesBySno(String sno);

}
