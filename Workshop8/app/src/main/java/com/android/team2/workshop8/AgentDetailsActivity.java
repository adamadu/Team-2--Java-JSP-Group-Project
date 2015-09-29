package com.android.team2.workshop8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by Adam on 9/27/2015
 * Function: The activity for displaying the individual agent detail.
 */
public class AgentDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agent_details);
        //get the intent from the activity
        Intent intent = getIntent();
        //Set the textviews to the correct data.
        ((TextView)findViewById(R.id.tvAgtDetailFirstName)).setText(intent.getStringExtra("AgtFirstName"));
        ((TextView)findViewById(R.id.tvAgtDetailMiddleInitial)).setText(intent.getStringExtra("AgtMiddleInitial"));
        ((TextView)findViewById(R.id.tvAgtDetailLastName)).setText(intent.getStringExtra("AgtLastName"));
        ((TextView)findViewById(R.id.tvAgtDetailPosition)).setText(intent.getStringExtra("AgtPostion"));
        ((TextView)findViewById(R.id.tvAgtDetailEmail)).setText(intent.getStringExtra("AgtEmail"));
        ((TextView)findViewById(R.id.tvAgtDetailBusPhone)).setText(intent.getStringExtra("AgtBusPhone"));
    }
}
