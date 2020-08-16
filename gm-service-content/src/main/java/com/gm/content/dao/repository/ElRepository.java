package com.gm.content.dao.repository;

import com.gm.content.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

@Component
public interface ElRepository extends ElasticsearchRepository<Article, String> {
}
