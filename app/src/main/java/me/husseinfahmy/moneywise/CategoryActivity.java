package me.husseinfahmy.moneywise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.category;

/**
 * Created by Mohamed on 2016-10-15.
 */

public class CategoryActivity extends AppCompatActivity {

    List suggestionList;
    ListView suggestionsListView;
    TextView categoryTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);



        categoryTitle = (TextView) findViewById(R.id.category_title);
        categoryTitle.setText("GENERIC CATEGORY");
        suggestionList = new ArrayList<String>();
        suggestionList.add("jo");
        suggestionList.add("jo");
        suggestionList.add("jo");
        suggestionList.add("jo");
        suggestionList.add("jo");
        suggestionList.add("jo");
        suggestionList.add("jo");
        suggestionList.add("jo");
        suggestionList.add("jo");

        ArrayAdapter<String> suggestionAdapter = new ArrayAdapter<String>(this, R.layout.simple_text_view);
        suggestionsListView = (ListView)findViewById(R.id.suggestion_list_view);
        suggestionsListView.setAdapter(suggestionAdapter);



    }
}
