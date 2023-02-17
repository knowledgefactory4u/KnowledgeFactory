package com.knf.dev.demo.config.postgresql;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import javax.sql.DataSource;

@MapperScan(value = "com.knf.dev.demo",
        annotationClass= PostgreSQLConnMapper.class,
        sqlSessionFactoryRef="PostgreSQLSessionFactory")
@Configuration
public class PostgreSQLConfig {

    @Bean(name = "PostgreSQLDataSource")
    @ConfigurationProperties(prefix="spring.datasource.postgresql")
    public DataSource SecondDataSource() {

        return DataSourceBuilder.create().build();
    }

    @Bean(name = "PostgreSQLSessionFactory")
    public SqlSessionFactory oracleSqlSessionFactory(
            @Qualifier("PostgreSQLDataSource")
             DataSource oracleDataSource) throws Exception {

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(oracleDataSource);
        sqlSessionFactoryBean.setMapperLocations(
                new PathMatchingResourcePatternResolver().
                        getResources("mapper/postgresql/*.xml"));
        sqlSessionFactoryBean.setTypeAliasesPackage("com.knf.dev.demo.model.postgresql");
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "PostgreSQLSessionTemplate")
    public SqlSessionTemplate oracleSqlSessionTemplate(
            @Qualifier("PostgreSQLSessionFactory")
             SqlSessionFactory oracleSessionTemplate) {

        return new SqlSessionTemplate(oracleSessionTemplate);
    }


    @Bean(name = "PostgreSQLTransactionManager")
    public DataSourceTransactionManager PrimaryTransactionManager(
            @Qualifier("PostgreSQLDataSource")
              DataSource oracleDataSource) {

        return new DataSourceTransactionManager(oracleDataSource);
    }
}
