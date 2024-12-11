package com.mysite.sbb;

import com.mysite.sbb.domain.answer.Answer;
import com.mysite.sbb.domain.answer.AnswerRepository;
import com.mysite.sbb.domain.question.Question;
import com.mysite.sbb.domain.question.QuestionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;

	@Test
	void jpaQuestionSave() {
		Question q = Question.builder()
				.subject("sbb가 무엇인가요?")
				.content("sbb에 대해서 알고 싶습니다.")
				.build();
		this.questionRepository.save(q);
	}

	@Test
	void jpaQuestionSave2() {
		Question q = Question.builder()
				.subject("스프링부트 모델 질문입니다.")
				.content("id는 자동으로 생성되나요?")
				.build();
		this.questionRepository.save(q);
	}

	@Test
	void jpaFindAll() {
		List<Question> list = this.questionRepository.findAll();
		assertEquals(2,list.size());
		Question q = list.get(0);
		assertEquals("sbb가 무엇인가요?", q.getSubject());
	}

	@Test
	void jpaFindById() {
		Optional<Question> oq = this.questionRepository.findById(1);
		if(oq.isPresent()){
			Question q = oq.get();
			assertEquals("sbb가 무엇인가요?", q.getSubject());
		}
	}

	@Test
	void jpaFindBySubject() {
		Optional<List<Question>> olq =
				this.questionRepository.findBySubject("sbb가 무엇인가요?");
		if(olq.isPresent()){
			List<Question> lq = olq.get();
			assertEquals("sbb가 무엇인가요?", lq.get(0).getSubject());
		}
	}

	@Test
	void jpaUpdateQuestion() {
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		q.updateSubject("수정된 제목");
		this.questionRepository.save(q);
	}

	@Test
	void jpaDeleteQuestion() {
		Optional<Question> oq = this.questionRepository.findById(1);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		this.questionRepository.delete(q);
		assertEquals(1, this.questionRepository.count());
	}

	@Test
	void jpaCreateAnswer() {
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();
		Answer a = Answer.builder()
				.question(q)
				.content("네 자동으로 생성됩니다.")
				.build();
		this.answerRepository.save(a);
	}

	@Transactional
	@Test
	void jpaQuesitonsAnswerList() {
		Optional<Question> oq = this.questionRepository.findById(2);
		assertTrue(oq.isPresent());
		Question q = oq.get();

		List<Answer> answerList = q.getAnswerList();

		assertEquals(1, answerList.size());
		assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
	}
}
