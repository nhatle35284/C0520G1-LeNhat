package nhat.coder.service;

import nhat.coder.model.Comment;

import java.util.List;

public interface CommentService {
    void save(Comment comment);
    List<Comment> getAll();
    public Comment findById(int id);
    public void update(int id, Comment comment);
}
