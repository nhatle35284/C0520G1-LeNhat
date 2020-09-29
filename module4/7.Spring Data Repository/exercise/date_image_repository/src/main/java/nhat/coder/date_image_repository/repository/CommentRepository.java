package nhat.coder.date_image_repository.repository;

import nhat.coder.date_image_repository.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CommentRepository extends JpaRepository<Comment, Long> {
    void deleteByIdIn(List<Long> idList);
}
