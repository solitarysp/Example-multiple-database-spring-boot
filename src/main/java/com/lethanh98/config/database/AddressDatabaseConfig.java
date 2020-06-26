package com.lethanh98.config.database;


import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.boot.SchemaAutoTooling;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Slf4j
@Configuration
@ConditionalOnProperty(value = "app.datasource.adress.enable", havingValue = "true", matchIfMissing = true)
@EnableTransactionManagement
@EnableJpaRepositories(entityManagerFactoryRef = "adressEntityManagerFactory",
        transactionManagerRef = "adressTransactionManager", basePackages = {"com.lethanh98.repo.adress"})
public class AddressDatabaseConfig {
    @Value("${app.datasource.adress.url:#{null}}")
    private String urlForLog;

    @Bean(name = "adressDataSourceProperties")
    @ConfigurationProperties("app.datasource.adress")
    public DataSourceProperties dataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean(name = "adressDataSource")
    @ConfigurationProperties(prefix = "app.datasource.adress.configuration")
    public DataSource dataSource(@Qualifier("adressDataSourceProperties") DataSourceProperties dataSourceProperties) {
        return dataSourceProperties.initializeDataSourceBuilder().type(HikariDataSource.class).build();
    }

    @Bean(name = "adressEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("adressDataSource") DataSource dataSource) {

        log.info("DB config adressDataSource: " + urlForLog);

        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        properties.put("hibernate.use_sql_comments", "true");
        properties.put("hibernate.hbm2ddl.auto", SchemaAutoTooling.CREATE.name().toLowerCase());
        return builder.dataSource(dataSource).properties(properties).packages("com.lethanh98.entity.adress")
                .build();
    }

    @Bean(name = "adressTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("adressEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
