package com.mysite.sbb_t1.Article;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("article")
@Controller
@RequiredArgsConstructor
public class ArticleController {
  private final ArticleService articleService;

  @GetMapping("/list")
  public String list(Model model) {
    List<Article> articleList = this.articleService.getList();
    model.addAttribute("articleList", articleList);
    return "article_list";
  }

  @GetMapping("/create")
  public String create(ArticleForm articleForm) {
    return "article_form";
  }

  @PostMapping("/create")
  public String createArticle(@Valid ArticleForm articleForm, BindingResult bindingResult) {
    if(bindingResult.hasErrors()) {
      return "article_form";
    }
    this.articleService.create(articleForm.getTitle(), articleForm.getContent());
    return "redirect:/";
  }

  @GetMapping("/detail/{id}")
  public String detail(Model model, @PathVariable("id") Integer id) {
    Article article = this.articleService.getArticleById(id).get();
    model.addAttribute("article", article);
    return "article_detail";
  }
}
