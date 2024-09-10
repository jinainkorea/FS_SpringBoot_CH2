package com.mysite.sbb2_5.Article;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class ArticleController {
  private final ArticleService articleService;

  @GetMapping("/article/list")
  public String list(Model model) {
    model.addAttribute("articleList", this.articleService.getList());
    return "article_list";
  }
}
