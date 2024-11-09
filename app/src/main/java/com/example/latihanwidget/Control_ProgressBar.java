package com.example.latihanwidget;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Handler;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Control_ProgressBar extends AppCompatActivity {

    ProgressBar progressBarIncrease, progressBarLoading;
    Button buttonIncrease, buttonReset, buttonLoading, buttonDownload, button;
    Handler handler = new Handler();
    AlertDialog alertDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_progress_bar);

        progressBarIncrease = findViewById(R.id.progressBar);
        buttonIncrease = findViewById(R.id.button_increase);
        buttonReset = findViewById(R.id.button_reset);
        progressBarLoading = findViewById(R.id.progressBarIndeterminate);
        buttonLoading = findViewById(R.id.button_start_loading);
        buttonDownload = findViewById(R.id.download_btn);
        button = findViewById(R.id.btn_progressbar);

        buttonIncrease.setOnClickListener(v -> {
            int currentProgress = progressBarIncrease.getProgress();
            if (currentProgress < progressBarIncrease.getMax()) {
                progressBarIncrease.setProgress(currentProgress + 10);
                Toast.makeText(this, "Progress: "+ progressBarIncrease.getProgress() + "%", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Progress sudah mencapai 100%", Toast.LENGTH_SHORT).show();
            }
        });

        buttonReset.setOnClickListener(v -> {
            progressBarIncrease.setProgress(0);
            Toast.makeText(this, "Progress reset ke 0%", Toast.LENGTH_SHORT).show();
        });

        buttonLoading.setOnClickListener(v -> {
            progressBarLoading.setVisibility(ProgressBar.VISIBLE);
            buttonLoading.setEnabled(false);
            new Thread(() -> {
                for (int i = 0; i <= 100; i++) {
                    try {
                        Thread.sleep(50);
                        final int progress = i;
                        handler.post(() -> progressBarLoading.setProgress(progress));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                handler.post(() -> {
                    progressBarLoading.setVisibility(ProgressBar.GONE);
                    Toast.makeText(Control_ProgressBar.this, "Loading selesai", Toast.LENGTH_SHORT).show();
                    buttonLoading.setEnabled(true);
                });
            }).start();
        });

        buttonDownload.setOnClickListener(v -> showDownloadDialog());

        Intent i = new Intent(this, Control_Spinner.class);
        button.setOnClickListener(v -> startActivity(i));


    }

    private void showDownloadDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Download File");
        builder.setMessage("Downloading file...");
        builder.setCancelable(false);

        ProgressBar progressBar = new ProgressBar(this);
        builder.setView(progressBar);

        AlertDialog dialog = builder.create();
        dialog.show();

        new Handler().postDelayed(() -> {
            dialog.dismiss();
            Toast.makeText(this, "Download completed", Toast.LENGTH_SHORT).show();
        }, 5000); // 5 seconds
    }
}