package ch.bzz.berufsschule.projekt.data;

import ch.bzz.berufsschule.projekt.util.LocalDateTimeDeserializer;
import ch.bzz.berufsschule.projekt.util.LocalDateTimeSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created by lucienzimmermann on 05.07.18.
 * DTO for the ReservationPO, with rooms and events as id
 */

@Data
public class ReservationDTO {

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime start;

    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    private LocalDateTime end;


    private int roomId;

    private int eventId;

}
