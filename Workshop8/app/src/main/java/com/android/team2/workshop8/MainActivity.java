package com.android.team2.workshop8;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by Adam on 9/28/2015
 * Function: The entry point (main activity) of this application.
 */
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //List that will hold all the agencies
    private List<Agency> agencies;
    //The list view to display all the agencies
    private ListView listViewAgencies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the list view and assign the click listener
        listViewAgencies = (ListView) findViewById(R.id.listViewAgencies);
        listViewAgencies.setOnItemClickListener(this);
        TextView myTextView=(TextView)findViewById(R.id.welcomeTextView);
        Typeface typeFace=Typeface.createFromAsset(getAssets(),"FFF_Tusj.ttf");
        myTextView.setTypeface(typeFace);

        //Instantiate a new agencydb object to send and recieve data from the web service
        AgencyDB agencyDB = new AgencyDB();
        try {
            //NOTE: USING .GET() method  - THIS TURNS THE CALL FROM ASYNC TO SYNC AS IT WILL WAIT FOR THE RESULT
            //look into adding a contructor and getters to make it truly async or do this in the onpostexecute
            agencies = (agencyDB.execute((getResources().getString(R.string.web_service_url) + "/GetAgencies"))).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //If our agencies list contains data, then we will display it in the list view
        if(agencies.size() > 0)
        {
            CustomArrayAdaptor agencyArrayAdaptor = new CustomArrayAdaptor(this, agencies);
            listViewAgencies.setAdapter(agencyArrayAdaptor);
        }
        else {
            //temp error reporting for now.
            System.out.println("ARRAY LIST IS EMPTY");
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Register new intent
        Intent intent = new Intent(this, AgentsActivity.class);
        //Get the agency object that was clicked
        Agency agency = (Agency) parent.getItemAtPosition(position);
        //pass the id to the intent
        intent.putExtra("AgencyId", agency.getAgencyId());
        intent.putExtra("AgncyAddress", agency.getAgncyAddress());
        //Start the activity
        this.startActivity(intent);
    }
}
