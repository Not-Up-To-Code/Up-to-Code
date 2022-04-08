package edu.isu.cs3321.Up_to_Code.app;

import org.checkerframework.checker.units.qual.A;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class DatabaseManagement {

public static void addAlpha(String alphaJson) {
    String alpha = "test";
    String briefDescription = "I am testing";
    String detailedDescription = "I am currently testing whether my shit will properly be added to the database file";
    boolean isCompetency = false;
    String cardColor = "blue";

    //code for parsing Json goes here (will fill in variables above)

    Session session = HibernateController.getSessionFactory().openSession();
    Transaction transaction = null;
    try {
        transaction = session.beginTransaction();
        AlphaTableController a = new AlphaTableController(alpha, briefDescription, detailedDescription, isCompetency, cardColor);
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
    public static List<AlphaTableController> getAlphas(){

        try (Session session = HibernateController.getSessionFactory().openSession()){
            return session.createQuery("from AlphaTableController", AlphaTableController.class).list();

        }

    }

    public static void addState(String stateJson){
        String state = "test1";
        int id = 1;
        int stateOrder = 1;

        //code for parsing Json goes here (will fill in variables above)

        Session session = HibernateController.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            StateTableController s = new StateTableController(state, id, stateOrder);
            session.save(s);
            transaction.commit();
            System.out.println("Finished adding");
        } catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public static List<StateTableController> getStates(){

        try (Session session = HibernateController.getSessionFactory().openSession()){
            return session.createQuery("from StateTableController", StateTableController.class).list();
        }

    }
    public static void addItem(String itemJson){
        String checklistItem = "test1";
        int stateID = 1;

        //code for parsing Json goes here (will fill in variables above)

        Session session = HibernateController.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            ChecklistTableController c = new ChecklistTableController(stateID, checklistItem);
            session.save(c);
            transaction.commit();
            System.out.println("Finished adding");
        } catch(Exception e){
            transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    public static List<ChecklistTableController> getChecklistItems(){

        try (Session session = HibernateController.getSessionFactory().openSession()){
            return session.createQuery("from ChecklistTableController", ChecklistTableController.class).list();
        }

    }

}
