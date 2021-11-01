package com.mrwojack.quiz;

import android.content.res.ColorStateList;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Collections;
import java.util.List;

public class GameActivity extends AppCompatActivity {
private List<NormalQuestion> questionList;

private ColorStateList textColorDefault;
private int questionCounter;
private int questionCountTotal;
private int questionCorrect;

private int score;
private boolean answered;

    private List<MultipleChoiceQuestions> questionsList3;

    /**
     * Método ejecutado cuando se crea la actividad
     * @param savedInstanceState -> Referencia a objeto bundle que guarda el estado anterior de la actividad
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper DBhelper3 = new DbHelper( (this));
        questionsList3 = DBhelper3.getAllMultipleQuestions();

    }
}