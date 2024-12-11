package com.mysite.sbb.domain.question;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository extends JpaRepository<Question,Integer> {
    Optional<List<Question>> findBySubject(String subject);
}
