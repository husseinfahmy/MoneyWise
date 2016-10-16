package me.husseinfahmy.moneywise;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.yelp.clientlib.connection.YelpAPI;
import com.yelp.clientlib.connection.YelpAPIFactory;
import com.yelp.clientlib.entities.Business;
import com.yelp.clientlib.entities.SearchResponse;
import com.yelp.clientlib.entities.options.CoordinateOptions;

import junit.framework.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecommendationsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommendations);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        YelpAPIFactory apiFactory = new YelpAPIFactory("Mas47GwCA1Bio3uJ08yIGg", "o9rKaeLjjopt_90o1bdGFbuIbmc", "k-rbv7P8UGAnPDyiegmBJCN3Wg06Ywf1", "AI1-oHQCwi-Ttvif7gzPCE8GX-8");
        YelpAPI yelpAPI = apiFactory.createAPI();
        Map<String, String> params = new HashMap<>();

        params.put("term","restaurant/*PUT */");
        params.put("limit", "10");
        params.put("sort", "1");
        CoordinateOptions coordinate = CoordinateOptions.builder()
                .latitude(43.010059)
                .longitude(-81.273522).build();
        Call<SearchResponse> call = yelpAPI.search(coordinate, params);
        try{
//            Callback<SearchResponse> callback = new Callback<SearchResponse>() {
//                @Override
//                public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
//                    SearchResponse searchResponse = response.body();
//                    // Update UI text with the searchResponse.
//                }
//                @Override
//                public void onFailure(Call<SearchResponse> call, Throwable t) {
//                    // HTTP error happened, do something to handle it.
//                }
//            };

            Response<SearchResponse> response = call.execute();
            response.body();
            Assert.assertEquals(200, response.code());
            SearchResponse searchResponse = response.body();
            Assert.assertNotNull(searchResponse);


            ArrayList<Business> results = new ArrayList<>();

            for(int i = 0; i < 10; i++){
                results.add(searchResponse.businesses().get(i));
                System.out.println(searchResponse.businesses().get(i).name());
            }


        }catch (IOException e){
            e.printStackTrace();
        }



    }
}