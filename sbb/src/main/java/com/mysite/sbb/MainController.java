package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/")
    @ResponseBody
    public String index() {
        return "index";
    }

    @GetMapping("/article/list")
    @ResponseBody
    public String list() {
        return "article_list";
    }
}
