package com.example.dishant.navdraw;


import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class calories extends Fragment {

    int min;
    int max;
    EditText low, high;
    Button button;
    String url;


    public calories() {
        // Required empty public constructor
    }

    @Override
    public void onStart() {
        super.onStart();

        low = (EditText) getActivity().findViewById(R.id.lower);
        high = (EditText) getActivity().findViewById(R.id.higher);
        button = (Button) getActivity().findViewById(R.id.getCalRec);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                min = Integer.parseInt(low.getText().toString());
                max = Integer.parseInt(high.getText().toString());
                url = "http://warm-caverns-39626.herokuapp.com/api/recipes/rcalories:" +min +","+max;
                Intent intent = new Intent(getActivity(), calResult.class);
                intent.putExtra("string", url);
                startActivity(intent);
            }
        });



    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_calories, container, false);

        return view;
    }


}
