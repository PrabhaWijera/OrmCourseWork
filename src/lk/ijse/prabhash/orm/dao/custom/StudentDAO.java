package lk.ijse.prabhash.orm.dao.custom;

import lk.ijse.prabhash.orm.dao.CrudDAO;
import lk.ijse.prabhash.orm.entity.Student;

import java.util.List;

public interface StudentDAO extends CrudDAO<Student,String> {
    List<Student> getStudentDetailsUsingId(String id) throws Exception;
}
