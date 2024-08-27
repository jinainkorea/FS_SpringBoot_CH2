package com.mysite.ch2;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.ch2.Article.ArticleService;

@SpringBootTest
class Ch2ApplicationTests {

    @Autowired
    private ArticleService articleService;

    @Test
    void testJpa() {
        for (int i = 1; i <= 50; i++) {
            String title = String.format("테스트 데이터입니다", i);
            String content = "내용무";
            this.articleService.create(title, content);
        }
    }
}