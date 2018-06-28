package com.mt.controller;

import com.mt.interceptor.scope.Public;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Public
public class MainController {

    @GetMapping("/app")
    public Object app(){
        return "app/index";
    }

    @GetMapping("/manage")
    public Object manage(){
        return "app/index";
    }

}
