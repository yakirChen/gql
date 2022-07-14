package gql.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Author
 *
 * @author yakir on 2022/07/13 21:41.
 */
public class Author implements Serializable {

    private static final long serialVersionUID = -8379005489525321730L;

    private Long          id;
    private String        name;
    private LocalDateTime date;
    private List<Book>    books;

    public Long getId() {
        return id;
    }

    public Author setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Author setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Author setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public List<Book> getBooks() {
        return books;
    }

    public Author setBooks(List<Book> books) {
        this.books = books;
        return this;
    }
}
