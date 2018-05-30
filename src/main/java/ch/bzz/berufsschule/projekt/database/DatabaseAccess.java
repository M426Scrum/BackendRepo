package ch.bzz.berufsschule.projekt.database;

/**
 * Created by lucienzimmermann on 24.05.18.
 */

import ch.bzz.berufsschule.projekt.data.RoomPO;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named("databaseAccess")
public class DatabaseAccess {

    @PersistenceContext(unitName = "DefaultPersistenceUnit")
    private EntityManager entityManager;

    public void getEntities(){

        RoomPO roomPO = entityManager.find(RoomPO.class, 1);
        System.out.println(roomPO);
    }

}
