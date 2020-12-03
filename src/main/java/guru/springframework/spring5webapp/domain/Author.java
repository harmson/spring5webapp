package guru.springframework.spring5webapp.domain;

import java.util.Set;


public class Author {


    // fields
    private String name;
    private Set<Book> books;


    // constructors
    public Author() {
    }

    public Author(String name, Set<Book> books) {
        this.name = name;
        this.books = books;
    }


    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}


