package nhat.coder.baithi.repository;

import nhat.coder.baithi.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question,Long> {
}
