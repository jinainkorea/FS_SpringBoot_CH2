package com.mysite.sbb_.Comment;

import com.mysite.sbb_.Article.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public void createComment(Article article, String comment) {
        Comment comment_obj = new Comment();
        comment_obj.setComment(comment);
        comment_obj.setCreateDate(LocalDateTime.now());
        comment_obj.setArticle(article);
        this.commentRepository.save(comment_obj);
    }
}
