package lk.ijse.prabhash.orm.entity;

import lk.ijse.prabhash.orm.entity.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Room {
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private String room_type_id;
    private String type;
    private double key_money;
    private int qty;

    public Room(String room_type_id, String type, double key_money, int qty) {
        this.room_type_id = room_type_id;
        this.type = type;
        this.key_money = key_money;
        this.qty = qty;
    }

    @OneToMany(mappedBy = "room",cascade = CascadeType.ALL)
    private List<Reservation> reservationList=new ArrayList<>();



}
