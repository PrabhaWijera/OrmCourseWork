package lk.ijse.prabhash.orm.util;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyConfiguration {
 private static SessionFactory sessionFactory;
    static {
        try {
            // Load Hibernate properties from file
            Properties hibernateProperties = new Properties();
            InputStream inputStream = Hibernate.class.getClassLoader().getResourceAsStream(" resouces/hibernate.properties");
            hibernateProperties.load(inputStream);

            // Build Hibernate SessionFactory
            Configuration configuration = new Configuration();
            configuration.setProperties(hibernateProperties);
            sessionFactory = configuration.buildSessionFactory();
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    public static void closeSessionFactory() {
        if (sessionFactory != null && !sessionFactory.isClosed()) {
            sessionFactory.close();
        }
    }
}
