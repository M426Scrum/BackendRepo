package ch.bzz.berufsschule.projekt.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * Created by lucienzimmermann on 24.05.18.
 * PO for the database Entity 'Event'
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="event")
public class EventPO {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int eventId;

    private String title;

    private String description;

    private String organiser;

}
