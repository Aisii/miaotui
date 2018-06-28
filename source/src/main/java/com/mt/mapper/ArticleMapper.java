package com.mt.mapper;

import com.mt.domain.Article;

import java.util.List;

public interface ArticleMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(Article record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(Article record);

    /**
     *
     * @mbggenerated
     */
    Article selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Article record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(Article record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Article record);

    List<Article> list();

    int delById(Integer id);

    List<Article> listByMemberId(Integer id);
}