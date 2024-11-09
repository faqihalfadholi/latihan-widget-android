package com.example.latihanwidget;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

public class Control_TimePicker extends AppCompatActivity {

    TimePicker timePicker;
    Button button, btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_time_picker);


        timePicker = findViewById(R.id.time_picker);
        btn_save = findViewById(R.id.btn_save);
        button = findViewById(R.id.btn_timepicker);

        timePicker.setIs24HourView(true);

        btn_save.setOnClickListener(v -> {
            int hour = timePicker.getHour();
            int minute = timePicker.getMinute();

            @SuppressLint("DefaultLocale") String time = String.format("%02d:%02d", hour, minute);

            new AlertDialog.Builder(Control_TimePicker.this)
                .setTitle("Hayoo....")
                .setMessage("emang kamu mau ngapain sih di jam  " + time + "? jangan aneh aneh deh!")
                .setPositiveButton("OK", (dialog, which) -> {

                })
                .show();
        });

        Intent i = new Intent(this, Control_DatePicker.class);
        button.setOnClickListener(v -> startActivity(i));

    }


}