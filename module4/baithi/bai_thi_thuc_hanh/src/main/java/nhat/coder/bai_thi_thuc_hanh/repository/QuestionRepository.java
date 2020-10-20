package nhat.coder.bai_thi_thuc_hanh.repository;

import nhat.coder.bai_thi_thuc_hanh.model.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    Page<Question> findQuestionByTitleContainingOrQuestionContextOrAnswerContaining(String title,String questionContext,String answer,Pageable pageable);
//    Page<Question> findAllByTitleOrQuestionContextOrAnswerOrUserCreate(String title,String questionContext,String answer,String user);
}
