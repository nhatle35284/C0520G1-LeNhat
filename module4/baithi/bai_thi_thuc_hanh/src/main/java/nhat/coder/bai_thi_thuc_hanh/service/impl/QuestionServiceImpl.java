package nhat.coder.bai_thi_thuc_hanh.service.impl;

import nhat.coder.bai_thi_thuc_hanh.model.Question;
import nhat.coder.bai_thi_thuc_hanh.repository.QuestionRepository;
import nhat.coder.bai_thi_thuc_hanh.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    @Override
    public Page<Question> findAll(Pageable pageable) {
        return questionRepository.findAll(pageable);
    }

    @Override
    public void save(Question question) {
        questionRepository.save(question);
    }

    @Override
    public Question findById(Long id) {
        return questionRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Question question) {
        questionRepository.save(question);
    }

    @Override
    public void remove(Long id) {
        questionRepository.deleteById(id);
    }

    @Override
    public Page<Question> findAllByTitleOrQuestionContextOrAnswer(String title, Pageable pageable) {
        return questionRepository.findQuestionByTitleContainingOrQuestionContextOrAnswerContaining(title,title,title,pageable);
    }

//    @Override
//    public Page<Question> findAllByTitleOrQuestionContextOrAnswerOrUserCreate(String title) {
//        return questionRepository.findAllByTitleOrQuestionContextOrAnswerOrUserCreate(title,title,title,title);
//    }
}
