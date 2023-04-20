package lk.ijse.prabhash.orm.bo.custom.impl;


import lk.ijse.prabhash.orm.bo.custom.PendingKeyMoneyBO;
import lk.ijse.prabhash.orm.dao.DAOFactory;
import lk.ijse.prabhash.orm.dao.custom.QueryDAO;
import lk.ijse.prabhash.orm.dao.custom.RegistrationDAO;
import lk.ijse.prabhash.orm.dto.CustomDTO;
import lk.ijse.prabhash.orm.view.tm.CustomTM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PendingKeyMoneyBOImpl implements PendingKeyMoneyBO {
    private final RegistrationDAO registrationDAO= (RegistrationDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.REGISTRATION);
    private final QueryDAO queryDAO= (QueryDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.QUERYDAO);
    @Override
    public ArrayList<CustomDTO> getAllPendingKeyMoneyReservationsUsingReservationStatus() throws Exception {
        List<Object[]> objects = queryDAO.getAllPendingKeyMoneyReservationsUsingReservationStatus();
        List<CustomDTO> arrayList = new ArrayList<>();

        for (Object[] o:objects
             ) {
            arrayList.add(new CustomDTO((String) o[0],(String) o[1],(String) o[2],(String) o[3],(String) o[4],(double) o[5],(String) o[6],(LocalDate) o[7]));
        }

        return (ArrayList<CustomDTO>) arrayList;


    }

    @Override
    public boolean updateReservationUsingId(String id, String status) throws Exception {
        return registrationDAO.updateUsingId(id,status);
    }
}
