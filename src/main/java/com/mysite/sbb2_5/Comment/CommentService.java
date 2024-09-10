package com.mysite.sbb2_5.Comment;

import com.mysite.sbb2_5.Article.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {
  private final CommentRepository commentRepository;

  public List<Comment> list() {
    return this.commentRepository.findAll();
  }

  public void create(Article article, String content) {
    Comment comment = new Comment();
    comment.setContent(content);
    comment.setCreateDate(LocalDateTime.now());
    comment.setArticle(article);
    this.commentRepository.save(comment);
  }
}
