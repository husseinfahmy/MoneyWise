package me.husseinfahmy.moneywise;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.yelp.clientlib.entities.Business;

import java.util.List;

/**
 * Created by Mohamed on 2016-10-15.
 */

public class SuggestionsListAdapter extends BaseAdapter {

    private static LayoutInflater inflater = null;
    List<Business> suggestionList;
    Context context;

    SuggestionsListAdapter(Context context, List<Business> suggestionList){

    }

    @Override
    public int getCount() {
        return suggestionList.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getViewTypeCount() {

        return getCount();
    }

    @Override
    public int getItemViewType(int position) {

        return position;
    }

    public View getView(final int position, View convertView, final ViewGroup parent) {

        //TODO:FIGURE OUT OBJECT TYPE
//        ClassRoom currentClassroom = (ClassRoom) classRoomList.get(position);

        View listItem = convertView;
        if (convertView == null) {
            listItem = inflater.inflate(R.layout.suggested_item, parent, false);
            TextView suggestionName = (TextView) listItem.findViewById(R.id.suggestion_title);
                suggestionName.setText("INSERT NAME");
            TextView suggestionPrice = (TextView)listItem.findViewById(R.id.suggestion_price);
                suggestionName.setText("$$");
            final TextView suggestionLocation = (TextView) listItem.findViewById(R.id.suggestion_location);
                suggestionName.setText("INSERT LOCATION");


        }


        return listItem;
    }

}
