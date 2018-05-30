package ch.bzz.berufsschule.projekt.data;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by lucienzimmermann on 24.05.18.
 */

@Data
@Entity
@Table(name="room")
public class RoomPO {

    @Id
    private int roomId;

    private String name;

    private String description;

}
