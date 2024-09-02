package com.mysite.sbb.Article;

import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getArticle() {
        return this.articleRepository.findAll();
    }
}
