package gql.mapper;

import gql.entity.Author;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.LocalDateTimeTypeHandler;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonSelectMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;

import java.time.LocalDateTime;

/**
 * AuthorMapper
 *
 * @author yakir on 2022/07/13 21:35.
 */
@Mapper
public interface AuthorMapper extends CommonInsertMapper<Author>, CommonSelectMapper, CommonCountMapper, CommonDeleteMapper, CommonUpdateMapper {

    @SelectProvider(type = SqlProviderAdapter.class, method = "select")
    @Results(id = "AuthorResult", value = {
            @Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
            @Result(column = "name", property = "name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "date", property = "date", javaType = LocalDateTime.class, jdbcType = JdbcType.OTHER, typeHandler = LocalDateTimeTypeHandler.class),
    })
    Author selectOne();

}
