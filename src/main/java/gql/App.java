package gql;

import gql.dao.BookDao;
import gql.entity.Book;
import gql.util.UUIDUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * App
 *
 * @author yakir on 2022/07/14 11:02.
 */
public class App {

    private static final Logger log = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        Book result = new BookDao()
                .insertOne("book" + UUIDUtils.get())
                .orElse(null);

        log.info("Book {}", result);
    }
}
