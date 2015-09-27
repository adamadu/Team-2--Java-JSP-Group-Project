package com.android.team2.workshop8;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 9/26/2015.
 */
public class AgencyDB extends AsyncTask<String, Void, List<Agency>> {


    @Override
    protected List<Agency> doInBackground(String... params) {
        List<Agency> agencies = new ArrayList<>();
        try {
            URL url = new URL(params[0]);

            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            httpConn.setRequestMethod("GET");
            httpConn.setRequestProperty("Content-length", "0");
            httpConn.setUseCaches(false);
            httpConn.setAllowUserInteraction(false);
            //httpConn.setConnectTimeout(timeout);
            //httpConn.setReadTimeout(timeout);
            httpConn.connect();
            int status = httpConn.getResponseCode();

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));



            String next;
            while((next = bufferedReader.readLine()) != null)
            {
                JSONArray jsonArray = new JSONArray(next);
                for (int i = 0; i < jsonArray.length(); i++) {
                    System.out.println("reading data from stream");
                    JSONObject jo = jsonArray.getJSONObject(i);
                    Agency agency = new Agency();
                    agency.setAgencyId(jo.getInt("AgencyId"));
                    agency.setAgncyAddress(jo.getString("AgncyAddress"));
                    agency.setAgncyCity(jo.getString("AgncyCity"));
                    agency.setAgncyPhone(jo.getString("AgncyPhone"));
                    agencies.add(agency);
                }
            }

        bufferedReader.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return agencies;
    }
}
