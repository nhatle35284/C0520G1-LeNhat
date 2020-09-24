package nhat.coder.service;

import nhat.coder.model.Test;
import nhat.coder.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepository commentRepository;

    @Override
    public void save(Test comment) {
        commentRepository.save(comment);
    }

    @Override
    public List<Test> getAll() {
        return commentRepository.getAll();
    }
}
