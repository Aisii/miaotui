package com.mt.service;

import com.mt.domain.Member;
import com.mt.mapper.MemberMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberService {

    @Resource
    private MemberMapper memberMapper;

    public int addMember(Member one){
        return memberMapper.insertSelective(one);
    }

    public int updateMember(Member one){
        return memberMapper.updateByPrimaryKeySelective(one);
    }

    public int delMember(Integer id){
        return memberMapper.delById(id);
    }

    public Member getById(Integer id){
        return memberMapper.selectByPrimaryKey(id);
    }

    public Member getMemberByNameAndPwd(Member one){
        return memberMapper.getMemberByNameAndPwd(one);
    }

    public List<Member> list(){
        return memberMapper.list();
    }
}
