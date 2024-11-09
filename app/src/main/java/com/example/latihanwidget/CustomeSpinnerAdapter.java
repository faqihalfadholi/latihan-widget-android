package com.example.latihanwidget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.latihanwidget.data.Planet;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class CustomeSpinnerAdapter extends BaseAdapter {

    Context context;
    List<Planet> planetList;
    LayoutInflater inflater;

    public CustomeSpinnerAdapter(Context context, List<Planet> planetList) {
        this.context = context;
        this.planetList = planetList;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return planetList.size();
    }

    @Override
    public Object getItem(int position) {
        return planetList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_spinner, parent, false);
        }

        ImageView icon = convertView.findViewById(R.id.planet_icon);
        TextView text = convertView.findViewById(R.id.planet_name);

        Planet planet = planetList.get(position);
        icon.setImageResource(planet.getImageplanet());
        text.setText(planet.getPlanetname());

        return convertView;
    }

    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        return getView(position, convertView, parent);
    }
}
