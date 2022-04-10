package edu.isu.cs3321.Up_to_Code.app;

import org.checkerframework.checker.units.qual.A;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import static edu.isu.cs3321.Up_to_Code.app.GsonSerialization.*;

public class DatabaseManagement {

public static void addAlpha(String alphaJson) {
    Alpha a = deSerializeAlpha(alphaJson);
    String alpha = a.getAlpha();
    String briefDescription = a.getBriefDesc();
    String detailedDescription = a.getDetailedDesc();
    boolean isCompetency = a.isCompetency();
    String cardColor = a.getColor();


    Session session = HibernateController.getSessionFactory().openSession();
    Transaction transaction = null;
    try {
        transaction = session.beginTransaction();
        AlphaTableController a1 = new AlphaTableController(alpha, briefDescription, detailedDescription, isCompetency, cardColor);
        session.save(a1);
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
        State s = deSerializeState(stateJson);
        String state = s.getName();
        int id = s.getId();
        int stateOrder = s.getStateOrder();



        Session session = HibernateController.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            StateTableController s1 = new StateTableController(state, id, stateOrder);
            session.save(s1);
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
        CheckListItem c = deSerializeItem(itemJson);
        String checklistItem = c.getChecklistitem();
        int stateID = c.getStateID();



        Session session = HibernateController.getSessionFactory().openSession();
        Transaction transaction = null;
        try{
            transaction = session.beginTransaction();
            ChecklistTableController c1 = new ChecklistTableController(stateID, checklistItem);
            session.save(c1);
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

            return session.createQuery("from ChecklistTableController ", ChecklistTableController.class).list();
        }

    }


}
