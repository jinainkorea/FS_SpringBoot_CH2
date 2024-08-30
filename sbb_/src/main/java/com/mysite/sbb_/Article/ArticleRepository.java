package com.mysite.sbb_.Article;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    Article findByTitle(String title);
    Article findByTitleAndContent(String title, String content);
    List<Article> findByTitleLike(String title);
}
