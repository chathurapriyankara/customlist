package com.fct.customlist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView pizzaList = findViewById(R.id.listView);
        List<String> pizzaDetails = new ArrayList<>();
        pizzaDetails.add("One");
        pizzaDetails.add("Two");
        pizzaDetails.add("Three");
        CustomAdapter listAdapter = new CustomAdapter(this, R.layout.list_item, pizzaDetails);
        pizzaList.setAdapter(listAdapter);
    }

    private class CustomAdapter extends ArrayAdapter<String>{
        private List<String> itemsList;

        CustomAdapter(Context context, int resource, List<String> items) {
            super(context, resource, items);
            itemsList = items;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if(convertView == null) {
                convertView = getLayoutInflater().from(getContext()).inflate(R.layout.list_item, parent, false);
            }
            TextView tv =  convertView.findViewById(R.id.textView);
            tv.setText(itemsList.get(position));
            return convertView;
        }
    }
}
