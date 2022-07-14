package gql.dynamic;

import org.apache.ibatis.type.LocalDateTimeTypeHandler;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import java.sql.JDBCType;
import java.time.LocalDateTime;

/**
 * BookSupport
 *
 * @author yakir on 2022/07/14 14:03.
 */
public class BookSupport {

    public static final BookTable BOOK_TABLE = new BookTable();

    public static final SqlColumn<Long>          id       = BOOK_TABLE.id;
    public static final SqlColumn<String>        name     = BOOK_TABLE.name;
    public static final SqlColumn<LocalDateTime> date     = BOOK_TABLE.date;
    public static final SqlColumn<Long>          authorId = BOOK_TABLE.authorId;

    public static final class BookTable extends SqlTable {
        public BookTable() {
            super("book");
        }

        public final SqlColumn<Long>          id       = column("id", JDBCType.BIGINT);
        public final SqlColumn<String>        name     = column("name", JDBCType.VARCHAR);
        public final SqlColumn<LocalDateTime> date     = column("date", JDBCType.DATE, LocalDateTimeTypeHandler.class.getCanonicalName());
        public final SqlColumn<Long>          authorId = column("author_id", JDBCType.BIGINT);
    }

}
