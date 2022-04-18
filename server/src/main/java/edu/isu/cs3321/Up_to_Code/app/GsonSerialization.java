package edu.isu.cs3321.Up_to_Code.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class GsonSerialization {

    public static String serialize(Object x){
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();
        return gson.toJson(x);
    }
    public static AlphaTableController deSerializeAlpha(String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString, AlphaTableController.class);
    }
    public static Alpha deSerializeClientAlpha(String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString, Alpha.class);
    }
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
    public static ChecklistTableController itemConverter(CheckListItem item){
        String name = item.getChecklistitem();

        return new ChecklistTableController(name);

    }
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
    public static CheckListItem serverItemConverter(ChecklistTableController item){
        String name = item.getChecklistItem();

        return new CheckListItem(name);

    }
    public static List<Alpha> clientAlphaList(List<AlphaTableController> a){
        List<Alpha> a1 = new ArrayList<>();
        for (int i = 0; i < a.size(); i++){
            a1.add(ServerToClientConverter(a.get(i)));
        }
        return a1;
    }
}
