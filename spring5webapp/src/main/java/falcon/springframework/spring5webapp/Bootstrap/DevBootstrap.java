package falcon.springframework.spring5webapp.Bootstrap;

import falcon.springframework.spring5webapp.Model.Author;
import falcon.springframework.spring5webapp.Model.Book;
import falcon.springframework.spring5webapp.Repositories.AuthorRepository;
import falcon.springframework.spring5webapp.Repositories.BookRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Author andrew = new Author("Andrzej", "Sapkowski");
        Book wither = new Book("Wither", "1233", "SuperNowa");
        andrew.getBooks().add(wither);
        wither.getAuthors().add(andrew);

        authorRepository.save(andrew);
        bookRepository.save(wither);

        Author george = new Author("George", "Martin");
        Book game = new Book("Game of thrones", "4567","Another");
        george.getBooks().add(game);

        authorRepository.save(george);
        bookRepository.save(game);
    }


}
