package com.mysite.sbb.domain.question;


import com.mysite.sbb.domain.answer.Answer;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 200)
    private String subject;

    @Column(columnDefinition = "TEXT")
    private String content;

    private LocalDateTime createDate;

    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;

    @Builder
    public Question(String subject, String content){
        this.subject=subject;
        this.content=content;
        this.createDate = LocalDateTime.now();
    }

    public void updateContent(String content){
        this.content=content;
    }
    public void updateSubject(String subject){
        this.subject=subject;
    }
}
