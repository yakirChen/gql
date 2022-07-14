package gql.bean;

import org.apache.ibatis.logging.log4j2.Log4j2Impl;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

/**
 * MybatisFactory
 *
 * @author yakir on 2022/07/14 10:08.
 */
class MybatisFactory {

    private volatile static Configuration configuration;

    private MybatisFactory() {}

    public static Configuration get() {
        if (null == configuration) {
            synchronized (Configuration.class) {
                if (null == configuration) {
                    configuration = new Configuration();
                    configuration.setLazyLoadingEnabled(true);
                    configuration.setUseGeneratedKeys(true);
                    configuration.setAggressiveLazyLoading(true);
                    configuration.setLogImpl(Log4j2Impl.class);
                    configuration.addMappers("gql.mapper");

                    Environment.Builder envBuilder = new Environment.Builder("dev");
                    envBuilder.transactionFactory(new JdbcTransactionFactory());
                    String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/gql?sslMode=DISABLED&allowPublicKeyRetrieval=true&useServerPrepStmts=true&cachePrepStmts=true&useUnicode=true&characterEncoding=utf8&serverTimezone=Asia/Shanghai";
                    envBuilder.dataSource(HikariCPFactory.get(jdbcUrl, "yakir", "qweasd"));
                    configuration.setEnvironment(envBuilder.build());
                }
            }
        }
        return configuration;
    }

}
