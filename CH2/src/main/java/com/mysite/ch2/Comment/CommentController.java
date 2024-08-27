package com.mysite.ch2.Comment;

import com.mysite.ch2.Article.Article;
import com.mysite.ch2.Article.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/comment")
@RequiredArgsConstructor
@Controller
public class CommentController {

    private final ArticleService articleService;
    private final CommentService commentService;

    @GetMapping("/create")
    public String commentCreate(CommentForm commentForm) {
        return "comment_form";
    }

    @PostMapping("/create/{id}")
    public String createComment(Model model, @PathVariable("id") Integer id, @RequestParam(value="content") String content) {
        Article article = this.articleService.getArticle(id);
        // TODO: 답변을 저장한다.
        this.commentService.create(article, content);
        return String.format("redirect:/article/detail/%s", id);
    }
}