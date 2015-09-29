package com.android.team2.workshop8;

import android.content.Intent;
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
 * Function: The activity for displaying the Agents in the list
 */
public class AgentsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    //The agencyid that we will be sending to the webservice to fetch the agents
    private int agencyId;
    //The list of agents that we will be recieved from the webservice
    private List<Agent> agents;
    //The list view that will be used to display Agent information.
    private ListView listViewAgents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agents);
        //Set the local props
        TextView tvAgncyAddress = (TextView)findViewById(R.id.tvAgentsAgencyAddress);
        listViewAgents = (ListView)findViewById(R.id.listViewAgents);

        //get the intent from the activity and set additional local props
        Intent intent = getIntent();
        agencyId = intent.getIntExtra("AgencyId", 0);
        tvAgncyAddress.setText(intent.getStringExtra("AgncyAddress"));

        //Add the item click listner to the list view
        listViewAgents.setOnItemClickListener(this);

        //Instantiate a new agendb object to send and recieve data from the web service
        AgentDB agentDB = new AgentDB();
        try {
            //NOTE: USING .GET() method  - THIS TURNS THE CALL FROM ASYNC TO SYNC AS IT WILL WAIT FOR THE RESULT
            //look into adding a contructor and getters to make it truly async or do this in the onpostexecute
            agents = agentDB.execute(new String[] {getResources().getString(R.string.web_service_url) + "/GetAgents", "selectedAgencyId="+agencyId}).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        //If our agents list contains values, we will display it in the list view
        if(agents.size() > 0) {
            CustomArrayAdaptor arrayAdaptor = new CustomArrayAdaptor(this, agents);
            listViewAgents.setAdapter(arrayAdaptor);

        } else {
            //temp error handling for now.
            System.out.println("List is empty!");
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Register new intent
        Intent intent = new Intent(this, AgentDetailsActivity.class);
        //Get the agency object that was clicked
        Agent agent = (Agent) parent.getItemAtPosition(position);
        //pass the id to the intent
        intent.putExtra("AgtFirstName", agent.getAgtFirstName());
        intent.putExtra("AgtMiddleInitial", agent.getAgtMiddleInitial());
        intent.putExtra("AgtLastName", agent.getAgtLastName());
        intent.putExtra("AgtPostion", agent.getAgtPostion());
        intent.putExtra("AgtEmail", agent.getAgtEmail());
        intent.putExtra("AgtBusPhone", agent.getAgtBusPhone());

        //Start the activity
        this.startActivity(intent);
    }
}
