package com.gm.content.controller;

import com.gm.content.domain.Article;
import com.gm.content.service.IArticleService;
import com.gm.content.service.IDictionariesService;
import io.swagger.models.Model;
import net.bytebuddy.implementation.bytecode.constant.DefaultValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.awt.*;
import java.awt.print.Pageable;

@RestController
@RequestMapping("/articles")
@CrossOrigin
public class ArticleController extends  BaseController {

    @Autowired
    IArticleService articleService;

    @RequestMapping
    public ModelAndView queryArticleList(@RequestParam(value = "offset", defaultValue = "0") Integer offset,
                                    @RequestParam(value = "limit", defaultValue = "10") Integer limit) {

        ModelAndView md = new ModelAndView();

        offset = offset > 0 ? 0 : offset;

        Sort sort = Sort.by(Sort.Direction.DESC, "a_id");

        PageRequest pageable = PageRequest.of(offset, limit, sort);

        Page<Article> articlePage = articleService.queryArticleList(offset, limit, pageable);

        md.addObject("articlePage", articlePage);

        return md;
    }

    @PostMapping
    public ModelAndView createArticle(@RequestBody Article article) {

        return null;
    }

    @PutMapping("/articles/{id}")
    public ModelAndView updArticle(@PathVariable(value = "id", required = true) String id) {

        return null;
    }

    @DeleteMapping("/articles/{id}")
    public ModelAndView delArticle(@PathVariable(value = "id", required = true) String id) {
        return null;
    }

    @GetMapping("/articles/{id}")
    public ModelAndView queryDetailArticle(@PathVariable(value = "id", required = true) String id) {
        return null;
    }
}
