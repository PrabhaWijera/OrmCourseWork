package lk.ijse.prabhash.orm;

import lk.ijse.prabhash.orm.entity.Student;
import lk.ijse.prabhash.orm.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Session session1=FactoryConfiguration.getInstance().getSession();
        Transaction transaction1=session1.beginTransaction();
        Student student=new Student("c001",null,null,null,null,null);

        session1.save(student);
        transaction1.commit();
        session1.close();

    }
}
