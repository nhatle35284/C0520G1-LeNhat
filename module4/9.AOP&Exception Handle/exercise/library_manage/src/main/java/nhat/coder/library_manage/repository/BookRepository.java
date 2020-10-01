package nhat.coder.library_manage.repository;

import nhat.coder.library_manage.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}
