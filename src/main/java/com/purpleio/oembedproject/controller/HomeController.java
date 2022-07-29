package com.purpleio.oembedproject.controller;

import com.purpleio.oembedproject.common.UrlConstants;
import com.purpleio.oembedproject.dto.UrlDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping(UrlConstants.BASE)
    public String home(Model model) {
        model.addAttribute("urlDto", new UrlDto());
        return "home";
    }
}
