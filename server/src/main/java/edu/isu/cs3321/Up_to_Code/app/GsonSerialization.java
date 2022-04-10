package edu.isu.cs3321.Up_to_Code.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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
    public static State deSerializeState(String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString, State.class);
    }
    public static CheckListItem deSerializeItem(String jsonString){
        Gson gson = new Gson();
        return gson.fromJson(jsonString, CheckListItem.class);
    }

}
