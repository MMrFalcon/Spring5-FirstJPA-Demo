package falcon.springframework.spring5webapp.Bootstrap;

import falcon.springframework.spring5webapp.Model.Author;
import falcon.springframework.spring5webapp.Model.Book;
import falcon.springframework.spring5webapp.Model.Publisher;
import falcon.springframework.spring5webapp.Repositories.AuthorRepository;
import falcon.springframework.spring5webapp.Repositories.BookRepository;
import falcon.springframework.spring5webapp.Repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {

        Publisher superNowa = new Publisher("SuperNowa", "Warsaw 123 - 23, Some street 323/23");
        publisherRepository.save(superNowa);

        Author andrew = new Author("Andrzej", "Sapkowski");
        Book wither = new Book("Wither", "1233", superNowa);
        andrew.getBooks().add(wither);
        wither.getAuthors().add(andrew);


        authorRepository.save(andrew);
        bookRepository.save(wither);

        Publisher another = new Publisher("Another", "Some address, with some street");
        publisherRepository.save(another);

        Author george = new Author("George", "Martin");
        Book game = new Book("Game of thrones", "4567", another);
        george.getBooks().add(game);

        authorRepository.save(george);
        bookRepository.save(game);
    }


}
