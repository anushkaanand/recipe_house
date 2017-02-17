package com.example.dishant.navdraw;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Recipe extends AppCompatActivity {

    TextView name, cuisine, type, desc, method, serves, calories;
    ImageView pic;

    String recName;
    ProgressDialog progressDialog;
    String recipe;
    ArrayList<String> ingredients;
    ListView listView;

    String name0;
    String image0;
    String cuisine0;
    String type0;
    String desc0;
    String method0;
    Bitmap img;
    int no0;
    int calories0;
    int time0;
    int serves0;
    int no;

    @Override
    protected void onResume() {
        super.onResume();

        progressDialog = new ProgressDialog(this, ProgressDialog.STYLE_SPINNER);
        progressDialog.setMessage("Please wait while we load the recipes for you...");
        progressDialog.setTitle("LOADING");
        progressDialog.setCancelable(false);
        progressDialog.show();

        recName = getIntent().getStringExtra("recipe");
        ingredients = new ArrayList<>();
        name = (TextView) findViewById(R.id.name);
        cuisine = (TextView) findViewById(R.id.cuisine);
        type = (TextView) findViewById(R.id.type);
        desc = (TextView) findViewById(R.id.desc);
        method = (TextView) findViewById(R.id.method);
        serves = (TextView) findViewById(R.id.serves);
        calories = (TextView) findViewById(R.id.cals);
        pic = (ImageView) findViewById(R.id.image);
        listView = (ListView) findViewById(R.id.ingreList);

        try {
            recDown();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
    }

    public void recDown() throws ExecutionException, InterruptedException {


        String url = "https://warm-caverns-39626.herokuapp.com/api/recipes/name:"+recName;
        url = url.replaceAll(" ", "%20");

        try {
            recipe = new downloadRecipe().execute(url).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        pic.setImageResource(R.drawable.food);


        try {
            JSONArray jsonArray = new JSONArray(recipe);
            Log.i("recipe", jsonArray.toString());
            JSONObject jsonObject = jsonArray.getJSONObject(0);
            name0 = jsonObject.getString("name");
            image0 = jsonObject.getString("image");
            cuisine0 = jsonObject.getString("cuisine");
            type0 = jsonObject.getString("type");
            desc0 = jsonObject.getString("desc");
            method0 = jsonObject.getString("method");
            no0 = jsonObject.getInt("no");
            serves0 = jsonObject.getInt("serves");
            calories0 = jsonObject.getInt("calories");

            JSONArray ing = jsonObject.getJSONArray("ingredients");
            JSONArray qua = jsonObject.getJSONArray("quantity");

            for(int i=0; i<no0; i++){
                String in = ing.getString(i);
                String q = qua.getString(i);
                String fin = in + " - " + q;
                ingredients.add(fin);
            }

            Log.i("ingredients", ingredients.toString());




        } catch (JSONException e) {
            e.printStackTrace();
        }

        name.setText(name0.toUpperCase());
        cuisine.setText(cuisine0);
        type.setText(type0);
        desc.setText(desc0);
        method.setText(method0);
        serves.setText("Serves :" + String.valueOf(serves0));
        calories.setText("Calories :" + String.valueOf(calories0));


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.ingre_item, ingredients);
        listView.setAdapter(arrayAdapter);

        DownloadImage downloadImage = new DownloadImage();
        img = new DownloadImage().execute(image0).get();

        pic.setImageBitmap(img);

        progressDialog.dismiss();

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
