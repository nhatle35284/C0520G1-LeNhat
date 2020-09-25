package nhat.coder.service;

import nhat.coder.model.Blog;

import java.util.List;

public interface BlogService {
    void save(Blog blog);
    List<Blog> getAll();
    public Blog findById(Long id);
    public void update(int id, Blog blog);
    void remove(Blog blog);
}
