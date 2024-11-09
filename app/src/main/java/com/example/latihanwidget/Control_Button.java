package com.example.latihanwidget;

import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Control_Button extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_button);

        btn = findViewById(R.id.btn_button);

        Intent i = new Intent(Control_Button.this, Control_TextView.class);
        btn.setOnClickListener(v -> {startActivity(i);  });
    }
}