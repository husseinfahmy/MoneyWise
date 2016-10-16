package me.husseinfahmy.moneywise;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

/**
 * Created by Mohamed on 2016-10-15.
 */

public class CategoryActivity extends AppCompatActivity {

    List suggestionList;
    ListView suggestionsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);


    }
}
