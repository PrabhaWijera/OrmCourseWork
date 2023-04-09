package lk.ijse.prabhash.orm.view.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserTM {
    private String userId;
    private String name;
    private String telNo;
    private String email;
    private String userName;
    private String password;
}
