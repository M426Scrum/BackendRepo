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
@Table(name="event")
public class EventPO {

    @Id
    private int eventId;

    private String title;

    private String description;

    private String organiser;

}
