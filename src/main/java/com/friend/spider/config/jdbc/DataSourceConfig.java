package com.friend.spider.config.jdbc;

import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.apache.tomcat.jdbc.pool.jmx.ConnectionPool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * 多数据源配置
 * fyc
 */
@Configuration
public class DataSourceConfig {

    @Value("${spring.datasource.lib-a.url}")
    private String a_Url;
    @Value("${spring.datasource.lib-b.url}")
    private String b_Url;

    @Value("${spring.datasource.lib-a.username}")
    private String a_userName;
    @Value("${spring.datasource.lib-b.userName}")
    private String b_userName;


    @Value("${spring.datasource.lib-a.password}")
    private String a_password;
    @Value("${spring.datasource.lib-b.password}")
    private String b_password;



    /**
     * 默认数据源
     * @return
     */
    @Bean(name="aDataSource")
    @Qualifier("aDataSource")
    @Primary
    public DataSource aDataSource(){
      return   this.getDataSource(a_Url,a_userName,a_password,"a");
    }


    @Bean(name="bDataSource")
    @Qualifier("bDataSource")
    public DataSource bDataSource(){
        return  this.getDataSource(b_Url,b_userName,b_password,"b");
    }

    /**
     * @param dataSource
     * @return
     */
    @Bean(name = "aJdbcTemplate")
    public JdbcTemplate aJdbcTemplate(@Qualifier("aDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * @param dataSource
     * @return
     */
    @Bean(name = "bJdbcTemplate")
    public JdbcTemplate imJdbcTemplate(@Qualifier("bDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    private DataSource getDataSource(String url, String name, String password, String poolName) {
        org.apache.tomcat.jdbc.pool.DataSource dataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        dataSource.setPoolProperties(getPoolProperties(url, name, password, poolName));
        try {
            ConnectionPool pool = dataSource.createPool().getJmxPool();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dataSource;
    }

    private PoolProperties getPoolProperties(String url, String username, String password, String poolName) {
        PoolProperties poolProperties = new PoolProperties();
        poolProperties.setName(poolName);
        poolProperties.setDriverClassName("com.mysql.jdbc.Driver");
        poolProperties.setUrl(url);
        poolProperties.setUsername(username);
        poolProperties.setPassword(password);
        //是否利用 JMX 注册连接池
        poolProperties.setJmxEnabled(true);
        //是否通过空闲对象清除者（如果存在的话）验证对象
        poolProperties.setTestWhileIdle(false);
        //从池中借出对象之前，是否对其进行验证
        poolProperties.setTestOnBorrow(true);
        //在将池中连接返回给调用者之前，用于验证这些连接的 SQL 查询
        poolProperties.setValidationQuery("SELECT 1");
        //将对象返回池之前，是否对齐进行验证
        poolProperties.setTestOnReturn(true);
        //最大链接数
        poolProperties.setMaxActive(64);
        //（整型值）池始终都应保留的连接的最大数目。默认为 maxActive:100。会周期性检查空闲连接（如果启用该功能），留滞时间超过 minEvictableIdleTimeMillis的空闲连接将会被释放。
        poolProperties.setMaxIdle(10);
        poolProperties.setMinIdle(5);
        //在抛出异常之前，连接池等待（没有可用连接时）返回连接的最长时间
        poolProperties.setMaxWait(3000);
        //移除坏链接超时时间
        poolProperties.setRemoveAbandonedTimeout(3000);
        //表示如果连接时间超出了 removeAbandonedTimeout，则将清除废弃连接
        poolProperties.setRemoveAbandoned(true);
        //标志能够针对丢弃连接的应用代码，进行堆栈跟踪记录
        poolProperties.setLogAbandoned(true);
        //链接最大年龄 3秒
        poolProperties.setMaxAge(60000);
        poolProperties.setDefaultAutoCommit(true);
       // poolProperties.setJdbcInterceptors("ConnectionState;StatementCache;SlowQueryReportJmxExt(notifyPool=false,threshold=150,maxQueries=10,logSlow=true,logFailed=true)");
        return poolProperties;
    }
}
