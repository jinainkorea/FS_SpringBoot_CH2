package com.mysite.ch2.Comment;

import com.mysite.ch2.Article.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;


    public void create(Article article, String content) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setCreateDate(LocalDateTime.now());
        comment.setArticle(article);
        this.commentRepository.save(comment);
    }
}