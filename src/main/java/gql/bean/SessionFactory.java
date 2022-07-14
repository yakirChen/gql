package gql.bean;

import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * SessionFactory
 *
 * @author yakir on 2022/07/14 10:08.
 */
public class SessionFactory {

    private volatile static SqlSessionFactory sqlSessionFactory;

    private SessionFactory() {}

    public static SqlSessionFactory get() {
        if (null == sqlSessionFactory) {
            synchronized (SessionFactory.class) {
                if (null == sqlSessionFactory) {
                    sqlSessionFactory = new SqlSessionFactoryBuilder().build(MybatisFactory.get());
                }
            }
        }
        return sqlSessionFactory;
    }

}
