package com.example.fokin.recyclerviewquestion;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.WithHint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FragmentQuestion extends Fragment {

    private List<Question> questions;
    private TextView textQuestion;

    public static int count_questions = 0;
    List<Question.Answer> answers = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View rootView = inflater.inflate(R.layout.question_fragment, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.list);

        new Thread(() -> questions = JSONHelper.importFromJSON(getContext())).start();
        new Thread(() -> {
            for ( Object i: questions){
                System.out.println(i);
            }
        }).start();

        textQuestion = rootView.findViewById(R.id.textQuestion);

        // создаем адаптер
        DataAdapter adapter = new DataAdapter(getContext(), answers);

        count_questions = adapter.getItemCount();

        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);

        setInitialData();


        return rootView;

    }




    private void setInitialData(){
        //Сделать цикл до количества ответов в вопросе json
        answers.add(new Question.Answer("Протокол TCP/IP"));
        answers.add(new Question.Answer("Второй ответ"));
        answers.add(new Question.Answer("Третий"));
        answers.add(new Question.Answer("Четвертый"));

    }





}
