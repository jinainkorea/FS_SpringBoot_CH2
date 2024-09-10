package com.mysite.sbb2_5.Comment;

import com.mysite.sbb2_5.Article.Article;
import com.mysite.sbb2_5.Article.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("comment")
public class CommentController {
  private final CommentService commentService;
  private final ArticleService articleService;

  @PostMapping("/create/{id}")
  public String createComment(@PathVariable("id") Integer id, @RequestParam("content") String content) {
    Article article = this.articleService.getArticleById(id).get();
    this.commentService.create(article, content);
    return String.format("redirect:/article/detail/%s", id);
  }
}
