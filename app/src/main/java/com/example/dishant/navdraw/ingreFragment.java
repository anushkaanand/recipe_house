package com.example.dishant.navdraw;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ingreFragment extends Fragment {

    public TextView t1, t2, t3, t4, t5, t6;
    TextView h2, h3, h4, h5, h6;
    ImageView i1, i2, i3, i4, i5;
    public String calling;
    ArrayList<String> ings;
    Button search;
    public static String ingr1, ingr2, ingr3, ingr4, ingr5, ingr6;
    public static String pos;
    String url;



    public ingreFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ingre, container, false);
        ings = new ArrayList<>();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        try {

            if(ingr6 != null){
                t1.setText(ingr1);
                ings.add(ingr1);
                h2.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);
                i2.setVisibility(View.VISIBLE);
                t2.setText(ingr2);
                ings.add(ingr2);
                h3.setVisibility(View.VISIBLE);
                t3.setVisibility(View.VISIBLE);
                i3.setVisibility(View.VISIBLE);
                t3.setText(ingr3);
                ings.add(ingr3);
                h4.setVisibility(View.VISIBLE);
                t4.setVisibility(View.VISIBLE);
                i4.setVisibility(View.VISIBLE);
                t4.setText(ingr4);
                ings.add(ingr4);
                h5.setVisibility(View.VISIBLE);
                t5.setVisibility(View.VISIBLE);
                i5.setVisibility(View.VISIBLE);
                t5.setText(ingr5);
                ings.add(ingr5);
                h6.setVisibility(View.VISIBLE);
                t6.setVisibility(View.VISIBLE);
                t6.setText(ingr6);
                ings.add(ingr6);
            }

            else if(ingr5 != null){
                t1.setText(ingr1);
                ings.add(ingr1);
                h2.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);
                i2.setVisibility(View.VISIBLE);
                t2.setText(ingr2);
                ings.add(ingr2);
                h3.setVisibility(View.VISIBLE);
                t3.setVisibility(View.VISIBLE);
                i3.setVisibility(View.VISIBLE);
                t3.setText(ingr3);
                ings.add(ingr3);
                h4.setVisibility(View.VISIBLE);
                t4.setVisibility(View.VISIBLE);
                i4.setVisibility(View.VISIBLE);
                t4.setText(ingr4);
                ings.add(ingr4);
                h5.setVisibility(View.VISIBLE);
                t5.setVisibility(View.VISIBLE);
                i5.setVisibility(View.VISIBLE);
                t5.setText(ingr5);
                ings.add(ingr5);
            } else if(ingr4 != null){
                t1.setText(ingr1);
                ings.add(ingr1);
                h2.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);
                i2.setVisibility(View.VISIBLE);
                t2.setText(ingr2);
                ings.add(ingr2);
                h3.setVisibility(View.VISIBLE);
                t3.setVisibility(View.VISIBLE);
                i3.setVisibility(View.VISIBLE);
                t3.setText(ingr3);
                ings.add(ingr3);
                h4.setVisibility(View.VISIBLE);
                t4.setVisibility(View.VISIBLE);
                i4.setVisibility(View.VISIBLE);
                t4.setText(ingr4);
                ings.add(ingr4);
            }
            else if(ingr3 != null){
                t1.setText(ingr1);
                ings.add(ingr1);
                h2.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);
                i2.setVisibility(View.VISIBLE);
                t2.setText(ingr2);
                ings.add(ingr2);
                h3.setVisibility(View.VISIBLE);
                t3.setVisibility(View.VISIBLE);
                i3.setVisibility(View.VISIBLE);
                t3.setText(ingr3);
                ings.add(ingr3);
            }

            else if(ingr2 != null){
                t1.setText(ingr1);
                ings.add(ingr1);
                h2.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);
                i2.setVisibility(View.VISIBLE);
                t2.setText(ingr2);
                ings.add(ingr2);
            }

            else if(ingr1 != null){
                t1.setText(ingr1);
                ings.add(ingr1);
            }




        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        t1 = (TextView) getActivity().findViewById(R.id.t1);
        t2 = (TextView) getView().findViewById(R.id.t2);
        t3 = (TextView) getView().findViewById(R.id.t3);
        t4 = (TextView) getView().findViewById(R.id.t4);
        t5 = (TextView) getView().findViewById(R.id.t5);
        t6 = (TextView) getView().findViewById(R.id.t6);

        h2 = (TextView) getView().findViewById(R.id.h2);
        h3 = (TextView) getView().findViewById(R.id.h3);
        h4 = (TextView) getView().findViewById(R.id.h4);
        h5 = (TextView) getView().findViewById(R.id.h5);
        h6 = (TextView) getView().findViewById(R.id.h6);

        i1 = (ImageView) getView().findViewById(R.id.i1);
        i2 = (ImageView) getView().findViewById(R.id.i2);
        i3 = (ImageView) getView().findViewById(R.id.i3);
        i4 = (ImageView) getView().findViewById(R.id.i4);
        i5 = (ImageView) getView().findViewById(R.id.i5);
        search = (Button) getView().findViewById(R.id.search);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(ings.size() == 0){
                    Toast.makeText(getActivity(), "Please choose the ingredients", Toast.LENGTH_LONG).show();
                }
                else if(ings.size() == 1){
                    url = "https://warm-caverns-39626.herokuapp.com/api/recipes/ing:"+ings.get(0).toLowerCase();
                }
                else if(ings.size() == 2){
                    url = "https://warm-caverns-39626.herokuapp.com/api/recipes/ings2:"+ings.get(0).toLowerCase()+","+ings.get(1).toLowerCase();
                }
                else if(ings.size() == 3){
                    url = "https://warm-caverns-39626.herokuapp.com/api/recipes/ings3:"+ings.get(0).toLowerCase()+","+ings.get(1).toLowerCase()+","+ings.get(2).toLowerCase();
                }
                else if(ings.size() == 4){
                    url = "https://warm-caverns-39626.herokuapp.com/api/recipes/ings4:"+ings.get(0).toLowerCase()+","+ings.get(1).toLowerCase()+","+ings.get(2).toLowerCase()+","+ings.get(3).toLowerCase();
                }
                else if(ings.size() == 5){
                    url = "https://warm-caverns-39626.herokuapp.com/api/recipes/ings5:"+ings.get(0).toLowerCase()+","+ings.get(1).toLowerCase()+","+ings.get(2).toLowerCase()+","+ings.get(3).toLowerCase()+","+ings.get(4).toLowerCase();
                }
                else if(ings.size() == 6){
                    url = "https://warm-caverns-39626.herokuapp.com/api/recipes/ings6:"+ings.get(0).toLowerCase()+","+ings.get(1).toLowerCase()+","+ings.get(2).toLowerCase()+","+ings.get(3).toLowerCase()+","+ings.get(4).toLowerCase()+","+ings.get(5).toLowerCase();
                }

                url = url.replaceAll(" ", "%20");
                Intent intent = new Intent(getActivity(), recipeList.class );
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Log.i("urlIng", url);
                intent.putExtra("url", url);
                (getActivity()).startActivity(intent);

            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calling = "one";

                ingreList ingreList = new ingreList();
                Bundle bundle = new Bundle();
                bundle.putString("calling", calling);
                ingreList.setArguments(bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragmentContainer, ingreList);
                fragmentTransaction.commit();
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calling = "two";
                ingreList ingreList = new ingreList();
                Bundle bundle = new Bundle();
                bundle.putString("calling", calling);
                ingreList.setArguments(bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragmentContainer, ingreList);
                fragmentTransaction.commit();
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calling = "three";
                ingreList ingreList = new ingreList();
                Bundle bundle = new Bundle();
                bundle.putString("calling", calling);
                ingreList.setArguments(bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragmentContainer, ingreList);
                fragmentTransaction.commit();
            }
        });

        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calling = "four";
                ingreList ingreList = new ingreList();
                Bundle bundle = new Bundle();
                bundle.putString("calling", calling);
                ingreList.setArguments(bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragmentContainer, ingreList);
                fragmentTransaction.commit();
            }
        });

        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calling = "five";
                ingreList ingreList = new ingreList();
                Bundle bundle = new Bundle();
                bundle.putString("calling", calling);
                ingreList.setArguments(bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragmentContainer, ingreList);
                fragmentTransaction.commit();
            }
        });

        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calling = "six";
                ingreList ingreList = new ingreList();
                Bundle bundle = new Bundle();
                bundle.putString("calling", calling);
                ingreList.setArguments(bundle);
                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getFragmentManager().beginTransaction();
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.replace(R.id.fragmentContainer, ingreList);
                fragmentTransaction.commit();
            }
        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                h2.setVisibility(View.VISIBLE);
                t2.setVisibility(View.VISIBLE);
                i2.setVisibility(View.VISIBLE);
            }
        });

        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                h3.setVisibility(View.VISIBLE);
                t3.setVisibility(View.VISIBLE);
                i3.setVisibility(View.VISIBLE);
            }
        });

        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                h4.setVisibility(View.VISIBLE);
                t4.setVisibility(View.VISIBLE);
                i4.setVisibility(View.VISIBLE);
            }
        });

        i4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                h5.setVisibility(View.VISIBLE);
                t5.setVisibility(View.VISIBLE);
                i5.setVisibility(View.VISIBLE);
            }
        });

        i5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                h6.setVisibility(View.VISIBLE);
                t6.setVisibility(View.VISIBLE);

            }
        });
    }


}



