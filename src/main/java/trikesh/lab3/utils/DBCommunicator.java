package trikesh.lab3.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import trikesh.lab3.Result;

import java.io.Serializable;
import java.util.ArrayList;

public class DBCommunicator implements Serializable {

    private static volatile DBCommunicator instance;

    public static DBCommunicator getInstance() {
        DBCommunicator localInstance = instance;
        if (localInstance == null) {
            synchronized (DBCommunicator.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new DBCommunicator();
                }
            }
        }
        return localInstance;
    }


    @PersistenceContext
    private EntityManager manager;

    public DBCommunicator() {
        var managerFactory = Persistence.createEntityManagerFactory("default");
        manager = managerFactory.createEntityManager();
    }

    public void sendOne(Result result) {
        var transaction = manager.getTransaction();
        try {
            transaction.begin();
            manager.persist(result);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
        }
    }

    public ArrayList<Result> getAll() {
        var transaction = manager.getTransaction();
        try {
            transaction.begin();
            var res = new ArrayList<>(manager.createQuery("select p from Result p", Result.class).getResultList());
            transaction.commit();
            return res;
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            return new ArrayList<>();
        }
    }

    public void clearAll() {
        var transaction = manager.getTransaction();
        transaction.begin();
        manager.createQuery("delete from Result p").executeUpdate();
        transaction.commit();
    }
}
