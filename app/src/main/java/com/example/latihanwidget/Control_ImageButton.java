package com.example.latihanwidget;

import android.content.Intent;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Control_ImageButton extends AppCompatActivity {

    ImageButton btn;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_image_button);

        btn = findViewById(R.id.imageButton3);
        btn.setOnClickListener(v -> {
            Toast.makeText(this, "Anda Baru Saja Mengikuti Chanel ini", Toast.LENGTH_SHORT).show();
        });

        btn2 = findViewById(R.id.btn_imagebutton);
        Intent i = new Intent(this, Control_Checkbox.class);
        btn2.setOnClickListener(v -> startActivity(i));
    }
}