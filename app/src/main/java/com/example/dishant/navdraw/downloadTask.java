package com.example.dishant.navdraw;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

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


public class downloadTask extends AsyncTask<String, Void, ArrayList<String>> {
    StringBuilder result;
    URL url = null;
    HttpURLConnection httpURLConnection = null;

    Activity activity = null;
    ArrayList<String> namelist;




    @Override
    protected void onPreExecute() {

    }

    @Override
    protected ArrayList<String> doInBackground(String... urls) {

        result = new StringBuilder();

        namelist = new ArrayList<>();

        try {
            url = new URL(urls[0]);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader reader = new BufferedReader(inputStreamReader);

            String current = "";

            while ((current = reader.readLine()) != null) {
                result.append(current);
            }

            Log.i("result", result.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        JSONArray jsonArray = null;
        try {
            jsonArray = new JSONArray(result.toString());
            for (int i = 0; i < jsonArray.length(); i++) {
                String a = jsonArray.getString(i);
                JSONObject jsonObject = new JSONObject(a);
                String name = jsonObject.getString("name");
                namelist.add(name);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return namelist;
    }

    @Override
    protected void onPostExecute(ArrayList<String> strings) {
        super.onPostExecute(strings);

    }
}
