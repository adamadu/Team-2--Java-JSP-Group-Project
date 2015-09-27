package com.android.team2.workshop8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //List that will hold all the agencies
    private List<Agency> agencies;

    private ListView listViewAgencies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //get the list view and assign the click listener
        listViewAgencies = (ListView) findViewById(R.id.listViewAgencies);
        listViewAgencies.setOnItemClickListener(this);

        AgencyDB agencyDB = new AgencyDB();
        try {
            //NOTE: USING .GET method  - THIS TURNS THE CALL FROM ASYNC TO SYNC AS IT WILL WAIT FOR THE RESULT
            //look into adding a contructor and getters to make it truly async
            agencies = (agencyDB.execute("http://192.168.1.125:8080/Day5AjaxAssignment/GetAgencies")).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if(agencies.size() > 0)
        {
            CustomArrayAdaptor agencyArrayAdaptor = new CustomArrayAdaptor(this, agencies);
            listViewAgencies.setAdapter(agencyArrayAdaptor);
        }
        else {
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
        intent.putExtra("agentId", agency.getAgencyId());
        //Start the activity
        this.startActivity(intent);
    }
}
