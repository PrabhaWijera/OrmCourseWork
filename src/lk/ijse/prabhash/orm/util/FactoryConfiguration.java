package lk.ijse.prabhash.orm.util;



import lk.ijse.prabhash.orm.entity.Reservation;
import lk.ijse.prabhash.orm.entity.Room;
import lk.ijse.prabhash.orm.entity.Student;
import lk.ijse.prabhash.orm.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Properties;


public class FactoryConfiguration {

    private static FactoryConfiguration factoryConfiguration;
    private SessionFactory sessionFactory;//create session factory

    private FactoryConfiguration() {
        //add configuration
        Configuration configuration=new Configuration();
        //add propety
        Properties properties=new Properties();

        //add already cretae hibernate file to propeperties in current thread
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("resouces/hibernate.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //add properties to configure
        configuration.setProperties(properties);

        //add annotaion class to configure



        configuration = new Configuration().configure()
                .addAnnotatedClass(Room.class)
                .addAnnotatedClass(Reservation.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Student.class);


        //build session factory
        sessionFactory = configuration.buildSessionFactory();

    }

    public static FactoryConfiguration getInstance() {
        return factoryConfiguration == null ? factoryConfiguration = new FactoryConfiguration() : factoryConfiguration;

    }
    public Session getSession() {
        return sessionFactory.openSession();//open session and return it
    }

}
