package com.gm.content.dao.mapper;

import com.gm.content.domain.Dictionary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DictionaryMapper {

    List<Dictionary> findAllDic();

    Dictionary findById(@Param("id") int id);

    void delById(int id);

    int updateDictionary(Dictionary id);
}
