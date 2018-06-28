package com.mt.service;

import com.mt.domain.Article;
import com.mt.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ArticleService {

    @Resource
    private ArticleMapper articleMapper;

    public int addArticle(Article one){
        return articleMapper.insertSelective(one);
    }

    public int updateArticle(Article one){
        return articleMapper.updateByPrimaryKeyWithBLOBs(one);
    }

    public int delArticle(Integer id){
        return articleMapper.delById(id);
    }

    public List<Article> list(){
        return articleMapper.list();
    }

    public Article getById(Integer id){
        return articleMapper.selectByPrimaryKey(id);
    }

    public List<Article> listByMemberId(Integer id){
        return articleMapper.listByMemberId(id);
    }

}
