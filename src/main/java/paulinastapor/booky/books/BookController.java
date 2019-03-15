package paulinastapor.booky.books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
public class BookController {
    private BookRepository bookRepository;
private BookService bookService;
    @Autowired
    public BookController(BookRepository bookRepository, BookService bookService) {
        this.bookRepository = bookRepository;
        this.bookService = bookService;
    }

    @GetMapping(value = "/allbooks")
    public String showBooks(Model model) {
        model.addAttribute("bookList", bookRepository.getAllBooks());
        return "books";
    }

    @GetMapping(value = "/findbook")
    public String findBook(@RequestParam(required = false) String query, Model model) {
        model.addAttribute("queryValue", query);
        Book book = bookRepository.findBookByTitle(query);
        model.addAttribute("book", book);
        return "books";
    }
    @GetMapping(value = "/addbook")
public String showBookForm (Model model){
        model.addAttribute("addbook", new BookDto());
        return "addbook";
    }
@PostMapping(value = "/addbook")
    public String processingBookForm (@ModelAttribute @Valid BookDto bookDto,
                                      BindingResult bindingResult,
                                      Authentication authentication){
        if(bindingResult.hasErrors()){
            return "addbook";

        }
        String email=authentication.getName();
        bookService.addBook(bookDto,email);
        return "index";
}
}
