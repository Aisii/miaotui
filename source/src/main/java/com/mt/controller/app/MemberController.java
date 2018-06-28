package com.mt.controller.app;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mt.domain.Member;
import com.mt.interceptor.scope.Public;
import com.mt.mapper.MemberMapper;
import com.mt.service.MemberService;
import com.mt.util.BaseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.KeyStore;
import java.util.List;

@Controller
@RequestMapping("/app")
public class MemberController {

    @Resource
    private MemberService memberService;

    @RequestMapping(value = "/member", method = RequestMethod.POST)
    public Object insert(HttpServletRequest request, Member one){
        BaseResult result = new BaseResult();
        memberService.addMember(one);
        request.setAttribute("result", result);
        return "";
    }

    @RequestMapping(value = "/member/{id}", method = RequestMethod.PUT)
    public Object update(HttpServletRequest request, @PathVariable Integer id, Member one) {
        BaseResult result = new BaseResult();
        one.setId(id);
        memberService.updateMember(one);
        request.setAttribute("result", result);
        return "";
    }

    @RequestMapping(value = "/member/{id}", method = RequestMethod.DELETE)
    public Object del(HttpServletRequest request, @PathVariable Integer id) {
        BaseResult result = new BaseResult();
        memberService.delMember(id);
        request.setAttribute("result", result);
        return "";
    }

    @RequestMapping(value = "/member/{id}", method = RequestMethod.GET)
    public Object get(HttpServletRequest request, @PathVariable Integer id) {
        BaseResult result = new BaseResult();
        Member one = memberService.getById(id);
        result.setData(one);
        request.setAttribute("result", result);
        return "";
    }

    @RequestMapping(value = "/member", method = RequestMethod.GET)
    @Public
    public Object list(HttpServletRequest request){
        BaseResult result = new BaseResult();
        PageHelper.startPage(1, 2);
        List<Member> list = memberService.list();
        PageInfo<Member> data = new PageInfo<>(list);
        result.setData(data);
        request.setAttribute("result", result);
        return "";
    }

}
