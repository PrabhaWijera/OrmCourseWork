package lk.ijse.prabhash.orm.dao.custom;


import lk.ijse.prabhash.orm.dao.SuperDAO;

import java.util.List;

public interface QueryDAO extends SuperDAO {
    List<Object[]> getAllPendingKeyMoneyReservationsUsingReservationStatus() throws Exception;
}
