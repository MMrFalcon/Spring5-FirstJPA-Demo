package falcon.springframework.spring5webapp.Controller;

import falcon.springframework.spring5webapp.Repositories.AuthorRepository;
import falcon.springframework.spring5webapp.Repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {

    private BookRepository bookRepository;

    /**
     * Constructor Based Dependency Injection - Possible when class have only one constructor
     * Different method is using @Autowired annotation
     */
    public BookController(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
    }

    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookRepository.findAll());

        return "books";
    }

}
