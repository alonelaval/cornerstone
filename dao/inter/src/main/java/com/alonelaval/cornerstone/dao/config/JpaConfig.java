package com.alonelaval.cornerstone.dao.config;//package com.alonelaval.cornerstone.dao.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
//import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
//import org.springframework.orm.jpa.JpaTransactionManager;
//import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
//import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
//import org.springframework.transaction.PlatformTransactionManager;
//
//import javax.sql.DataSource;
//
//
///**
// * @author huawei
// * @create 2018-07-08
// **/
//@Configuration
//@EnableJpaRepositories(entityManagerFactoryRef = "customerEntityManagerFactory",
//        transactionManagerRef = "customerTransactionManager")
//public class JpaConfig {
//    @Bean
//    PlatformTransactionManager customerTransactionManager() {
//        return new JpaTransactionManager(customerEntityManagerFactory().getObject());
//    }
//
//    @Bean
//    LocalContainerEntityManagerFactoryBean customerEntityManagerFactory() {
//
//        HibernateJpaVendorAdapter jpaVendorAdapter = new HibernateJpaVendorAdapter();
//        jpaVendorAdapter.setGenerateDdl(true);
//
//        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
//
//        factoryBean.setDataSource(customerDataSource());
//        factoryBean.setJpaVendorAdapter(jpaVendorAdapter);
//        factoryBean.setPackagesToScan("com.alonelaval.cornerstone.dao");
//
//        return factoryBean;
//    }
//
//    @Bean
//    DataSource customerDataSource() {
//        return new EmbeddedDatabaseBuilder().
//                setType(EmbeddedDatabaseType.HSQL).
//                setName("customers").
//                build();
//    }
//}
