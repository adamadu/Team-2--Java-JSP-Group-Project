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
 * Function: The AgencyDB class responsible for fetching the data from the web service
 */
public class AgencyDB extends AsyncTask<String, Void, List<Agency>> {


    @Override
    protected List<Agency> doInBackground(String... params) {
        //Create the list for all our retured agencies to be stored
        List<Agency> agencies = new ArrayList<>();
        try {
            //Open an httpurlconnection to the url provided in the parameters
            URL url = new URL(params[0]);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            //set request headers and send the request to the web service
            httpConn.setRequestMethod("GET");
            httpConn.setRequestProperty("Content-length", "0");
            httpConn.setUseCaches(false);
            httpConn.setAllowUserInteraction(false);

            httpConn.connect();
            //Get the status of the service response which will be used to check if it was sucessfull or not
            int status = httpConn.getResponseCode();

            //Read the response from the service
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));

            //While we have a new response line, fetch the JSON data and create a new Agency Object.
            String next;
            while((next = bufferedReader.readLine()) != null)
            {
                JSONArray jsonArray = new JSONArray(next);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jo = jsonArray.getJSONObject(i);
                    Agency agency = new Agency();
                    agency.setAgencyId(jo.getInt("AgencyId"));
                    agency.setAgncyAddress(jo.getString("AgncyAddress"));
                    agency.setAgncyCity(jo.getString("AgncyCity"));
                    agency.setAgncyPhone(jo.getString("AgncyPhone"));
                    //Add the agency object to the agencies list
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
