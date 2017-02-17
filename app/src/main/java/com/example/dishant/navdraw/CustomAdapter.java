package com.example.dishant.navdraw;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by dishant on 26/1/17.
 */
public class CustomAdapter extends ArrayAdapter<String>{

    ArrayList<String> names;
    ArrayList<String> views;
    ArrayList<String> searchRes;
    TextView textView;
    TextView textView0;

    public CustomAdapter(Context context, ArrayList<String> names, ArrayList<String> views) {
        super(context, R.layout.list_item, names);

        this.names = names;
        this.views = views;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());
        View customView = layoutInflater.inflate(R.layout.list_item, parent, false);

        textView = (TextView) customView.findViewById(R.id.recipeName);
        textView0 = (TextView) customView.findViewById(R.id.views);
        searchRes = new ArrayList<>();

        String name = names.get(position);
        String view = views.get(position);

        try {
            textView.setText(name.toUpperCase());
            textView0.setText("Views: \n" + view);
        }
        catch (Exception e){
            e.printStackTrace();
        }

       return customView;
    }



}
