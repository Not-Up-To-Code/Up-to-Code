package edu.isu.cs3321.Up_to_Code.app;

import org.checkerframework.checker.units.qual.A;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

import static edu.isu.cs3321.Up_to_Code.app.GsonSerialization.*;

/**
 * This class contains the functions needed to save entries to the card storage database
 */
public class DatabaseManagement {

    /**
     * @param alphaJson Accepts a json string of an AlphaTableController object
     * This object is then added into the database
     */
public static void addAlpha(String alphaJson) {
    AlphaTableController a = deSerializeAlpha(alphaJson);
    Session session = HibernateController.getSessionFactory().openSession();
    Transaction transaction = null;
    try {
        transaction = session.beginTransaction();
        session.save(a);
        transaction.commit();
        System.out.println("Finished adding");
    } catch (Exception e) {
        transaction.rollback();
        e.printStackTrace();
    } finally {
        session.close();
    }
}

    /**
     * @return This returns a list of AlphaTableController objects
     * This list is pulled from the Alphas table of the card storage database
     */
    public static List<AlphaTableController> getAlphas(){

        try (Session session = HibernateController.getSessionFactory().openSession()){
            return session.createQuery("from AlphaTableController", AlphaTableController.class).list();

        }
    }

    /**
     * @param id Accepts the id of the Alpha that we want deleted from the database
     * The database then gets the Alpha with that id and deletes it
     */
    public static void deleteAlpha(int id){
        Session session = HibernateController.getSessionFactory().openSession();
        Transaction t = session.beginTransaction();
        AlphaTableController a = (AlphaTableController) session.get(AlphaTableController.class, id);
        session.delete(a);
        t.commit();
        session.close();
        System.out.println("Deletion complete");

    }

    /**
     * @param json passes in json string of a new AlphaTableController object
     * @param id passes in id of Alpha we want changed
     * The database finds the Alpha with the id we inputted, and replaces it with the new AlphaTableController object
     */
    public static void updateAlpha(String json, int id){
        AlphaTableController a = deSerializeAlpha(json);
        a.setId(id);
        Session session = HibernateController.getSessionFactory().openSession();

        Transaction t = session.beginTransaction();
        session.update(a);
        t.commit();
        session.close();
        System.out.println("Updated " + id);

    }
}
