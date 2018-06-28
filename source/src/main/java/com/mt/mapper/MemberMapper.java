package com.mt.mapper;

import com.mt.domain.Member;

import java.util.List;

public interface MemberMapper {
    /**
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int insert(Member record);

    /**
     *
     * @mbggenerated
     */
    int insertSelective(Member record);

    /**
     *
     * @mbggenerated
     */
    Member selectByPrimaryKey(Integer id);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Member record);

    /**
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Member record);

    Member getMemberByNameAndPwd(Member one);

    List<Member> list();

    int delById(Integer id);
}