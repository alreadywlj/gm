package com.gm.content.controller;

import com.gm.content.domain.Article;
import com.gm.content.domain.ResponseResult;
import com.gm.content.service.IArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/articles")
@CrossOrigin
public class ArticleController {

    @Autowired
    IArticleService articleService;

    @GetMapping
    public ResponseResult queryArticleList(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                           @RequestParam(value = "limit", defaultValue = "10") Integer limit) {

        offset = offset > 0 ? 0 : offset;

        Sort sort = Sort.by(Sort.Direction.DESC, "aId");

        PageRequest pageable = PageRequest.of(offset, limit, sort);

        Page<Article> articlePage = articleService.queryArticleList(offset, limit, pageable);

        return new ResponseResult(articlePage);

    }

    @PostMapping
    public ResponseResult createArticle(@Validated @RequestBody Article article) {
        return null;
    }

    @PutMapping("/{id}")
    public ResponseResult updArticle(@PathVariable(value = "id", required = true) String id, @Validated @RequestBody Article article) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseResult delArticle(@PathVariable(value = "id", required = true) String id) {
        return null;
    }

    @GetMapping("/{id}")
    public ResponseResult queryDetailArticle(@PathVariable(value = "id", required = true) String id) {
        return null;
    }


}
