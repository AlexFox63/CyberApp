package com.example.fokin.recyclerviewquestion.Fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.fokin.recyclerviewquestion.Activities.MainActivity;
import com.example.fokin.recyclerviewquestion.Adapters.DataAdapter;
import com.example.fokin.recyclerviewquestion.Enity.Answer;
import com.example.fokin.recyclerviewquestion.Enity.Question;
import com.example.fokin.recyclerviewquestion.R;
import com.example.fokin.recyclerviewquestion.utils.RandomShape;

import java.util.ArrayList;
import java.util.List;

public class FragmentQuestion extends Fragment {

    private  ArrayList<Question> questionList;
    private  ArrayList<Integer> sequence;
    private TextView textQuestion;

    public static int count_questions = 0;
    List<Answer> answers = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);

        View rootView = inflater.inflate(R.layout.question_fragment, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.list);

        loadJSON();

        textQuestion = rootView.findViewById(R.id.textQuestion);
        for (Question i: questionList){
            textQuestion.setText(i.toString());
        }
        // создаем адаптер
        DataAdapter adapter = new DataAdapter(getContext(), answers);

        count_questions = adapter.getItemCount();

        // устанавливаем для списка адаптер
        recyclerView.setAdapter(adapter);

        setInitialData();


        return rootView;

    }



    public ArrayList<Question> getQuestionList() {
        return questionList;
    }

    public void setQuestionList(ArrayList<Question> questionList) {
        this.questionList = questionList;
    }



    private void setInitialData(){
        //Сделать цикл до количества ответов в вопросе json
        answers.add(new Answer(true,"Протокол TCP/IP"));
        answers.add(new Answer(false,"Второй ответ"));
        answers.add(new Answer(false,"Третий"));
        answers.add(new Answer(false,"Четвертый"));

    }


    private void loadJSON(){
        new Thread(() -> {
                questionList = new ArrayList<>();
                for(Question q : MainActivity.questionList){
                        questionList.add(q);
                }
                System.out.println("загрузил");
                sequence = RandomShape.getRandomShape(questionList.size());
        }).start();
    }


}
