package lk.ijse.prabhash.orm.dao.custom;

import lk.ijse.prabhash.orm.dao.CrudDAO;
import lk.ijse.prabhash.orm.entity.User;

import java.util.List;

public interface UserDAO extends CrudDAO<User,String> {
    List<User> getUserDetails(String userName, String pwd) throws Exception;
}
