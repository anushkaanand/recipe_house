package com.example.dishant.navdraw;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

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

public class calResult extends AppCompatActivity {

    ListView listView;
    ArrayList<String> names;
    ArrayList<String> views;
    String calurl;
    ListAdapter listAdapter;


    @Override
    protected void onStart() {
        super.onStart();


        names = new ArrayList<>();
        views = new ArrayList<>();
        getRes();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cal_result);
        calurl = getIntent().getStringExtra("string");

    }

    public void getRes(){
        download download = new download();
        Log.i("url", calurl);
        try {
            String res = new download().execute(calurl).get();

            Log.i("result", res);

            JSONArray jsonArray = new JSONArray(res);

            for (int i=0; i<jsonArray.length(); i++){

                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String name = jsonObject.getString("name");
                names.add(name);
                int view = jsonObject.getInt("views");
                views.add(String.valueOf(view));

            }

            listView = (ListView) findViewById(R.id.calList);
            listAdapter = new CustomAdapter(getApplicationContext(), names, views);
            listView.setAdapter(listAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    String send = adapterView.getItemAtPosition(i).toString();
                    Intent intent = new Intent(getApplicationContext(), Recipe.class);
                    intent.putExtra("recipe", send);
                    startActivity(intent);
                }
            });





        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public class download extends AsyncTask<String, Void, String>{

        StringBuilder result;
        URL url = null;
        HttpURLConnection httpURLConnection = null;

        @Override
        protected String doInBackground(String... strings) {

            try {

                result = new StringBuilder();

                url = new URL(strings[0]);
                httpURLConnection = (HttpURLConnection) url.openConnection();
                InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader reader = new BufferedReader(inputStreamReader);
                String current = "";

                while((current = reader.readLine()) != null){
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
