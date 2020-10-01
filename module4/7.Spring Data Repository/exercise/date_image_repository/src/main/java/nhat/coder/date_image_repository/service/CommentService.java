package nhat.coder.date_image_repository.service;

import nhat.coder.date_image_repository.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CommentService {
    void save(Comment comment);
    List<Comment> getAll();
    public Comment findById(Long id);
    public void update(Long id, Comment comment);
    public Page<Comment> findAll(Pageable pageable);
//    public void deleteList();
}
