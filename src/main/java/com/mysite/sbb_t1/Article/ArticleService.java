package com.mysite.sbb_t1.Article;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArticleService {
  private final ArticleRepository articleRepository;

  public List<Article> getList() {
    return this.articleRepository.findAll();
  }
}
