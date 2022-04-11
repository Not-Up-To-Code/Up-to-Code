package edu.isu.cs3321.Up_to_Code.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Connection {

    private static final String test_call = "http://%s:%s/api/status";
    private static final String saveCard_call = "http://%s:%s/api/card/save";

    String url;
    String port;
    Boolean initilized = false;
    HttpClient client;

    private Connection(){

    }

    private static class connectionHelper{
        private static final Connection INSTANCE = new Connection();
    }

    public static Connection instance(){
        return connectionHelper.INSTANCE;
    }

    public void initialize(String url, String port){
        this.url = url;
        this.port = port;
        initilized = true;

        client = HttpClient
                .newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .followRedirects(HttpClient.Redirect.NORMAL)
                .connectTimeout(Duration.ofSeconds(30))
                .build();
    }

    public HttpRequest createPost(String call, String json) {
         return HttpRequest
                 .newBuilder()
                .uri(URI.create(String.format(call, url, port)))
                .timeout(Duration.ofSeconds(30))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
    }

    public void sendAlpha(Alpha alpha) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String output = gson.toJson(alpha);

        HttpRequest request = createPost(saveCard_call, output);
        client.send(request, HttpResponse.BodyHandlers.ofString());

    }

    public HttpRequest createGet(String call) {
        return HttpRequest
                .newBuilder()
                .uri(URI.create(String.format(call, url, port)))
                .timeout(Duration.ofSeconds(30))
                .GET()
                .build();
    }

    public boolean test(){
        HttpRequest request = createGet(test_call);
        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            System.out.println(response.body());
            return response.body().equals("Online");
        } catch (IOException | InterruptedException exception){
            return false;
        }
    }
}
