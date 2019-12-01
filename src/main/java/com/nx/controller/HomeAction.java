package com.nx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeAction {

    @RequestMapping({"home", "index"})
    public String hellow() {
        return "home";
    }
}
