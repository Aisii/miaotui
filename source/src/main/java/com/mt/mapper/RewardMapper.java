package com.mt.mapper;

import com.mt.domain.Member;
import com.mt.domain.Reward;

import java.util.List;

public interface RewardMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(Reward record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(Reward record);

    /**
     *
     * @mbggenerated
     */
    Reward selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Reward record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Reward record);

    List<Reward> list();
}