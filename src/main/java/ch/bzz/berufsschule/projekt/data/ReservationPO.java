package ch.bzz.berufsschule.projekt.data;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by lucienzimmermann on 24.05.18.
 */
@Data
@Entity
@Table(name="reservation")
public class ReservationPO {

    @Id
    private int reservationId;

    private LocalDateTime start;

    private LocalDateTime end;

    @Column(name="Room_roomId")
    private int roomId;

    @Column(name="Event_eventId")
    private int eventId;

}
