package com.example.latihanwidget;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Control_EditText extends AppCompatActivity {

    Button btn_hello, button;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_edit_text);


        editText = findViewById(R.id.inputText);
        btn_hello = findViewById(R.id.btn_hello);
        button = findViewById(R.id.btn_edittext);

        btn_hello.setOnClickListener(v -> {
            String name = editText.getText().toString();

            Toast toast = Toast.makeText(this, "Hello, " + name, Toast.LENGTH_SHORT);
            toast.show();
        });




        Intent i = new Intent(this, Control_AutoCompleted.class);
        button.setOnClickListener(v -> startActivity(i));
    }
}