package com.example.fokin.recyclerviewquestion;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Question.Answer> answers = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setInitialData();
        RecyclerView recyclerView = findViewById(R.id.list);
        // создаем адаптер
        DataAdapter adapter = new DataAdapter(this, answers);
        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);
    }

    private void setInitialData(){

        answers.add(new Question.Answer("Протокол TCP/IP"));
        answers.add(new Question.Answer("Второй ответ"));
        answers.add(new Question.Answer("Третий"));
        answers.add(new Question.Answer("Четвертый"));

    }
}
