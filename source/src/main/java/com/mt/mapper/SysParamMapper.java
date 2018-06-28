package com.mt.mapper;

import com.mt.domain.SysParam;

public interface SysParamMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(SysParam record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(SysParam record);

    /**
     *
     * @mbggenerated
     */
    SysParam selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(SysParam record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(SysParam record);
}