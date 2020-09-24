package nhat.coder.repository;

import nhat.coder.model.Test;

import java.util.List;

public interface CommentRepository {
    void save(Test comment);
    List<Test>  getAll();
}
