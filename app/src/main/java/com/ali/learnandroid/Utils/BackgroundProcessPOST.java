package com.ali.learnandroid.Utils;

import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class BackgroundProcessPOST extends AsyncTask<Void, String, String> {

    private String url, data;
    private AsyncResponse mListener;

    public interface AsyncResponse {
        void resultsFromBackgroundTask(String results); //to send back results to MainActivity
        void exceptionFromBackgroundTask(String exception); //to send back exception to MainActivity
    }

    //Constructor to initialize variables
    public BackgroundProcessPOST(String url , String data , AsyncResponse  listener) {
        this.url = url;
        this.data = data;
        this.mListener = listener;
    }

    //Doing Background work here
    @Override
    protected String doInBackground(Void... voids) {
        try {
            URL url = new URL(this.url); //setting url
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection(); //opening connection to url

            connection.setRequestMethod("POST");    //setting request method

            OutputStream outputStream = connection.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter
                    (new OutputStreamWriter(outputStream, "UTF-8"));
            bufferedWriter.write(data);
            bufferedWriter.flush();
            bufferedWriter.close();
            outputStream.close();

            InputStream inputStream;
            int code = connection.getResponseCode(); // receiving code to check
                                                    // data posted successfully or not
            if (code == HttpURLConnection.HTTP_OK) {
                inputStream = connection.getInputStream(); //if code=200 means data is OK
                                                          // we can receive response
            } else {
                inputStream = connection.getErrorStream();  // data not sent successfully,
            }

            BufferedReader bufferedReader = new BufferedReader
                    (new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String line = "";
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
            mListener.exceptionFromBackgroundTask(result); //sending exception to MainActivity
        } else {
            mListener.resultsFromBackgroundTask(result); //sending result to MainActivity
        }
    }

}
