package nhat.coder.service;

import nhat.coder.model.Blog;
import nhat.coder.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogRepository blogRepository;

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public List<Blog> getAll() {
        return blogRepository.getAll();
    }

    @Override
    public Blog findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void update(Long id, Blog blog) {
        blogRepository.update(id,blog);
    }

    @Override
    public void remove(Blog blog) {
        blogRepository.remove(blog);
    }
}
