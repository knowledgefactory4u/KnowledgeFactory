package com.knf.dev.demo.config.mysql;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;


/*
When using multiDB, set the basePackages for mapper class
file scan separately for each DB, and now it doesn't
matter because you make separate annotations.
 */
@MapperScan(value = "com.knf.dev.demo",
        annotationClass= MySQLConnMapper.class,
         sqlSessionFactoryRef="MySQLSessionFactory")
@Configuration
public class MySQLConfig {

    //When there are multiple beans of the same type,
    // give those beans a higher priority
    @Primary
    @Bean(name = "MySQLDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.mysql")
    public DataSource mysqlDataSource() {
        return DataSourceBuilder
                .create()
                .build();
    }

    @Primary
    @Bean(name = "MySQLSessionFactory")
    public SqlSessionFactory mySqlSessionFactory
            (@Qualifier("MySQLDataSource") DataSource mysqlDataSource,
               ApplicationContext applicationContex) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(mysqlDataSource);
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().
                        getResources("mapper/mysql/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.knf.dev.demo.model.mysql");

        return sqlSessionFactoryBean.getObject();
    }

    @Primary
    @Bean(name = "MySQLSessionTemplate")
    public SqlSessionTemplate mySqlSessionTemplate
            (@Qualifier("MySQLSessionFactory")
              SqlSessionFactory mySqlSessionFactory) {

        return new SqlSessionTemplate(mySqlSessionFactory);
    }


    @Bean(name = "MysqlTransactionManager")
    @Primary
    public DataSourceTransactionManager PrimaryTransactionManager
            (@Qualifier("MySQLDataSource") DataSource mysqlDataSource) {

        return new DataSourceTransactionManager(mysqlDataSource);
    }
}
