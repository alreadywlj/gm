package com.gm.content.dao.mapper;

import com.gm.content.domain.Dictionary;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DictionaryMapper {

    List<Dictionary> findAllDic();
}
