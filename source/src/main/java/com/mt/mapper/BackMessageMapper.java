package com.mt.mapper;

import com.mt.domain.BackMessage;

import java.util.List;

public interface BackMessageMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(BackMessage record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(BackMessage record);

    /**
     *
     * @mbggenerated
     */
    BackMessage selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(BackMessage record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(BackMessage record);

    List<BackMessage> listByArticleId(Integer id);

    int delById(Integer id);
}