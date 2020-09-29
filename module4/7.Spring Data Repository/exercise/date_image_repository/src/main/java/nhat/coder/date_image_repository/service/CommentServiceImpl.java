package nhat.coder.date_image_repository.service;

import nhat.coder.date_image_repository.model.Comment;
import nhat.coder.date_image_repository.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;
static List<Long> list;
static {
    list = new ArrayList<>();
    list.add((long) 3);
    list.add((long) 4);
    list.add((long) 7);
}
    @Override
    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Comment> getAll() {
        return commentRepository.findAll();
    }

    @Override
    public Comment findById(Long id) {
        return commentRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Long id, Comment comment) {
        commentRepository.save(comment);
    }
    @Override
    public Page<Comment> findAll(Pageable pageable) {
        return commentRepository.findAll(pageable);
    }

    @Override
    public void deleteList() {
        commentRepository.deleteByIdIn(list);
    }
}
