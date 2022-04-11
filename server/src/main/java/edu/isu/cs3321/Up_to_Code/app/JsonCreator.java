package edu.isu.cs3321.Up_to_Code.app;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JsonCreator {
    public void smallCardJson(smallCard smallCard) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(smallCard.alpha+"smallcard.json"));
        Map<String,Object> smallcardjson=new HashMap<>();
        smallcardjson.put("card name",smallCard.alpha);
        smallcardjson.put("card state",smallCard.state);
        smallcardjson.put("current state",smallCard.currentState);
        smallcardjson.put("total state",smallCard.totalStates);
        smallcardjson.put("card color",smallCard.color);
        ObjectMapper mapper=new ObjectMapper();
        ObjectNode objectNode=mapper.createObjectNode();
        for(int i = 0; i< Arrays.toString(smallCard.checklist).split("\n").length; i++){
            objectNode.put("Checklist "+(i+1),Arrays.stream(Arrays.toString(smallCard.checklist).split("\n")).toList().get(i));
        }
        smallcardjson.put("Checklists",objectNode);
        writer.write(mapper.writeValueAsString(smallcardjson));
        String jsonsmall= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(smallcardjson);
        System.out.println(jsonsmall);
        writer.close();

    }

    public void wideCaedJson(wideCard wideCard) throws IOException {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get(wideCard.cardName+"widecard.json"));
        Map<String,Object> widecardjson=new HashMap<>();
        widecardjson.put("card name",wideCard.cardName);
        widecardjson.put("Brief Description",wideCard.briefDesc);
        widecardjson.put("Detailed Description",wideCard.detailedDesc);
        widecardjson.put("card color",wideCard.color);
        ObjectMapper mapper=new ObjectMapper();

        ObjectNode objectNode=mapper.createObjectNode();
        objectNode.put("State1",wideCard.state1);
        objectNode.put("State2",wideCard.state2);
        objectNode.put("State3",wideCard.state3);
        objectNode.put("State4",wideCard.state4);
        objectNode.put("State5",wideCard.state5);
        objectNode.put("State6",wideCard.state6);
        widecardjson.put("states", objectNode);
        writer.write(mapper.writeValueAsString(widecardjson));
        String jsonwide= mapper.writerWithDefaultPrettyPrinter().writeValueAsString(widecardjson);
        System.out.println(jsonwide);
        writer.close();
    }


/*
    public static void main(String[] args) throws IOException {

        String example="Architecture selection criteria agreed\nHW platforms identified\nTechnologies selected\nSystem boundary known\nDecisions on system organization\nmade\nBuy,build,reuse decisions made\nKey technical risks agreed to";

        smallCard smallCard=new smallCard("alpha","state1",Color.red,example,5,10);
        wideCard wideCard=new wideCard("alpha","briefdesc","detailed desc","state1","state2","state3","state4","state5","state6",Color.red);
        new Cat().wideCaedJson(wideCard);
        new Cat().smallCardJson(smallCard);




/*
        ArrayNode states=mapper.createArrayNode();
        states.add(wideCard.state1);
        states.add(wideCard.state2);
        states.add(wideCard.state3);
        states.add(wideCard.state4);
        states.add(wideCard.state5);
        states.add(wideCard.state6);
        card.put("States",states);

 */






    }


