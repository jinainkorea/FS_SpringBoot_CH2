package com.mysite.sbb.Comment;

import com.mysite.sbb.Article.Article;
import com.mysite.sbb.Article.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("comment")
@RequiredArgsConstructor
@Controller
public class CommentController {
    private final CommentService commentService;
    private final ArticleService articleService;


//    @GetMapping("/create/{id}")
//    public String index() {
//        return "hi";
//    }

    @PostMapping("/create/{id}")
    public String create(Model model, @PathVariable("id") Integer id, @RequestParam(value="comment") String content) {
        Article article = this.articleService.getArticleById(id);
        this.commentService.createComment(article, content);
        return String.format("redirect:/article/detail/%s", id);
    }
}
