package com.mysite.sbb_3.Article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleRepository articleRepository;

    @GetMapping("/article")
    public String list(Model model){
        List<Article> articleList = this.articleRepository.findAll();
        model.addAttribute("articleList", articleList);
        return "article_list";
    }
}
