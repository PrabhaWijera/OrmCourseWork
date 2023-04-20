package lk.ijse.prabhash.orm.dao.custom.impl;

import lk.ijse.prabhash.orm.dao.custom.QueryDAO;
import lk.ijse.prabhash.orm.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class QueryDAOImpl implements QueryDAO {

    @Override
    public List<Object[]> getAllPendingKeyMoneyReservationsUsingReservationStatus() throws Exception {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("SELECT r.res_id,s.student_id,s.name,ro.room_type_id,ro.type,ro.key_money,r.status,r.date FROM Reservation r  JOIN Student s ON r.student = s.student_id  JOIN Room ro ON r.room =ro.room_type_id WHERE r.status= : y");


        List<Object[]> list = query.setParameter("y", "Paid Later").list();

        System.out.println(list+"list eka");
        transaction.commit();
        session.close();
        return list;
    }
}


/*res_id from Reservation table
student_id and name from Student table
room_type_id, type, and key_money from Room table
status and date from Reservation table
The query is using the INNER JOIN clause to join the Reservation table with the Student table and the Room table based on their corresponding foreign keys - student and room, respectively. The ON keyword specifies the join condition.


The WHERE clause is used to filter the results based on the value of the status column in the Reservation table. The value is passed as a named parameter ":y", which means that the value of the parameter is set at runtime when the query is executed.

Overall, the query will retrieve data related to reservations made by students for rooms, along with the status and date of the reservation, but only for those reservations whose status is equal to the value passed as the paramete*/