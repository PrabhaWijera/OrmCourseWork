package lk.ijse.prabhash.orm.bo.custom;


import lk.ijse.prabhash.orm.bo.SuperBO;
import lk.ijse.prabhash.orm.dto.CustomDTO;
import lk.ijse.prabhash.orm.view.tm.CustomTM;

import java.util.ArrayList;
import java.util.List;

public interface PendingKeyMoneyBO extends SuperBO {

    List<CustomDTO> getAllPendingKeyMoneyReservationsUsingReservationStatus() throws Exception;
    boolean updateReservationUsingId(String id, String status) throws Exception;

    }
