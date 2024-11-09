package com.example.latihanwidget;

import android.content.Intent;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Control_TextView extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_text_view);

        btn = findViewById(R.id.btn_textview);
        Intent i = new Intent(this, Control_EditText.class);
        btn.setOnClickListener(v -> startActivity(i));
    }
}