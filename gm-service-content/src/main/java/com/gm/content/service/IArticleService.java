package com.gm.content.service;

import com.gm.content.domain.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface IArticleService {
    Page<Article> queryArticleList(Integer offset, Integer limit, PageRequest pageable);
}
