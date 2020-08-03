package com.gm.content.service.impl;

import com.gm.content.commens.expection.BussinessExecption;
import com.gm.content.commens.expection.ResultEnum;
import com.gm.content.dao.repository.ArticleRepository;
import com.gm.content.domain.Article;
import com.gm.content.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public Page<Article> queryArticleList(Integer offset, Integer limit, PageRequest pageable) {
        return articleRepository.findAll(pageable);
    }

}
