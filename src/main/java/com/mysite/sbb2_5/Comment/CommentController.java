package com.mysite.sbb2_5.Comment;

import com.mysite.sbb2_5.Article.Article;
import com.mysite.sbb2_5.Article.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("comment")
public class CommentController {
  private final CommentService commentService;
  private final ArticleService articleService;

//  여기여기
  @PostMapping("/create/{id}")
  public String createComment(@PathVariable("id") Integer id, CommentForm commentForm, BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return "article_detail";
    }
    Article article = this.articleService.getArticleById(id).get();
    this.commentService.create(article, commentForm.getContent());
    return String.format("redirect:/article/detail/%s", id);
  }
}
