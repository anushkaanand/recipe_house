package com.example.dishant.navdraw;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;


/**
 * A simple {@link Fragment} subclass.
 */
public class timeFrag extends Fragment {

    String ur;
    ArrayList<String> names;
    ArrayList<String> views;
    ProgressDialog progressDialog;


    @Override
    public void onStart() {
        super.onStart();

        final EditText editText = (EditText) getActivity().findViewById(R.id.time);
        Button button = (Button) getActivity().findViewById(R.id.getTimeRec);
        progressDialog = new ProgressDialog(getActivity());

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                progressDialog.setMessage("Loading");
                progressDialog.show();

                int time = Integer.parseInt(editText.getText().toString());
                ur = "http://warm-caverns-39626.herokuapp.com/api/recipes/time:"+time;
                try {


                    getList(ur);
                } catch (ExecutionException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                progressDialog.dismiss();


            }
        });


    }

    public timeFrag() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_time, container, false);
    }

    public void getList(String s) throws ExecutionException, InterruptedException, JSONException {
        down d = new down();
        String res = new down().execute(s).get();
        names = new ArrayList<>();
        views = new ArrayList<>();

        JSONArray array = new JSONArray(res);

        for (int i=0; i<array.length(); i++){
            JSONObject object = array.getJSONObject(i);
            String name = object.getString("name");
            names.add(name);
            int view = object.getInt("views");
            views.add(String.valueOf(view));
        }

        Intent intent = new Intent(getActivity(), TimeResult.class);
        intent.putStringArrayListExtra("names", names);
        intent.putStringArrayListExtra("views", views);
        startActivity(intent);


    }

    public class down extends AsyncTask<String, Void, String>{

        URL url;
        HttpURLConnection urlConnection;
        StringBuilder result;



        @Override
        protected String doInBackground(String... strings) {

            try {

                result = new StringBuilder();
                url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String current = "";

                while ((current = reader.readLine()) != null){
                    result.append(current);
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


            return result.toString();
        }
    }

}
