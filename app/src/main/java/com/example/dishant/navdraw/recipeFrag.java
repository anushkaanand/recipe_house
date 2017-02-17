package com.example.dishant.navdraw;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class recipeFrag extends ListFragment {

    ArrayList<String> ingres;


    public recipeFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recipe, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ingres = new ArrayList<>();


        ingres.add("salt");
        ingres.add("sugar");
        ingres.add("red chilly");
        ingres.add("green chilly");
        ingres.add("coriander");
        ingres.add("fresh cream");
        ingres.add("egg");
        ingres.add("milk");
        ingres.add("maida");
        ingres.add("wheat flour");



        try {
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(getActivity(), R.layout.list_item, ingres);
            setListAdapter(arrayAdapter);
        }catch (NullPointerException e){
            e.printStackTrace();
        }





    }
}
