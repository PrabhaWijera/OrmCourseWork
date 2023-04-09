package lk.ijse.prabhash.orm.dao.custom;

import lk.ijse.prabhash.orm.dao.CrudDAO;
import lk.ijse.prabhash.orm.entity.Room;

import java.util.List;

public interface RoomDAO extends CrudDAO<Room,String> {
    List<Room> getRoomDetailUsingId(String id) throws Exception;
}
