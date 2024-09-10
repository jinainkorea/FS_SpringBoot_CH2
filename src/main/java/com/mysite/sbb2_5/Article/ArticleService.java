package com.mysite.sbb2_5.Article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ArticleService {
  private final ArticleRepository articleRepository;

  public List<Article> getList() {
    return this.articleRepository.findAll();
  }

  public Optional<Article> getArticleById(Integer id) {
    return this.articleRepository.findById(id);
  }

  public void create(ArticleForm articleForm) {
    Article article = new Article();
    article.setTitle(articleForm.getTitle());
    article.setContent(articleForm.getContent());
    article.setCreateDate(LocalDateTime.now());
    this.articleRepository.save(article);
  }
}
