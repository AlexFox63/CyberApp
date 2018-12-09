package com.example.fokin.recyclerviewquestion;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

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



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.app_bar_about:
                Toast.makeText(getApplicationContext(), "Вы выбрали офф сайт", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.app_bar_pay:
                Toast.makeText(getApplicationContext(), "Вы заплатили налоги", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
