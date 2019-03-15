package paulinastapor.booky.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import paulinastapor.booky.users.User;
import paulinastapor.booky.users.UserRepository;

@Service
public class BookService {
    private BookDtoToBookEntityMapper bookDtoToBookEntityMapper;
    private UserRepository userRepository;
    private BookRepository bookRepository;

    @Autowired
    public BookService(BookDtoToBookEntityMapper bookDtoToBookEntityMapper, UserRepository userRepository, BookRepository bookRepository) {
        this.bookDtoToBookEntityMapper = bookDtoToBookEntityMapper;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }
    public void addBook(BookDto bookDto, String query){
        Book book=bookDtoToBookEntityMapper.builder(bookDto);
        User user=userRepository.findUserByEmail(query);
        book.setUser(user);
        bookRepository.save(book);
    }
}
