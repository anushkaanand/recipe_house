package com.example.dishant.navdraw;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ingreList extends ListFragment  {

    ArrayList<String> ingres;

    String calling;

    public ingreList() {


    }

    @Override
    public void onResume() {
        super.onResume();

        ingres = new ArrayList<>();

        ingres.add("Salt");
        ingres.add("Sugar");
        ingres.add("Cardamom");
        ingres.add("Green chilly");
        ingres.add("Red chilly");
        ingres.add("Turmeric");
        ingres.add("Fresh Cream");
        ingres.add("Tomato");
        ingres.add("Onion");
        ingres.add("Potato");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), R.layout.text_item, ingres);
        getListView().setAdapter(arrayAdapter);
        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String ing = adapterView.getItemAtPosition(i).toString();
                Log.i("ing", ing);

                ingreFragment ingreFragment = new ingreFragment();

                if(calling.equals("one")){
                    ingreFragment.ingr1 = ing;
                } else if(calling.equals("two")){
                    ingreFragment.ingr2 = ing;
                } else if(calling.equals("three")){
                    ingreFragment.ingr3 = ing;
                } else if(calling.equals("four")){
                    ingreFragment.ingr4 = ing;
                } else if(calling.equals("five")){
                    ingreFragment.ingr5 = ing;
                } else if(calling.equals("six")){
                    ingreFragment.ingr6 = ing;
                }
                getFragmentManager().popBackStackImmediate();



            }
        });

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ingre_list, container, false);
        calling = getArguments().getString("calling");

        return view;
    }





}
