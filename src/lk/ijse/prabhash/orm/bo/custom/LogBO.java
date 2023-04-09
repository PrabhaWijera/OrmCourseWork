package lk.ijse.prabhash.orm.bo.custom;


import lk.ijse.prabhash.orm.bo.SuperBO;
import lk.ijse.prabhash.orm.dto.UserDTO;

import java.util.List;

public interface LogBO extends SuperBO {
    List<UserDTO> getUserDetails(String userName, String pwd) throws Exception;
}
