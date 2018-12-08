package com.example.fokin.recyclerviewquestion;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class StartActivity extends AppCompatActivity {

    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        btnStart = findViewById(R.id.buttonStart);
        btnStart.setOnClickListener(
                (view) ->{
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    view.getContext().startActivity(intent);
                }
        );
    }
}
