package com.mysite.sbb_.Article;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/article/list")
    public String list(Model model) {
        List<Article> articles = this.articleService.getAllArticle();
        model.addAttribute("articles", articles);
        return "article_list";
    }

}
