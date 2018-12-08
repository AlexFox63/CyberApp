package com.example.fokin.recyclerviewquestion;

import java.util.ArrayList;

public class Question {

    private ArrayList<Answer> answers = new ArrayList<>();
    private String textQuestion;
    private int questionPoint = 0;


    public Question(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public String getTextQuestion() {
        return textQuestion;
    }

    public int getQuestionPoint() {
        return questionPoint;
    }

    public void setTextQuestion(String textQuestion) {
        this.textQuestion = textQuestion;
    }

    public static class Answer {
        private Boolean correct;
        private String text;

        public Answer(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Boolean getCorrect() {
            return correct;
        }
    }

}
