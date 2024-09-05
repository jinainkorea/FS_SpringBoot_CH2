package com.mysite.sbb_3.Article;

import java.util.List;
import java.util.Optional;

import com.mysite.sbb_3.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService {
    private final ArticleRepository articleRepository;

    public List<Article> getList() {
        return this.articleRepository.findAll();
    }

    public Article getArticleById(Integer id) {
        Optional<Article> article = this.articleRepository.findById(id);
        if(article.isPresent()) {
            return article.get();
        } else {
            throw new DataNotFoundException("Article Not Found");
        }
    }
}
