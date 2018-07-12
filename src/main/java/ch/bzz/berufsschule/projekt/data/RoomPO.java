package ch.bzz.berufsschule.projekt.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by lucienzimmermann on 24.05.18.
 * PO for the database Entity 'Room'
 */

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="room")
public class RoomPO {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int roomId;

    private String name;

    private String description;

}
