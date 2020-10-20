package nhat.coder.baithi.service.impl;

import nhat.coder.baithi.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface QuestionService {
    Page<Question> findAll(Pageable pageable);

    void save(Question question);

    Question findById(Long id);

    void update(Question question);

    void remove(Long id);
}
