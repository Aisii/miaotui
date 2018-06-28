package com.mt.controller.app;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mt.domain.Reward;
import com.mt.interceptor.scope.Public;
import com.mt.service.RewardService;
import com.mt.util.BaseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/app")
public class RewardServiceController {

    @Resource
    private RewardService rewardService;

    @RequestMapping(value = "/reward", method = RequestMethod.POST)
    public Object insert(HttpServletRequest request, Reward one){
        BaseResult result = new BaseResult();
        rewardService.addReward(one);
        request.setAttribute("result", result);
        return "";
    }

    @RequestMapping(value = "/reward/{id}", method = RequestMethod.PUT)
    public Object update(HttpServletRequest request, @PathVariable Integer id, Reward one) {
        BaseResult result = new BaseResult();
        one.setId(id);
        rewardService.updateReward(one);
        request.setAttribute("result", result);
        return "";
    }

    @RequestMapping(value = "/Reward/{id}", method = RequestMethod.DELETE)
    public Object del(HttpServletRequest request, @PathVariable Integer id) {
        BaseResult result = new BaseResult();
        request.setAttribute("result", result);
        return "";
    }

    @RequestMapping(value = "/Reward/{id}", method = RequestMethod.GET)
    public Object get(HttpServletRequest request, @PathVariable Integer id) {
        BaseResult result = new BaseResult();
        request.setAttribute("result", result);
        return "";
    }

    @RequestMapping(value = "/Reward", method = RequestMethod.GET)
    @Public
    public Object list(HttpServletRequest request){
        BaseResult result = new BaseResult();
        PageHelper.startPage(1, 2);
        List<Reward> list = rewardService.list();
        PageInfo<Reward> data = new PageInfo<>(list);
        result.setData(data);
        request.setAttribute("result", result);
        return "";
    }

}
