package com.gm.content.service;

import com.gm.content.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Optional;

public interface IArticleService {
    Page<Article> queryArticleList(Integer offset, Integer limit, PageRequest pageable);

    boolean createArticle(Article article);

    boolean updArticle(Article article, String id);

    boolean delArticle(String id);

    Optional<Article> queryDetailArticle(String id);
}
