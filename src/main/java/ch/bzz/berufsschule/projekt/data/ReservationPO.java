package ch.bzz.berufsschule.projekt.data;

import ch.bzz.berufsschule.projekt.util.LocalDateTimeDeserializer;
import ch.bzz.berufsschule.projekt.util.LocalDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDateTime;

/**
 * Created by lucienzimmermann on 24.05.18.
 * PO for the database Entity 'Reservation'
 */

@Data
@NoArgsConstructor
@Entity
@Table(name="reservation")
public class ReservationPO {

    public ReservationPO(LocalDateTime aStart, LocalDateTime aEnd, RoomPO aRoomId, EventPO aEventId){
        this.start = aStart;
        this.end = aEnd;
        this.room = aRoomId;
        this.event= aEventId;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int reservationId;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime start;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime end;

    @ManyToOne(cascade=CascadeType.ALL)
    private RoomPO room;

    @ManyToOne(cascade=CascadeType.ALL)
    private EventPO event;

}
