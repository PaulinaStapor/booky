package paulinastapor.booky.books;

import org.springframework.stereotype.Service;

@Service
public class BookDtoToBookEntityMapper {
    public Book builder(BookDto bookDto) {
        Book book = new Book();
        book.setDateOfPublish(bookDto.getDateOfPublish());
        book.setTitle(bookDto.getTitle());
        book.setAuthorName(bookDto.getAuthorName());
        book.setAuthorSurname(bookDto.getAuthorSurname());
        book.setBookBarcode(bookDto.getBookBarcode());
        return book;
    }

}
