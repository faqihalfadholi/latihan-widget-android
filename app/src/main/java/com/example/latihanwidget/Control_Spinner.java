package com.example.latihanwidget;

import android.content.Intent;
import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.latihanwidget.data.Planet;

import java.util.ArrayList;
import java.util.List;

public class Control_Spinner extends AppCompatActivity {

    Spinner spinner, spinnerCustome;
    List<Planet> planetList;
    CustomeSpinnerAdapter customeAdapter;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_spinner);

        spinner = findViewById(R.id.spinner_simple);
        spinnerCustome = findViewById(R.id.spinner_custom);
        button = findViewById(R.id.btn_spinner);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.food_options, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedhobi = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(Control_Spinner.this, "kamu hobi " + selectedhobi + "? keren banget!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        planetList = new ArrayList<>();
        planetList.add(new Planet("Mercury", R.drawable.merkuri));
        planetList.add(new Planet("Venus", R.drawable.venus));
        planetList.add(new Planet("Earth", R.drawable.earth));
        planetList.add(new Planet("Mars", R.drawable.mars));
        planetList.add(new Planet("Jupiter", R.drawable.jupiter));
        planetList.add(new Planet("Saturn", R.drawable.saturn));
        planetList.add(new Planet("Uranus", R.drawable.uranus));
        planetList.add(new Planet("Neptune", R.drawable.neptune));
        planetList.add(new Planet("Pluto", R.drawable.pluto));

        // Mengatur CustomSpinnerAdapter untuk Spinner
        customeAdapter = new CustomeSpinnerAdapter(this, planetList);
        spinnerCustome.setAdapter(customeAdapter);

        spinnerCustome.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Planet selectedPlanet = planetList.get(position);

                Toast.makeText(Control_Spinner.this, "Kamu suka planet " + selectedPlanet.getPlanetname() + "?", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        Intent i = new Intent(this, Control_TimePicker.class);
        button.setOnClickListener(v -> startActivity(i));
    }
}