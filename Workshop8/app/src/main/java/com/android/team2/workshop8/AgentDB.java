package com.android.team2.workshop8;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adam on 9/27/2015.
 * Function: The AgentDB class responsible for sending a request fetching the response from the web service
 */
public class AgentDB extends AsyncTask<String, Void, List<Agent>>{
    @Override
    protected List<Agent> doInBackground(String... params) {
        //Create the list for all our retured agents to be stored
        List<Agent> agents = new ArrayList<>();
        try {
            //Open an httpurlconnection to the url provided in the parameter[0]
            URL url = new URL(params[0]);
            HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
            //set request headers and send the request to the web service
            httpConn.setRequestMethod("POST");
            //httpConn.setRequestProperty("Content-length", "0");
            httpConn.setUseCaches(false);
            httpConn.setAllowUserInteraction(false);
            httpConn.connect();

            //Write the request data (in params[1]) that is going to be send to the webservice
            OutputStream outputStream = httpConn.getOutputStream();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
            writer.write(params[1]);
            writer.close();
            outputStream.close();

            // Read the response from the service
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream()));

            // While we have a new response line, fetch the JSON data and create a new Agent Object.
            String next;
            while((next = bufferedReader.readLine()) != null)
            {
                JSONArray jsonArray = new JSONArray(next);
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject jo = jsonArray.getJSONObject(i);
                    Agent agent = new Agent();
                    agent.setAgentId(jo.getInt("AgentId"));
                    agent.setAgtBusPhone(jo.getString("AgtBusPhone"));
                    agent.setAgtEmail(jo.getString("AgtEmail"));
                    agent.setAgtFirstName(jo.getString("AgtFirstName"));
                    agent.setAgtLastName(jo.getString("AgtLastName"));
                    if(jo.has("AgtMiddleInitial"))
                        agent.setAgtMiddleInitial(jo.getString("AgtMiddleInitial"));
                    else
                        agent.setAgtMiddleInitial("");
                    agent.setAgtPostion(jo.getString("AgtPosition"));
                    //Add the agennt object to the agents list
                    agents.add(agent);
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
        return agents;
    }
}
