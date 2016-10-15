package me.husseinfahmy.moneywise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yelp.clientlib.connection.YelpAPI;
import com.yelp.clientlib.connection.YelpAPIFactory;

import java.util.HashMap;
import java.util.Map;

public class RecommendationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);

        YelpAPIFactory apiFactory = new YelpAPIFactory("Mas47GwCA1Bio3uJ08yIGg", "o9rKaeLjjopt_90o1bdGFbuIbmc", "XlzyPKV4L9QFzaaw6qr3FO1zala2F6NL", "In5IaMHhjtc4Gz4Pv6Fs1A3paPU");
        YelpAPI yelpAPI = apiFactory.createAPI();
        Map<String, String> params = new HashMap<>();

        params.put("term","restaurant");
        params.put("limit", "10");

    }
}
