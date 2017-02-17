package com.example.dishant.navdraw;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
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

public class recipeList extends AppCompatActivity {
    down d ;

    ListView listView;
    ArrayList<String> names;
    ArrayList<String> views;
    ProgressDialog progressDialog = null;
    String url;
    String res;


    @Override
    protected void onResume() {
        super.onResume();
        listView = (ListView) findViewById(R.id.recipes);
        names = new ArrayList<>();
        views = new ArrayList<>();
        progressDialog = new ProgressDialog(this, ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Please wait while we load the recipes for you...");
        progressDialog.setTitle("LOADING");
        progressDialog.setCancelable(false);
        progressDialog.show();
        downStarted();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_list);

        url = getIntent().getStringExtra("url");
    }

    public void downStarted(){



        d= new down();

        try {

            res = new down().execute(url).get();

            JSONArray jsonArray = new JSONArray(res);

            for (int k = 0; k<jsonArray.length(); k++){
                JSONObject jsonObject = jsonArray.getJSONObject(k);
                String name = jsonObject.getString("name");
                int view = jsonObject.getInt("views");
                names.add(name);
                views.add(String.valueOf(view));
            }



        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (ExecutionException e1) {
            e1.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        ListAdapter arrayAdapter = new CustomAdapter(getApplicationContext(), names, views);
            listView.setAdapter(arrayAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String recName = adapterView.getItemAtPosition(i).toString();
                Intent intent = new Intent(getApplicationContext(), Recipe.class);
                intent.putExtra("recipe", recName);
                startActivity(intent);


            }
        });
            progressDialog.dismiss();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
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
