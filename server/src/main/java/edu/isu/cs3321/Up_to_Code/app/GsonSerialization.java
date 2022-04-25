package edu.isu.cs3321.Up_to_Code.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains both the Gson serialization and deserialization methods, as well as the conversion functions
 */
public class GsonSerialization {

    /**
     * @param x Accepts any generic object
     * @return Returns the object as a serialized string
     */
    public static String serialize(Object x){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        return gson.toJson(x);
    }

    /**
     * @param jsonString Accepts the json string of an AlphaTableController object
     * @return Returns the AlphaTableController object
     */
    public static AlphaTableController deSerializeAlpha(String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString, AlphaTableController.class);
    }

    /**
     * @param jsonString Accepts the json string of an Alpha object
     * @return Returns the Alpha object
     */
    public static Alpha deSerializeClientAlpha(String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Alpha.class);
    }

    /**
     * @param alpha Accepts an Alpha object
     * @return AlphaTableController object with the nested StateTableController objects
     */
    public static AlphaTableController clientToServerConverter(Alpha alpha){
        String alphaName = alpha.getAlpha();
        String briefDescription = alpha.getBriefDesc();
        String detailedDescription = alpha.getDetailedDesc();
        boolean isCompetency = alpha.isCompetency();
        String cardColor = alpha.getColor();
        AlphaTableController a = new AlphaTableController(alphaName, briefDescription, detailedDescription, isCompetency, cardColor);
        for(int i = 0; i < alpha.getStates().size(); i++){
            a.addState(stateConverter(alpha.getStates().get(i)));
        }
        return a;

    }

    /**
     * @param state Accepts a single State object
     * @return StateTableController object along with nested ChecklistTableController objects
     * Used in the clientToServerConverter method
     */
    public static StateTableController stateConverter(State state){
        String stateName = state.getName();
        int stateOrder = state.getStateOrder();
        StateTableController s = new StateTableController(stateName, stateOrder);
        System.out.println(state);
        for(int i = 0; i < state.getChecklist().size(); i++){
            System.out.println(state);
            s.addItems(itemConverter(state.getChecklist().get(i)));
        }
        return s;

    }

    /**
     * @param item Accepts a CheckListItem object
     * @return Returns a ChecklistTableController object
     */
    public static ChecklistTableController itemConverter(CheckListItem item){
        String name = item.getChecklistitem();

        return new ChecklistTableController(name);

    }

    /**
     * @param alpha Accepts an AlphaTableController object
     * @return Returns Alpha Object
     */
    public static Alpha ServerToClientConverter(AlphaTableController alpha){
        String alphaName = alpha.getAlpha();
        String briefDescription = alpha.getBriefDescription();
        String detailedDescription = alpha.getDetailedDescription();
        boolean isCompetency = alpha.isCompetency();
        String cardColor = alpha.getCardColor();
        int id = alpha.getId();
        Alpha a = new Alpha(alphaName, briefDescription, detailedDescription, cardColor, isCompetency, id);
        for(int i = 0; i < alpha.getStates().size(); i++){
            a.addState(serverStateConverter(alpha.getStates().get(i)));
        }
        return a;

    }

    /**
     * @param state Accepts StateTableController object
     * @return Returns State object
     */
    public static State serverStateConverter(StateTableController state){
        String stateName = state.getState();
        int stateOrder = state.getStateOrder();
        State s = new State(stateName, stateOrder);
        System.out.println(state);
        for(int i = 0; i < state.getItems().size(); i++){
            System.out.println(state);
            s.addCheckListItem(serverItemConverter(state.getItems().get(i)));
        }
        return s;

    }

    /**
     * @param item Accepts CheckListItem object
     * @return Returns ChecklistTableController object
     */
    public static CheckListItem serverItemConverter(ChecklistTableController item){
        String name = item.getChecklistItem();

        return new CheckListItem(name);

    }

    /**
     * @param a Accepts a AlphaTableController list
     * @return Returns an Alpha list
     * Meant to be used with the getAlphas method in DatabaseManagement
     */
    public static List<Alpha> clientAlphaList(List<AlphaTableController> a){
        List<Alpha> a1 = new ArrayList<>();
        for (int i = 0; i < a.size(); i++){
            a1.add(ServerToClientConverter(a.get(i)));
        }
        return a1;
    }
}
