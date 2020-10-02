package nhat.coder.library_manage.service;

import nhat.coder.library_manage.model.Book;
import nhat.coder.library_manage.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService{
    public static Map<Long,Book> bookMap = new HashMap<>();
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
    public boolean rentBook(Book book) {
        for (Book temp: bookRepository.findAll()){
            bookMap.put(temp.getId(),temp);
        }
        if (bookMap==null){
            throw new NullPointerException();
        } else {
            Book temp =bookMap.get(book.getId());
            if (temp.getAmount()==0){
                return false;
            }
            else {
                temp.setAmount(temp.getAmount()-1);
                bookRepository.save(temp);
                return true;
            }
        }

    }    @Override
    public void payBook(Book book) {
        Book temp = bookMap.get(book.getId());
        if (temp != null) {
            temp.setAmount(temp.getAmount() + 1);
            bookRepository.save(temp);
        }

    }

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }
}
