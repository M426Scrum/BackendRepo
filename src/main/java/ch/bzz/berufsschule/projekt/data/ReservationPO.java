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
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="reservation")
public class ReservationPO {

    public ReservationPO(LocalDateTime aStart, LocalDateTime aEnd, int aRoomId, int aEventId){
        this.start = aStart;
        this.end = aEnd;
        this.roomId = aRoomId;
        this.eventId = aEventId;
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

    @Column(name="Room_roomId")
    private int roomId;

    @Column(name="Event_eventId")
    private int eventId;

}
