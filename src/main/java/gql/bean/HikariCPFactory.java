package gql.bean;

import com.mysql.cj.jdbc.Driver;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


/**
 * HikariCPFactory
 *
 * @author yakir on 2022/07/14 10:07.
 */
class HikariCPFactory {

    private volatile static HikariDataSource dataSource;

    private HikariCPFactory() {}

    public static HikariDataSource get(String jdbcUrl, String name, String pwd) {
        if (null == dataSource) {
            synchronized (HikariDataSource.class) {
                if (null == dataSource) {
                    HikariConfig hikariConfig = new HikariConfig();
                    hikariConfig.setMaximumPoolSize(3);
                    hikariConfig.setJdbcUrl(jdbcUrl);
                    hikariConfig.setDriverClassName(Driver.class.getName());
                    hikariConfig.setUsername(name);
                    hikariConfig.setPassword(pwd);
                    dataSource = new HikariDataSource(hikariConfig);
                }
            }
        }
        return dataSource;
    }
}
