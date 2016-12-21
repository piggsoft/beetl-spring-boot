package com.piggsoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * Created by piggs on 2016/12/21.
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model, HttpSession session) {
        return "/index";
    }

    @RequestMapping("/admin")
    public String admin(Model model, HttpSession session) {
        model.addAttribute("title", "this is a title");
        return "/admin/index";
    }

}
