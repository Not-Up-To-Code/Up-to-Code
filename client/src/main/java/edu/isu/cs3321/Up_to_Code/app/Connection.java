// MIT License

// Copyright (c) 2022 Thomas Evans, Benjamin Keninger, Sina Khajeh Pour, Braxton Soto

// Permission is hereby granted, free of charge, to any person obtaining a copy
// of this software and associated documentation files (the "Software"), to deal
// in the Software without restriction, including without limitation the rights
// to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
// copies of the Software, and to permit persons to whom the Software is
// furnished to do so, subject to the following conditions:

// The above copyright notice and this permission notice shall be included in all
// copies or substantial portions of the Software.

// THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
// IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
// FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
// AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
// LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
// OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
// SOFTWARE.

package edu.isu.cs3321.Up_to_Code.app;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import kong.unirest.Unirest;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

public class Connection {

    private static final String test_call = "http://%s:%s/api/status";
    private static final String saveCard_call = "http://%s:%s/api/card/save";
    private static final String getPractices_call = "http://%s:%s/api/practice/catalog";
    private static final String getAlphas_call = "http://%s:%s/api/card/catalog";
    private static final String savePractice_call = "http://%s:%s/api/practice/upload";


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

    public String getPractices()throws IOException, InterruptedException{
        HttpRequest request = createGet(getPractices_call);
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public String getAlphas()throws IOException, InterruptedException{
        HttpRequest request = createGet(getAlphas_call);
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }

    public void sendAlpha(Alpha alpha) throws IOException, InterruptedException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String output = gson.toJson(alpha);

        HttpRequest request = createPost(saveCard_call, output);
        client.send(request, HttpResponse.BodyHandlers.ofString());
    }

    public void sendPractice(File file) throws IOException, InterruptedException{
        kong.unirest.HttpResponse<String> response = Unirest
                .post(String.format(savePractice_call, url, port))
                .field("file", new File(file.getPath()))
                .asString();
    }

    public void downloadCards(Alpha alpha) throws IOException, InterruptedException{
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
