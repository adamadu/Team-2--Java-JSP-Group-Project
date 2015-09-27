package com.android.team2.workshop8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Adam on 9/26/2015.
 */
public class CustomArrayAdaptor extends ArrayAdapter {

    public CustomArrayAdaptor(Context context, List<?> objects) {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (getItem(position) instanceof Agency) {
            // Get the agency item for this position
            Agency agency = (Agency) getItem(position);

            //Check if an existing view is being reused, otherwise inflate the view
            if (convertView == null)
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.agencies_listview_items, parent, false);

            // Lookup view for data population
            TextView tvAgencyCity = (TextView) convertView.findViewById(R.id.tvAgencyCity);
            TextView tvAgencyAddress = (TextView) convertView.findViewById(R.id.tvAgentsAgencyAddress);
            TextView tvAgencyPhone = (TextView) convertView.findViewById(R.id.tvAgencyPhone);

            // Populate the data into the template view using the data object
            tvAgencyAddress.setText(agency.getAgncyAddress());
            tvAgencyCity.setText(agency.getAgncyCity());
            tvAgencyPhone.setText(agency.getAgncyPhone());
        }
        else if (getItem(position) instanceof Agent)
        {
            Agent agent = (Agent) getItem(position);
            if (convertView == null)
                convertView = LayoutInflater.from(getContext()).inflate(R.layout.agents_listview_items, parent, false);

            // Lookup view for data population
            TextView tvAgentName = (TextView) convertView.findViewById(R.id.tvAgentName);
            TextView tvAgentPosition = (TextView) convertView.findViewById(R.id.tvAgentPosition);

            // Populate the data into the template view using the data object
            tvAgentName.setText(agent.getAgtFirstName() + " " + agent.getAgtMiddleInitial() + " " + agent.getAgtLastName());
            tvAgentPosition.setText(agent.getAgtPostion());
        }

        return convertView;
    }
}
