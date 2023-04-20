package lk.ijse.prabhash.orm.view.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomTM {
    private String res_id;
    private String student_id;
    private String name;
    private String room_type_id;
    private String type;
    private double key_money;
    private String status;
    private LocalDate date;
}
