package com.mt.controller.app;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mt.domain.Advertisement;
import com.mt.interceptor.scope.Public;
import com.mt.service.AdvertisementService;
import com.mt.util.BaseResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/app")
public class AdvertisementController {

    @Resource
    private AdvertisementService advertisementService;

    @PostMapping("/advertisement")
    public Object insert(HttpServletRequest request, Advertisement one){
        BaseResult result = new BaseResult();
        advertisementService.addAdvertisement(one);
        request.setAttribute("result", result);
        return "";
    }

    @PostMapping("/advertisement/{id}")
    public Object update(HttpServletRequest request, @PathVariable Integer id, Advertisement one) {
        BaseResult result = new BaseResult();
        one.setId(id);
        advertisementService.updateAdvertisement(one);
        request.setAttribute("result", result);
        return "";
    }

    @DeleteMapping("/advertisement/{id}")
    public Object del(HttpServletRequest request, @PathVariable Integer id) {
        BaseResult result = new BaseResult();
        advertisementService.delAdvertisement(id);
        request.setAttribute("result", result);
        return "";
    }

    @GetMapping("/advertisement/{id}")
    public Object get(HttpServletRequest request, @PathVariable Integer id) {
        BaseResult result = new BaseResult();
        Advertisement one = advertisementService.getById(id);
        result.setData(one);
        request.setAttribute("result", result);
        return "";
    }

    @GetMapping("/advertisement")
    @Public
    public Object list(HttpServletRequest request){
        BaseResult result = new BaseResult();
        PageHelper.startPage(1, 2);
        List<Advertisement> list = advertisementService.list();
        PageInfo<Advertisement> data = new PageInfo<>(list);
        result.setData(data);
        request.setAttribute("result", result);
        return "";
    }

}
