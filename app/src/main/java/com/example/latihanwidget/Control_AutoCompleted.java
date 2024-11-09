package com.example.latihanwidget;

import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Control_AutoCompleted extends AppCompatActivity {

    AutoCompleteTextView autoCompleteTextView;
    Button btn;

    String[] aseanCountries = {
            "Indonesia",
            "Malaysia",
            "Singapore",
            "Thailand",
            "Philippines",
            "Vietnam",
            "Brunei",
            "Cambodia",
            "Laos",
            "Myanmar"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_auto_completed);

        autoCompleteTextView = findViewById(R.id.auto_complete);
        btn = findViewById(R.id.btn_autocompleted);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.select_dialog_item, aseanCountries);

        autoCompleteTextView.setThreshold(1);

        autoCompleteTextView.setAdapter(adapter);

        Intent i = new Intent(this , Control_ImageButton.class);
        btn.setOnClickListener(v -> startActivity(i));
    }
}