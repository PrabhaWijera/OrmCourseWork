package lk.ijse.prabhash.orm.bo.custom;


import lk.ijse.prabhash.orm.bo.SuperBO;
import lk.ijse.prabhash.orm.dto.RoomDTO;

import java.io.IOException;
import java.util.List;

public interface RoomBO extends SuperBO {
    boolean saveRoom(RoomDTO dto) throws Exception;

    boolean updateRoom(RoomDTO dto) throws Exception;

    boolean deleteRoom(String id) throws Exception;

    List<RoomDTO> getAllRooms() throws IOException;
}
