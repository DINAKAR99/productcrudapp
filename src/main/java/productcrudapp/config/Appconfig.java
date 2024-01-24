package productcrudapp.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableTransactionManagement
@EnableWebMvc
@ComponentScan(basePackages = "productcrudapp.*")
public class Appconfig implements WebMvcConfigurer {

    @Bean
    InternalResourceViewResolver getviewresolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");

        return resolver;

    }

    @Bean
    public DriverManagerDataSource getSource() {

        DriverManagerDataSource source = new DriverManagerDataSource("jdbc:postgresql://localhost:5433/crudapp",
                "postgres", "dinakar1.");
        source.setDriverClassName("org.postgresql.Driver");

        return source;
    }

    @Bean
    public LocalSessionFactoryBean getFactory() {

        LocalSessionFactoryBean factory = new LocalSessionFactoryBean();
        factory.setDataSource(getSource());
        factory.setHibernateProperties(gettHibeProp());
        factory.setPackagesToScan("productcrudapp.*");

        return factory;
        // factory.setAnnotatedClasses(null);

    }

    // @Bean
    // public HibernateTemplate getHibernateTemplate() {

    // HibernateTemplate h1 = new HibernateTemplate();
    // h1.setSessionFactory(getFactory().getObject());

    // return h1;
    // }

    @Bean
    public Properties gettHibeProp() {

        Properties p1 = new Properties();
        p1.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        p1.setProperty("hibernate.hbm2ddl.auto", "update");
        p1.setProperty("hibernate.show_sql", "true");
        p1.setProperty("hibernate.format_sql", "true");
        return p1;
    }

    @Bean
    public HibernateTransactionManager getTransmanage() {

        return new HibernateTransactionManager(getFactory().getObject());
    }
}
