package com.mt.mapper;

import com.mt.domain.Advertisement;
import com.mt.domain.Article;

import java.util.List;

public interface AdvertisementMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(Advertisement record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(Advertisement record);

    /**
     *
     * @mbggenerated
     */
    Advertisement selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Advertisement record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Advertisement record);

    List<Advertisement> list();

    int delById(Integer id);

    List<Advertisement> listByMemberId(Integer id);
}