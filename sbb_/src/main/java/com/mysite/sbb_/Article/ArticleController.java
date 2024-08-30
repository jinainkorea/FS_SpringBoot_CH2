package com.mysite.sbb_.Article;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequestMapping("/article")
@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Article> articleList = this.articleService.getList();
        model.addAttribute("articleList", articleList);
        return "article_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable Integer id) {
        Article article = (Article) this.articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article_detail";
    }

    @GetMapping("/create")
    public String ArticleCreate() {
        return "article_form";
    }

    @PostMapping("/create")
    public String ArticleCreate(@RequestParam(value="title") String title, @RequestParam(value="content") String content) {
        this.articleService.create(title, content);
        return "redirect:/article/list";
    }

}
