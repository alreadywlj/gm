package com.gm.content.dao.repository;

import com.gm.content.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, String> {

    @Modifying
    @Query(value = "delete FROM article a where a.a_id =?1",nativeQuery = true) //使用原生sql时需加上nativeQuery
    Integer deleteByAId(String id);


    List<Article> findByTitle(String title);
}
