package ch.bzz.berufsschule.projekt.database;

/**
 * Created by lucienzimmermann on 24.05.18.
 */

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

@Named("databaseAccess")
@Transactional
public class DatabaseAccess {

    @PersistenceContext(unitName = "DefaultPersistenceUnit")
    private EntityManager entityManager;

    @Resource
    private UserTransaction userTransaction;

    public RoomPO getRoomById(int id){
        return entityManager.find(RoomPO.class, id);
    }

    public List<RoomPO> getRoomList(){
        Query query = entityManager.createQuery("SELECT ro FROM RoomPO ro");
        return (List<RoomPO>) query.getResultList();
    }

    public ReservationPO getReservationById(int id){
        return entityManager.find(ReservationPO.class, id);
    }

    public List<ReservationPO> getReservationList(){
        Query query = entityManager.createQuery("SELECT rv FROM ReservationPO rv");
        return (List<ReservationPO>) query.getResultList();
    }

    public List<ReservationPO> getReservationListForRoom(int id){
        Query query = entityManager.createQuery("SELECT rv FROM ReservationPO rv WHERE rv.roomId = :roomId");
        query.setParameter("roomId", id);
        return (List<ReservationPO>) query.getResultList();
    }

    public void addReservation(ReservationPO reservationPO) throws Exception {

        entityManager.persist(reservationPO);

    }

}
