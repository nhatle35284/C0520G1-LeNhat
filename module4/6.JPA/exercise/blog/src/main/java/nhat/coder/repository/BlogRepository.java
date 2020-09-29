package nhat.coder.repository;

import nhat.coder.model.Blog;

import java.util.List;

public interface BlogRepository {
    void save(Blog blog);
    List<Blog> getAll();
    public Blog findById(Long id);
    public void update(Long id, Blog blog);
    void remove(Blog blog);
}
