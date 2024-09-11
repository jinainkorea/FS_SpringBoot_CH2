package com.mysite.sbb_t1.Article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ArticleService {
  private final ArticleRepository articleRepository;

  public List<Article> getList() {
    return this.articleRepository.findAll();
  }

  public void create(String title, String content) {
    Article article = new Article();
    article.setTitle(title);
    article.setContent(content);
    article.setCreateDate(LocalDateTime.now());
    articleRepository.save(article);
  }

  public Optional<Article> getArticleById(Integer id) {
    return this.articleRepository.findById(id);
  }
}
