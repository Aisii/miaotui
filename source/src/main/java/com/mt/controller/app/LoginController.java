package com.mt.controller.app;

import com.mt.domain.Member;
import com.mt.interceptor.scope.Public;
import com.mt.service.MemberService;
import com.mt.util.BaseResult;
import com.mt.util.Const;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Public
@Controller
@RequestMapping("/app")
public class LoginController {

    @Resource
    private MemberService memberService;

    @PostMapping("/login")
    public Object appLogin(HttpServletRequest request, @RequestBody Member one){
        BaseResult result = new BaseResult();
        Member m = memberService.getMemberByNameAndPwd(one);
        if(m == null){
            result.setCode(-1);
            result.setMessage("用户名或密码错误！");
            return result;
        }else if(m.getStatus() == 0){
            result.setCode(-1);
            result.setMessage("用户异常！");
            return result;
        }else {
            request.getSession().setAttribute(Const.SESSION_KEY, m);
        }
        request.setAttribute("result", result);
        return "";
    }

    @PostMapping("/logout")
    public Object appLogout(HttpServletRequest request){
        BaseResult result = new BaseResult();
        request.getSession().setAttribute(Const.SESSION_KEY, null);
        request.setAttribute("result", result);
        return "";
    }

}
