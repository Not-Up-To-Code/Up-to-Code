package edu.isu.cs3321.Up_to_Code.app;

import org.checkerframework.checker.units.qual.A;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Set;

import static edu.isu.cs3321.Up_to_Code.app.GsonSerialization.*;

public class DatabaseManagement {

public static void addAlpha(String alphaJson) {
    AlphaTableController a = deSerializeAlpha(alphaJson);
    /*String alpha = a.getAlpha();
    String briefDescription = a.getBriefDescription();
    String detailedDescription = a.getDetailedDesc();
    boolean isCompetency = a.isCompetency();
    String cardColor = a.getColor();
    List<State> states = a.getStates();*/



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
    public static List<AlphaTableController> getAlphas(int n){

        try (Session session = HibernateController.getSessionFactory().openSession()){
            return session.createQuery("from AlphaTableController", AlphaTableController.class).list();

        }

    }




}
