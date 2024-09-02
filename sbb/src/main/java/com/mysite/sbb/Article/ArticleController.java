package com.mysite.sbb.Article;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ArticleController {
    @GetMapping("article/list")
    @ResponseBody
    public String index() {
        return "article/list";
    }
}
