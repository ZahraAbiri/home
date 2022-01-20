package ir.maktab.config;

import com.sun.org.apache.bcel.internal.generic.Instruction;
import ir.maktab.model.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;

@Configuration
public class HibernateConfig {
    private final Environment env;

    public HibernateConfig(Environment environment) {
        this.env = environment;
    }

    @Bean("sessionFactory")
    @DependsOn("hibernateProperties")
    @Lazy
    public SessionFactory getSessionFactory(java.util.Properties hibernateProperties) {
        org.hibernate.cfg.Configuration configuration = new org.hibernate.cfg.Configuration();
        configuration.addAnnotatedClass(Comment.class);
        configuration.addAnnotatedClass(Customer.class);
        configuration.addAnnotatedClass(Expert.class);
        configuration.addAnnotatedClass(MainService.class);
        configuration.addAnnotatedClass(Manager.class);
        configuration.addAnnotatedClass(Instruction.class);
        configuration.addAnnotatedClass(SubService.class);
        configuration.addAnnotatedClass(Offer.class);
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(Order.class);

        StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(hibernateProperties).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    @Bean
    public java.util.Properties hibernateProperties() {
        java.util.Properties properties = new java.util.Properties();
        properties.setProperty(org.hibernate.cfg.Environment.DRIVER, env.getProperty("hibernate.connection.driver_class"));
        properties.setProperty(org.hibernate.cfg.Environment.URL, env.getProperty("hibernate.connection.url"));
        properties.setProperty(org.hibernate.cfg.Environment.USER, env.getProperty("hibernate.connection.username"));
        properties.setProperty(org.hibernate.cfg.Environment.PASS, env.getProperty("hibernate.connection.password"));
        properties.setProperty(org.hibernate.cfg.Environment.DIALECT, env.getProperty("hibernate.dialect"));
        properties.setProperty(org.hibernate.cfg.Environment.SHOW_SQL, env.getProperty("hibernate.show_sql"));
        properties.setProperty(org.hibernate.cfg.Environment.FORMAT_SQL, env.getProperty("hibernate.format_sql"));
        properties.setProperty(org.hibernate.cfg.Environment.HBM2DDL_AUTO, env.getProperty("hibernate.hbm2ddl.auto"));
        return properties;
    }

}
