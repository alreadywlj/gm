package com.gm.content.service.impl;

import com.gm.content.dao.repository.ArticleRepository;
import com.gm.content.domain.Article;
import com.gm.content.service.IArticleService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ArticleServiceImpl implements IArticleService {

    @Autowired
    ArticleRepository articleRepository;

    @Override
    public Page<Article> queryArticleList(Integer offset, Integer limit, PageRequest pageable) {
        return articleRepository.findAll(pageable);
    }

    @Override
    public boolean createArticle(Article article) {

        String uuid = UUID.randomUUID().toString().replace("-", "");

        article.setAId(uuid);

        return articleRepository.findByTitle(article.getTitle()).isEmpty()
                ? !StringUtils.isBlank(articleRepository.save(article).getAId())
                : false;

    }

    @Override
    public boolean updArticle(Article article, String id) {

        article.setAId(id);

        return articleRepository.save(article).getAId() != null;

    }

    @Override
    public boolean delArticle(String id) {
        return articleRepository.deleteByAId(id) > 0;
    }

    @Override
    public Optional<Article> queryDetailArticle(String id) {
       return  articleRepository.findById(id);
    }

}
