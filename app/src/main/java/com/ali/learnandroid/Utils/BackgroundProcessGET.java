package com.ali.learnandroid.Utils;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class BackgroundProcessGET extends AsyncTask<Void, String, String> {
    private String url;
    private AsyncResponse listener;

    public interface AsyncResponse {
        void resultsFromBackgroundTask(String results); //to send back results to MainActivity
        void exceptionFromBackgroundTask(String exception); //to send back exception to MainActivity
    }

    //Constructor to initialize variables
    public BackgroundProcessGET(String url , AsyncResponse listener) {
        this.url = url;
        this.listener = listener;
    }

    //Doing Background work here
    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL url = new URL(this.url);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStream inputStream;
            int code = connection.getResponseCode();
            if (code == HttpURLConnection.HTTP_OK) {
                inputStream = connection.getInputStream();
            } else {
                inputStream = connection.getErrorStream();
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                builder.append(line).append("\n");
            }
            return builder.toString();
        } catch (Exception e) {
            return "Exception: " + e.getMessage();
        }
    }

    //This method receives results from background and send them to MainActivity(UI)
    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if (result.contains("Exception")) {
            listener.exceptionFromBackgroundTask(result); //sending exception to MainActivity
        } else {
            listener.resultsFromBackgroundTask(result); //sending result to MainActivity
        }
    }



}
