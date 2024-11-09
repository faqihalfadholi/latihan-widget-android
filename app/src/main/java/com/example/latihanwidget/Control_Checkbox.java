package com.example.latihanwidget;

import android.app.AlertDialog;
import android.content.Intent;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Control_Checkbox extends AppCompatActivity {


    Button button, btn_submit, btn_cancel;
    CheckBox checkBox1, checkBox2, checkBox3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_checkbox);

        button = findViewById(R.id.btn_checkbox);
        btn_submit = findViewById(R.id.button_kirim);
        btn_cancel = findViewById(R.id.button_batal);

        checkBox1 = findViewById(R.id.checkbox_option_1);
        checkBox2 = findViewById(R.id.checkbox_option_2);
        checkBox3 = findViewById(R.id.checkbox_option_3);

        btn_cancel.setOnClickListener(v -> {
            checkBox1.setChecked(false);
            checkBox2.setChecked(false);
            checkBox3.setChecked(false); });


        btn_submit.setOnClickListener(v -> {
            StringBuilder result = new StringBuilder();
            if (checkBox1.isChecked()) {
                result.append("Kamu Suka Nasi Padang!\n");
            }
            if (checkBox2.isChecked()) {
                result.append("Kamu Suka Bakso!\n");
            }
            if (checkBox3.isChecked()) {
                result.append("Kamu Suka Mie Gacoan!\n");
            }
            if (result.length() == 0) {
                Toast.makeText(this, "Silakan pilih setidaknya satu opsi terlebih dahulu!", Toast.LENGTH_SHORT).show();
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

        Intent i = new Intent(this, Control_ToogleButton.class);
        button.setOnClickListener(v -> startActivity(i));
    }
}