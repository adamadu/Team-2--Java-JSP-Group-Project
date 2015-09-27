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

public class AgentsActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private int agencyId;
    private List<Agent> agents;
    private ListView listViewAgents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agents);

        TextView tvAgncyAddress = (TextView)findViewById(R.id.tvAgentsAgencyAddress);
        listViewAgents = (ListView)findViewById(R.id.listViewAgents);
        Intent intent = getIntent();
        agencyId = intent.getIntExtra("AgencyId", 0);
        tvAgncyAddress.setText(intent.getStringExtra("AgncyAddress"));
        listViewAgents.setOnItemClickListener(this);

        AgentDB agentDB = new AgentDB();
        try {
            //NOTE: USING .GET() method  - THIS TURNS THE CALL FROM ASYNC TO SYNC AS IT WILL WAIT FOR THE RESULT
            //look into adding a contructor and getters to make it truly async
            agents = agentDB.execute(new String[] {getResources().getString(R.string.web_service_url) + "/GetAgents", "selectedAgencyId="+agencyId}).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if(agents.size() > 0) {
            CustomArrayAdaptor arrayAdaptor = new CustomArrayAdaptor(this, agents);
            listViewAgents.setAdapter(arrayAdaptor);

        } else {
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
