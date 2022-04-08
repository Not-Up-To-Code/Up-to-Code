package edu.isu.cs3321.Up_to_Code.app;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class connection {

    private static final String test_call = "http://%s:%s/api/status";

    String url;
    String port;
    Boolean initilized = false;
    HttpClient client;

    private connection(){

    }

    private static class connectionHelper{
        private static final connection INSTANCE = new connection();
    }

    public static connection instance(){
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

    private HttpRequest createPost(String call, String json) {
        return HttpRequest
                .newBuilder()
                .uri(URI.create(String.format(call, url, port)))
                .timeout(Duration.ofSeconds(30))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();
    }

    private HttpRequest createGet(String call) {
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
