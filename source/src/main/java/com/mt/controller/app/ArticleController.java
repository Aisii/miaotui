package com.mt.controller.app;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mt.domain.Article;
import com.mt.interceptor.scope.Public;
import com.mt.service.ArticleService;
import com.mt.util.BaseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/app")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    @PostMapping("/article")
    public Object insert(HttpServletRequest request, Article one){
        BaseResult result = new BaseResult();
        articleService.addArticle(one);
        request.setAttribute("result", result);
        return "";
    }

    @PutMapping("/article/{id}")
    public Object update(HttpServletRequest request, @PathVariable Integer id, Article one) {
        BaseResult result = new BaseResult();
        one.setId(id);
        articleService.updateArticle(one);
        request.setAttribute("result", result);
        return "";
    }

    @DeleteMapping("/article/{id}")
    public Object del(HttpServletRequest request, @PathVariable Integer id) {
        BaseResult result = new BaseResult();
        articleService.delArticle(id);
        request.setAttribute("result", result);
        return "";
    }

    @GetMapping("/article/{id}")
    public Object get(HttpServletRequest request, @PathVariable Integer id) {
        BaseResult result = new BaseResult();
        Article one = articleService.getById(id);
        result.setData(one);
        request.setAttribute("result", result);
        return "";
    }

    @GetMapping("/article")
    @Public
    public Object list(HttpServletRequest request){
        BaseResult result = new BaseResult();
        PageHelper.startPage(1, 2);
        List<Article> list = articleService.list();
        PageInfo<Article> data = new PageInfo<>(list);
        result.setData(data);
        request.setAttribute("result", result);
        return "";
    }

}
