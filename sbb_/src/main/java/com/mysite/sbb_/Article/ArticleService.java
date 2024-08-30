package com.mysite.sbb_.Article;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getAllArticle() {
        return this.articleRepository.findAll();
    }
}
