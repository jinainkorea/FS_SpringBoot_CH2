package com.mysite.sbb2_5.Article;

import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
public class ArticleController {
  private final ArticleService articleService;

  @GetMapping("/article/list")
  public String list(Model model) {
    model.addAttribute("articleList", this.articleService.getList());
    return "article_list";
  }

  @GetMapping("/article/detail/{id}")
  public String detail(Model model, @PathVariable("id") Integer id) {
    Optional<Article> article = this.articleService.getArticleById(id);
    if (article.isPresent()) {
      model.addAttribute("article", article.get());
    }
    return "article_detail";
  }
}
