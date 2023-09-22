/*
 * Author  : supun@mj
 * Project : AAD_Assignment_02_SpringMVC
 * Date    : 9/20/2023
 * Time    : 9:44 PM
 * For GDSE course of IJSE Institute.
 */

package lk.ijse.gdse61.aad.aad_assignment_02_springmvc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@EnableJpaRepositories("lk.ijse.gdse61.aad.aad_assignment_02_springmvc.repository")
public class HibernateConfig {

    public final Environment env;

    @Autowired
    public HibernateConfig(Environment env) {
        this.env = env;
    }

    // Factory create
    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean emf =
                new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource);
        emf.setPackagesToScan("lk.ijse.gdse61.aad.aad_assignment_02_springmvc.entity");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        emf.setJpaVendorAdapter(vendorAdapter);
        emf.setJpaPropertyMap(hibernateProperties());
        return emf;
    }

    // Data Source create
    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dmd = new DriverManagerDataSource();
        dmd.setDriverClassName(env.getProperty("spring.datasource.driver-class-name"));
        dmd.setUrl(env.getProperty("spring.datasource.url"));
        dmd.setUsername(env.getProperty("spring.datasource.username"));
        dmd.setPassword(env.getProperty("spring.datasource.password"));
        return dmd;
    }

    // Transaction
    @Bean
    public PlatformTransactionManager transactionManager(LocalContainerEntityManagerFactoryBean emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf.getObject());
        return transactionManager;
    }

    // Load Hibernate Properties
    private Map<String, String> hibernateProperties() {
        Map<String, String> hibernateProperties = new HashMap<>();
        hibernateProperties.put("hibernate.hbm2ddl.auto", env.getProperty("spring.jpa.hibernate.ddl-auto"));
        hibernateProperties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
        hibernateProperties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
        hibernateProperties.put("hibernate.format_sql", env.getProperty("spring.jpa.properties.hibernate.format_sql"));
        return hibernateProperties;
    }

}
