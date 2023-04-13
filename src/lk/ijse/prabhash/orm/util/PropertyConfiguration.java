package lk.ijse.prabhash.orm.util;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyConfiguration {
    public static Properties loadProperties(String fileName) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = Hibernate.class.getClassLoader().getResourceAsStream(fileName);
            properties.load(inputStream);
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        }
        return properties;
    }
}
