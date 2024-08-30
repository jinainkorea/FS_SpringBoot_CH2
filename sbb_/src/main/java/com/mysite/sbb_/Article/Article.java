package com.mysite.sbb_.Article;

import com.mysite.sbb_.Comment.Comment;
import java.util.List;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "article", cascade = CascadeType.REMOVE)
    private List<Comment> CommentList;
}
