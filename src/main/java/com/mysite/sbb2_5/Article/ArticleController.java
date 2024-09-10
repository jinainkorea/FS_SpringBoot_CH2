package com.mysite.sbb2_5.Article;

import com.mysite.sbb2_5.Comment.Comment;
import com.mysite.sbb2_5.Comment.CommentForm;
import com.mysite.sbb2_5.Comment.CommentService;
import jakarta.validation.Valid;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("article")
public class ArticleController {
  private final ArticleService articleService;

  @GetMapping("/list")
  public String list(Model model) {
    model.addAttribute("articleList", this.articleService.getList());
    return "article_list";
  }

  @GetMapping("/detail/{id}")
  public String detail(Model model, @PathVariable("id") Integer id, CommentForm commentForm, BindingResult bindingResult) {
    Article article = this.articleService.getArticleById(id).get();
    model.addAttribute("article", article);
    return "article_detail";
  }

  @GetMapping("/create")
  public String create(Model model, ArticleForm articleForm) {
    return "article_form";
  }

  @PostMapping("/create")
  public String create(@Valid ArticleForm articleForm, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "article_form";
    }
    this.articleService.create(articleForm);
    return "redirect:/article/list";
  }
}
