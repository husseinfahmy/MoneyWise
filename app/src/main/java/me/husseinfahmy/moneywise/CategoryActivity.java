package me.husseinfahmy.moneywise;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.yelp.clientlib.connection.YelpAPI;
import com.yelp.clientlib.connection.YelpAPIFactory;
import com.yelp.clientlib.entities.Business;
import com.yelp.clientlib.entities.SearchResponse;
import com.yelp.clientlib.entities.options.CoordinateOptions;

import junit.framework.Assert;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;

import static android.R.attr.category;

/**
 * Created by Mohamed on 2016-10-15.
 */

public class CategoryActivity extends AppCompatActivity {

    ArrayList<Business> suggestionList;
    SuggestionsListAdapter suggestionsListAdapter;
    ListView suggestionsListView;
    TextView categoryTitle;
    TextView suggestionsTitle;
    Intent openingIntent;
    String categoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        openingIntent = getIntent();
        categoryName = openingIntent.getStringExtra("CATEGORY_NAME");

        suggestionList = recommendationsFunction(categoryName);
        suggestionsListAdapter = new SuggestionsListAdapter(this, suggestionList);

        categoryTitle = (TextView) findViewById(R.id.category_title);
        categoryTitle.setText(categoryName);

        suggestionsTitle = (TextView) findViewById(R.id.suggestions_label);
        suggestionsTitle.setText("SUGGESTIONS");

        suggestionsListView = (ListView)findViewById(R.id.suggestion_list_view);
        suggestionsListView.setAdapter(suggestionsListAdapter);



    }


    public static ArrayList<Business> recommendationsFunction(String category) {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);

        YelpAPIFactory apiFactory = new YelpAPIFactory("Mas47GwCA1Bio3uJ08yIGg", "o9rKaeLjjopt_90o1bdGFbuIbmc", "k-rbv7P8UGAnPDyiegmBJCN3Wg06Ywf1", "AI1-oHQCwi-Ttvif7gzPCE8GX-8");
        YelpAPI yelpAPI = apiFactory.createAPI();
        Map<String, String> params = new HashMap<>();

        params.put("term", category + "/*PUT */");
        params.put("limit", "10");
        params.put("sort", "1");
        CoordinateOptions coordinate = CoordinateOptions.builder()
                .latitude(43.010059)
                .longitude(-81.273522).build();
        Call<SearchResponse> call = yelpAPI.search(coordinate, params);
        try {
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

            for (int i = 0; i < 10; i++) {
                results.add(searchResponse.businesses().get(i));
                System.out.println(searchResponse.businesses().get(i).name());
            }


            return results;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
