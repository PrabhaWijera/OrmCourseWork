package lk.ijse.prabhash.orm.dao.custom;


import lk.ijse.prabhash.orm.dao.CrudDAO;
import lk.ijse.prabhash.orm.entity.Reservation;

public interface RegistrationDAO extends CrudDAO<Reservation,String> {
    boolean updateUsingId(String id,String status) throws Exception;
}
