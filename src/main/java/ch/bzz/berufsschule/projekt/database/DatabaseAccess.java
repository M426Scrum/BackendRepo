package ch.bzz.berufsschule.projekt.database;

import ch.bzz.berufsschule.projekt.data.EventPO;
import ch.bzz.berufsschule.projekt.data.ReservationPO;
import ch.bzz.berufsschule.projekt.data.RoomPO;

import javax.annotation.Resource;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.NotSupportedException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.util.List;

/**
 * Created by lucienzimmermann on 24.05.18.
 * DatabaseAccess that gets stuff from the db
 */
@Named("databaseAccess")
@Transactional
public class DatabaseAccess {

    @PersistenceContext(unitName = "DefaultPersistenceUnit")
    private EntityManager entityManager;

    @Resource
    private UserTransaction userTransaction;

    /**
     * Returns the room with the given id from the database
     * @param id: id of the room
     * @return RoomPO
     */
    public RoomPO getRoomById(int id){
        return entityManager.find(RoomPO.class, id);
    }

    /**
     * Returns a list with all rooms that exist in the database
     * @return List with RoomPOs
     */
    public List<RoomPO> getRoomList(){
        Query query = entityManager.createQuery("SELECT ro FROM RoomPO ro");
        return (List<RoomPO>) query.getResultList();
    }

    /**
     * Returns the reservation with the given id from the databse
     * @param id: id of the reservation
     * @return ReservationPO
     */
    public ReservationPO getReservationById(int id){
        return entityManager.find(ReservationPO.class, id);
    }

    /**
     * Returns a list with all reservations that exist in the database
     * @return List with ReservationPOs
     */
    public List<ReservationPO> getReservationList(){
        Query query = entityManager.createQuery("SELECT rv FROM ReservationPO rv");
        return (List<ReservationPO>) query.getResultList();
    }

    /**
     * Returns a list of reservations that use the room with the given id
     * @param id: id of the room
     * @return List of ReservationPOs
     */
    public List<ReservationPO> getReservationListForRoom(int id){
        Query query = entityManager.createQuery("SELECT rv FROM ReservationPO rv WHERE rv.room.roomId = :roomId");
        query.setParameter("roomId", id);
        return (List<ReservationPO>) query.getResultList();
    }

    /**
     * Adds a new reservation to the database
     * @param reservationPO: new reservation Object
     * @throws Exception: throws Exception if the reservation somehow cannot be inserted into the database
     */
    public void addReservation(ReservationPO reservationPO) throws Exception {

        entityManager.merge(reservationPO);

    }

    /**
     * Returns a list of all events that exist in the database
     * @return List of EventPOs
     */
    public List<EventPO> getEventList(){
        Query query = entityManager.createQuery("SELECT e FROM EventPO e");
        return (List<EventPO>) query.getResultList();
    }

    /**
     * Returns the event with the given id from the database
     * @param id: id of the event
     * @return EventPO
     */
    public EventPO getEventById(int id){
        Query query = entityManager.createQuery("SELECT e FROM EventPO e WHERE e.eventId = :eventId");
        query.setParameter("eventId", id);
        return (EventPO) query.getSingleResult();
    }

}
