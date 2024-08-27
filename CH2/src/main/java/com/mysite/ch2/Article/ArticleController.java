package com.mysite.ch2.Article;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.data.domain.Page;
import lombok.RequiredArgsConstructor;

@RequestMapping("/article")
@RequiredArgsConstructor
@Controller
public class ArticleController {

    private final ArticleRepository articleRepository;
    private final ArticleService articleService;

    @GetMapping("/list")
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
        Page<Article> paging = this.articleService.getList(page);
        model.addAttribute("paging", paging);
        return "article_list";
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Article article = this.articleService.getArticle(id);
        model.addAttribute("article", article);
        return "article_detail";
    }

    @GetMapping("/create")
    public String articleCreate(ArticleForm articleForm) {
        return "article_form";
    }

    @PostMapping("/create")
    public String articleCreate(@Valid ArticleForm articleForm, BindingResult bindingResult) {
        // TODO 질문을 저장한다.
        if (bindingResult.hasErrors()) {
            return "article_form";
        }
        this.articleService.create(articleForm.getTitle(), articleForm.getContent());
        return "redirect:/article/list"; // 질문 저장후 질문목록으로 이동
    }
}