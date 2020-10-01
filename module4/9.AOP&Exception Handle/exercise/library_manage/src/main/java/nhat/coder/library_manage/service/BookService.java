package nhat.coder.library_manage.service;

import nhat.coder.library_manage.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BookService {
    void save(Book book);
    List<Book> getAll();
    public Book findById(Long id);
    public void update(Long id, Book book);
    public Page<Book> findAll(Pageable pageable);
}
