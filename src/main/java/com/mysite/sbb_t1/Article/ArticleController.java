package com.mysite.sbb_t1.Article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}