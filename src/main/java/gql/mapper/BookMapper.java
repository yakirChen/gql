package gql.mapper;

import gql.entity.Book;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.LocalDateTimeTypeHandler;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.insert.render.MultiRowInsertStatementProvider;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonSelectMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

import java.time.LocalDateTime;
import java.util.Optional;

import static gql.dynamic.BookSupport.BOOK_TABLE;
import static gql.dynamic.BookSupport.authorId;
import static gql.dynamic.BookSupport.date;
import static gql.dynamic.BookSupport.id;
import static gql.dynamic.BookSupport.name;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

/**
 * BookMapper
 *
 * @author yakir on 2022/07/13 21:35.
 */
@Mapper
public interface BookMapper extends CommonInsertMapper<Book>, CommonSelectMapper, CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper,
        MultiRowInsertStatementProvider<Book> {

    BasicColumn[] COLUMNS = BasicColumn.columnList(id, name, date, authorId);

    @Results(id = "BookResult", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "date", property = "date", javaType = LocalDateTime.class, jdbcType = JdbcType.OTHER, typeHandler = LocalDateTimeTypeHandler.class),
            @Result(column = "author_id", property = "authorId", jdbcType = JdbcType.BIGINT),
    })
    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    Optional<Book> selectOne(SelectStatementProvider statementProvider);

    @Options(useGeneratedKeys = true, keyProperty = "record.id")
    @InsertProvider(type = SqlProviderAdapter.class, method = "insert")
    int insertOne(InsertStatementProvider<Book> insertStatement);

    default Optional<Book> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, COLUMNS, BOOK_TABLE, completer);
    }

    default Optional<Book> selectById(Long _id) {
        return selectOne(c -> c.where(id, isEqualTo(_id)));
    }

    default int insert(Book record) {
        return MyBatis3Utils.insert(this::insertOne, record, BOOK_TABLE, _dsl ->
                _dsl.map(id).toPropertyWhenPresent("id", record::getId)
                        .map(name).toPropertyWhenPresent("name", record::getName)
                        .map(date).toPropertyWhenPresent("date", record::getDate)
                        .map(authorId).toPropertyWhenPresent("authorId", record::getAuthorId)
        );
    }
}
