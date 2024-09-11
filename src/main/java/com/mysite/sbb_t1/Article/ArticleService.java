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

  public Article getArticleById(Integer id) {
    Optional<Article> articleObj = this.articleRepository.findById(id);
    if (articleObj.isEmpty()) {
      throw new RuntimeException("article이 존재하지 않습니다.");
    }
    return articleObj.get();
  }
}
