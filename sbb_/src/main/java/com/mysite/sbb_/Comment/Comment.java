package com.mysite.sbb_.Comment;

import com.mysite.sbb_.Article.Article;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "TEXT")
    private String comment;

    private LocalDateTime createDate;

    @ManyToOne
    private Article article;
}
