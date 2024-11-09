package com.example.latihanwidget;

import android.content.Intent;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Control_RadioGroup extends AppCompatActivity {

    RadioGroup radioGroup;
    Button buttonSubmit, button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_radio_group);

        radioGroup = findViewById(R.id.radioGroup_game);
        buttonSubmit = findViewById(R.id.button_submit);
        button = findViewById(R.id.btn_radiogroup);

        buttonSubmit.setOnClickListener(v -> {
            int selectedId = radioGroup.getCheckedRadioButtonId();

            if (selectedId != -1) {
                RadioButton radioButton = findViewById(selectedId);
                String selectedValue = radioButton.getText().toString();
                Toast.makeText(this, "Emang Game " + selectedValue + " Seru?", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Yakin gak main game???", Toast.LENGTH_SHORT).show();
            }
        });

        Intent i = new Intent(this, Control_ProgressBar.class);
        button.setOnClickListener(v -> startActivity(i));
    }
}