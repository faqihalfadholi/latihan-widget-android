package com.example.latihanwidget;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.switchmaterial.SwitchMaterial;

public class Control_ToogleButton extends AppCompatActivity {

    ToggleButton toggleButton1, toggleButton2;
    SwitchMaterial toggleButton3;
    Button buttonSubmit, button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_toogle_button);


        toggleButton1 = findViewById(R.id.toggle_button_1);
        toggleButton2 = findViewById(R.id.toggle);
        toggleButton3 = findViewById(R.id.material_switch);
        buttonSubmit = findViewById(R.id.button_kirim);
        button = findViewById(R.id.btn_tooglebutton);

        toggleButton1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                toggleButton1.setTextColor(Color.WHITE);
            } else {
                toggleButton1.setTextColor(Color.RED);
            }
        });

        toggleButton2.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                toggleButton2.setTextColor(Color.GREEN);
            } else {
                toggleButton2.setTextColor(Color.RED);
            }
        });

        toggleButton3.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                toggleButton3.setTextColor(Color.GREEN);
            } else {
                toggleButton3.setTextColor(Color.RED);
            }
        });


        buttonSubmit.setOnClickListener(v -> {
            StringBuilder result = new StringBuilder();

            if (toggleButton1.isChecked()) {
                result.append("Kamu suka Nasi Padang!\n");
            }
            if (toggleButton2.isChecked()) {
                result.append("Kamu suka Bakso!\n");
            }
            if (toggleButton3.isChecked()) {
                result.append("Kamu suka Mie Gacoan!\n");
            }

            if (result.length() == 0) {
                Toast.makeText(this, "Pilih setidaknya satu makanan saja!", Toast.LENGTH_SHORT).show();
            } else {
                if (result.length() > Toast.LENGTH_LONG) {
                    new AlertDialog.Builder(this)
                            .setTitle("Hasil Pilihan")
                            .setMessage(result.toString())
                            .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                            .show();
                } else {
                    Toast.makeText(this, result.toString(), Toast.LENGTH_LONG).show();
                }
            }
        });

        Intent i = new Intent(this, Control_RadioGroup.class);
        button.setOnClickListener(v -> startActivity(i));
    }
}
