package nhat.coder.library_manage.service;

import nhat.coder.library_manage.model.Book;
import nhat.coder.library_manage.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BookServiceImpl implements BookService{
    @Autowired
    BookRepository bookRepository;
    @Override
    public void save(Book book) {
        bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Long id, Book book) {
        bookRepository.save(book);
    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}
