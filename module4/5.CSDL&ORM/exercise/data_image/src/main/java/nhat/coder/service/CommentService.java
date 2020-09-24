package nhat.coder.service;

import nhat.coder.model.Test;

import java.util.List;

public interface CommentService {
    void save(Test comment);
    List<Test> getAll();
}
