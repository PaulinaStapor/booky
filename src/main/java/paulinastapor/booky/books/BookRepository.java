package paulinastapor.booky.books;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository <Book, Integer> {
    @Query("select b from Book b order by b.title")
    List<Book> getAllBooks();
    @Query ("select b from Book b where b.authorSurname=:lastName")
    List <Book> findAllByAuthorSurname (String lastName);
    @Query("select b from Book b where b.title=:title")
    Book findBookByTitle (String title);
}
