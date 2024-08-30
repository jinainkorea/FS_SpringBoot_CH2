package com.mysite.sbb_.Comment;

import com.mysite.sbb_.Article.Article;
import com.mysite.sbb_.Article.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@RequestMapping("comment")
@RequiredArgsConstructor
@Controller
public class CommentController {
    private final ArticleService articleService;
    private final CommentService commentService;

    @PostMapping("/create/{id}")
    public String createComment(Model model, @PathVariable("id") Integer id, @RequestParam(value="comment") String comment) {
        Article article = (Article) this.articleService.getArticle(id);
        this.commentService.createComment(article, comment);
        return String.format("redirect:/article/detail/%s", id);
    }
}
