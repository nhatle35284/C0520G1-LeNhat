package nhat.coder.bai_thi_thuc_hanh.service;

import nhat.coder.bai_thi_thuc_hanh.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionService {
    Page<Question> findAll(Pageable pageable);

    void save(Question question);

    Question findById(Long id);

    void update(Question question);

    void remove(Long id);

    Page<Question> findAllByTitleOrQuestionContextOrAnswer(String title,Pageable pageable);


    Page<Question> findAllByTitleContaining(String title,Pageable pageable);


    Page<Question> findAllByQuestionContextContaining(String question,Pageable pageable);
//    Page<Question> findAllByTitleOrQuestionContextOrAnswerOrUserCreate(String title);
}
