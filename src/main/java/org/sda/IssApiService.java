package org.sda;

import com.google.gson.Gson;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class IssApiService {

    private final Gson gson = new Gson();

    private final String GET_LOCATION_ENDPOINT = "http://api.open-notify.org/iss-now.json";
    private final String GET_PEOPLE_ENDPOINT = "http://api.open-notify.org/astros.json";

    public Location getIssLocation() {
        String bodyString = makeRequestToApi(GET_LOCATION_ENDPOINT);
        Location location = gson.fromJson(bodyString, Location.class);
        return location;
    }

    public IssSpaceship getPeopleInIss() {
        String bodyString = makeRequestToApi(GET_PEOPLE_ENDPOINT);
        IssSpaceship issSpaceship = gson.fromJson(bodyString, IssSpaceship.class);

        return issSpaceship;
    }

    public String makeRequestToApi(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);

        try {
            Response response = call.execute();
            String bodyString = response.body().string();

            return bodyString;
        } catch (Exception e) {
            System.out.println("Connection failed.");
        }

        return null;
    }
}