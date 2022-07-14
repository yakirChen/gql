package gql.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Book
 *
 * @author yakir on 2022/07/13 21:29.
 */
public class Book implements Serializable {

    private static final long serialVersionUID = 708204448486183265L;

    private Long          id;
    private String        name;
    private LocalDateTime date;
    private Long          authorId;

    public Long getId() {
        return id;
    }

    public Book setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Book setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Book setDate(LocalDateTime date) {
        this.date = date;
        return this;
    }

    public Long getAuthorId() {
        return authorId;
    }

    public Book setAuthorId(Long authorId) {
        this.authorId = authorId;
        return this;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", authorId=" + authorId +
                '}';
    }
}
