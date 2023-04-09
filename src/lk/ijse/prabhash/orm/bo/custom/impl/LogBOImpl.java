package lk.ijse.prabhash.orm.bo.custom.impl;




import lk.ijse.prabhash.orm.bo.custom.LogBO;
import lk.ijse.prabhash.orm.bo.custom.UserBO;
import lk.ijse.prabhash.orm.dao.DAOFactory;
import lk.ijse.prabhash.orm.dao.custom.UserDAO;
import lk.ijse.prabhash.orm.dto.UserDTO;
import lk.ijse.prabhash.orm.entity.User;

import java.util.ArrayList;
import java.util.List;

public class LogBOImpl implements LogBO {
      private final  UserDAO userDAO= (UserDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public List<UserDTO> getUserDetails(String userName, String pwd) throws Exception {

        List<User> list = userDAO.getUserDetails(userName, pwd);
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user:list
        ) {
            userDTOS.add(new UserDTO(user.getUserId(),user.getName(),user.getTelNo(),user.getEmail(),user.getUserName(),user.getPassword()));
        }
        return userDTOS;

    }
}
