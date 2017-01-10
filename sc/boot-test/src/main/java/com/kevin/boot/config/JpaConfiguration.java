package com.kevin.boot.config;

import org.springframework.boot.autoconfigure.dao.PersistenceExceptionTranslationAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Administrator on 2016/12/18 0018.
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Configuration
@EnableTransactionManagement(proxyTargetClass = true)
@EnableJpaRepositories(basePackages = "com.kevin.boot.repository")
@EntityScan(basePackages = "com.kevin.boot.entity")
public class JpaConfiguration {

    @Bean
    public PersistenceExceptionTranslationAutoConfiguration persistenceExceptionTranslationAutoConfiguration() {
        return new PersistenceExceptionTranslationAutoConfiguration();
    }
}