package com.example.latihanwidget;

import android.app.AlertDialog;
import android.content.Intent;
import android.widget.Button;
import android.widget.DatePicker;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

public class Control_DatePicker extends AppCompatActivity {

    DatePicker datePicker;
    Button button, btn_save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_date_picker);

        datePicker = findViewById(R.id.datePicker);
        button = findViewById(R.id.btn_datepicker);
        btn_save = findViewById(R.id.btn_save);

        Calendar calendar = Calendar.getInstance();
        datePicker.init(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH), null);

        long thirtyDaysAgo = System.currentTimeMillis() - 1000L * 60 * 60 * 24 * 7;
        datePicker.setMinDate(thirtyDaysAgo);

        btn_save.setOnClickListener(v -> {
            int day = datePicker.getDayOfMonth();
            int month = datePicker.getMonth() + 1; // Month is 0-based
            int year = datePicker.getYear();

            String selectedDate = day + "/" + month + "/" + year;

            new AlertDialog.Builder(Control_DatePicker.this)
                    .setTitle("Jadwal Kosong")
                    .setMessage("Kamu libur ditanggal " + selectedDate + "? Maen Yuk!")
                    .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                    .show();
        });

        Intent i = new Intent(this, MainActivity.class);
        button.setOnClickListener(v -> startActivity(i));
    }
}