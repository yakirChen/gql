package gql.dao;

import gql.bean.SessionFactory;
import gql.entity.Book;
import gql.mapper.BookMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.Optional;

/**
 * BookDao
 *
 * @author yakir on 2022/07/13 21:52.
 */
public class BookDao {

    private static final Logger log = LogManager.getLogger(BookDao.class);

    public Optional<Book> insertOne(String name) {

        Book book = new Book();
        book.setName(name);
        book.setDate(LocalDateTime.now());

        try (SqlSession session = SessionFactory.get().openSession(true)) {
            BookMapper bookMapper = session.getMapper(BookMapper.class);
            int        result     = bookMapper.insert(book);
            log.info("Insert Result: {} Id: {}", result, book.getId());
            Long id = book.getId();
            return bookMapper.selectById(id);
        }
    }
}
