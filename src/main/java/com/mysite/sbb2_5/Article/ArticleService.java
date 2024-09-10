package com.mysite.sbb2_5.Article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
