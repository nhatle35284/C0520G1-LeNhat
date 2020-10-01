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
public static List<String> listErr;
static {
    listErr = new ArrayList<>();
    listErr.add("dm");
    listErr.add("clmm");
    listErr.add("vcl");
    listErr.add("sv");
    listErr.add("fuck you");
    listErr.add("fuck");
    listErr.add("con cac");
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

//    @Override
//    public void deleteList() {
//        commentRepository.deleteByIdIn(list);
//    }
}
