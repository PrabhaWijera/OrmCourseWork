package lk.ijse.prabhash.orm.entity;

;

import lombok.*;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
public class User {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String userId;
    private String name;
    private String telNo;
    private String email;
    private String userName;
    private String password;
}
