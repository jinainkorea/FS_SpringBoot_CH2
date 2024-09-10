package com.mysite.sbb2_5.Article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ArticleService {
  private final ArticleRepository articleRepository;

  public List<Article> getList() {
    return this.articleRepository.findAll();
  }
}
