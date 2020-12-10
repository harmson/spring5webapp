package guru.springframework.spring5webapp.boot;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repo.AuthorRepository;
import guru.springframework.spring5webapp.repo.BookRepository;
import guru.springframework.spring5webapp.repo.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Book book = new Book("Test", "test");
        Author author = new Author("Dzik");
        Publisher publisher = new Publisher("Test", "Testxd");
        publisherRepository.save(publisher);

        book.getAuthors().add(author);
        book.setPublisher(publisher);
        author.getBooks().add(book);
        publisher.getBooks().add(book);



        authorRepository.save(author);
        bookRepository.save(book);
        publisherRepository.save(publisher);

        System.out.println("Starting from boot");
        System.out.println("Book count " + bookRepository.count());
        System.out.println("Publisher count " + publisherRepository.count());
        System.out.println("Publisher count " + authorRepository.count());

        bookRepository.findAll().forEach(s1 -> System.out.println(s1.toString()));





    }
}
