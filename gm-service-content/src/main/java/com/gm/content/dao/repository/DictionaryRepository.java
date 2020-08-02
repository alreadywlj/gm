package com.gm.content.dao.repository;

import com.gm.content.domain.Dictionary;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryRepository extends PagingAndSortingRepository<Dictionary,String> {

    @Override
    List<Dictionary> findAll();
}
