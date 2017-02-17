package com.example.dishant.navdraw;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by dishant on 26/1/17.
 */
public class DownloadImage extends AsyncTask<String, Void, Bitmap> {

    Bitmap result;
    @Override
    protected Bitmap doInBackground(String... strings) {

        try {
            URL url = new URL(strings[0]);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            result = BitmapFactory.decodeStream(inputStream);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return result;
    }
}
