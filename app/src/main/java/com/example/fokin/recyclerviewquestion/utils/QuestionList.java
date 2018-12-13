package com.example.fokin.recyclerviewquestion.utils;

import com.example.fokin.recyclerviewquestion.Enity.Question;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;

public class QuestionList {
    private ArrayList<Question> entity;

    public ArrayList<Question> getEntity() {
        return entity;
    }

    public QuestionList setEntity(ArrayList<Question> entity) {
        this.entity = entity;
        return this;
    }

    public static void outQuestionList(ArrayList<Question> list, String file){
        try(PrintWriter pw = new PrintWriter(new File(file))){
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String full = gson.toJson(new QuestionList().setEntity(list));
            pw.println(full);
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }


    public static ArrayList<Question> getFromJSON(String fileName) throws IOException {
        BufferedReader reader
                = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fileName), "UTF-8"));
        String temp;
        StringBuilder jsonString = new StringBuilder();

        while ((temp = reader.readLine()) != null){
            jsonString.append(temp);
        }
        QuestionList gson = new Gson().fromJson(jsonString.toString(), QuestionList.class);

        return gson.getEntity();
    }
}