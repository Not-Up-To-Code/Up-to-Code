/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package edu.isu.cs3321.Up_to_Code.app;

import com.google.gson.Gson;
import io.javalin.Javalin;
import io.javalin.core.util.FileUtil;
import io.javalin.http.staticfiles.Location;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static edu.isu.cs3321.Up_to_Code.app.DatabaseManagement.*;
import static edu.isu.cs3321.Up_to_Code.app.GsonSerialization.*;


public class App {
    static final File dir = new File("practices/");

    static final String[] extentions = new String[]{
      "png", "jpg", "jpeg", "svg"
    };

    static final FilenameFilter nameFilter = new FilenameFilter(){
        @Override
        public boolean accept(File dir, String name) {
            for (final String ext : extentions){
                if (name.endsWith("." + ext)){
                    return true;
                }
            }
            return false;
        }
    };

    public static String practiceCatalogLoader() throws IOException {
        List<String> imgNames = new ArrayList<>();
        if (dir.isDirectory()){
            for (File file : dir.listFiles(nameFilter)){
                imgNames.add(file.getName());
            }
        }else {
            System.out.println("is not directory");
        }
        Gson gson = new Gson();
        String output = gson.toJson(imgNames);
        return output;
    }

    public static void main(String[] args) {
        Javalin app = Javalin.create(javalinConfig -> {
            javalinConfig.addStaticFiles(staticFileConfig -> {
                staticFileConfig.hostedPath = "/images";
                staticFileConfig.directory = "practices/";
                staticFileConfig.location = Location.EXTERNAL;
            });
        }).start(7000);


        //practice catalog - needs to return the json payload with all practices in folder
        app.get("/api/practice/catalog", ctx -> {ctx.result(practiceCatalogLoader());});

        //practice creator - needs to provide server with screenshot for storage
        app.post("/api/practice/upload", ctx -> {
            ctx.uploadedFiles("file").forEach(file -> {
                FileUtil.streamToFile(file.getContent(), "practices/" + file.getFilename());
            });
            ctx.result("done");
        });

        //card catalog - needs to return all a json payload with all cards in alpha or states tables
        app.get("/api/card/catalog", ctx -> ctx.json("temp"));

        //card creator - passes alpha and states to server for db storage
        app.post("/api/card/save", ctx -> addAlpha(serialize(clientToServerConverter(deSerializeClientAlpha(ctx.body())))));


        //games - need list of all available alphas, needs json payload with selected alpha and associated state cards
        app.get("/api/card/list", ctx -> ctx.html("Hello World!"));

        //chase the state - needs to provide server with array of played state card values to generate charts
        app.get("/api/card/retrieve", ctx -> ctx.html("Hello World!"));

        app.get("/api/status", ctx -> ctx.result("Online"));



        /*AlphaTableController a = new AlphaTableController("Alpha 1", "Testing Foreign Key", "Testing foreign key relationships between alpha and state", false, "blue");
        AlphaTableController a1 = new AlphaTableController("Alpha 2", "Testing Foreign Key", "Testing foreign key relationships between alpha and state", false, "blue");
        StateTableController s = new StateTableController("State 1", 1);
        StateTableController s1 = new StateTableController("State 2", 2);
        StateTableController s2 = new StateTableController("More test ", 1);
        ChecklistTableController c = new ChecklistTableController("Foreign key");
        ChecklistTableController c1 = new ChecklistTableController("Second state test");
        ChecklistTableController c2 = new ChecklistTableController("Third state test");
        a.addState(s);
        a.addState(s1);
        s.addItems(c);
        s1.addItems(c1);
        s2.addItems(c2);
        a1.addState(s2);


        System.out.println("test");
        System.out.print(a);
        String alphaJson = serialize(a);
        addAlpha(alphaJson);
        alphaJson = serialize(a1);
        addAlpha(alphaJson);*/

        Alpha client = new Alpha("test" , "test", "test", "red", false );
        State state1 = new State("test", 1);
        CheckListItem item1 = new CheckListItem("test");

        state1.addCheckListItem(item1);
        client.addState(state1);
        AlphaTableController a = clientToServerConverter(client);
        client = ServerToClientConverter(a);
        a = clientToServerConverter(client);
        String json = serialize(a);
        addAlpha(json);
        List<Alpha> aList = clientAlphaList(getAlphas());
        String list = serialize(aList);
        System.out.println(list);


    }
}
