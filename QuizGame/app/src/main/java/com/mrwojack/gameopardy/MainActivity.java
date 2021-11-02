package com.mrwojack.gameopardy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import com.mrwojack.gameopardy.fragments.questions.Questions;
import com.mrwojack.gameopardy.fragments.questions.NormalQuestion;

import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    private List<Questions> questionsList;

public static final String EXTRA_SCORE = "extraScore";
private static final long COUNTDOWN_IN_MILLIS = 12000;
private ColorStateList textColorDefaultCd;
private TextView textViewCountDown;
private CountDownTimer countDownTimer;
private long timeLeftMillis;
    /**
     * Método ejecutado cuando se crea la actividad
     * @param savedInstanceState -> Referencia a objeto bundle que guarda el estado anterior de la actividad
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DbHelper dbHelper = new DbHelper(this);
        questionsList = dbHelper.getAllNormalQuestions();
textColorDefaultCd = textViewCountDown.getTextColors();
    }
private void startCountDown(){
        countDownTimer = new CountDownTimer(timeLeftMillis,1000) {
            @Override
            public void onTick(long millisUnitFinished) {
                timeLeftMillis = millisUnitFinished;
                        updateCountDownText();
            }

            @Override
            public void onFinish() {
timeLeftMillis = 0;
updateCountDownText();

            }
        }.start();
}

private void updateCountDownText(){
    int minutes = (int) (timeLeftMillis / 1000) / 60;
    int seconds = (int) (timeLeftMillis / 1000) % 60;

    String timeFormated = String.format(Locale.getDefault(), "%02d:%02d",minutes,seconds);
textViewCountDown.setText(timeFormated);

if(timeLeftMillis < 10000){
    textViewCountDown.setTextColor(Color.RED);
}else{
    textViewCountDown.setTextColor(textColorDefaultCd);
}

    }
    /**
     * Método para abrir el menú de ajustes
     * @param view -> Referencia a la vista
     */
    public void openSettingsMenu(View view) {
        // Obtención de objeto Intent para el cambio de actividad
        Intent int_settingsM = new Intent(this, SettingsActivity.class);
        // Inicio de la actividad
        startActivity(int_settingsM);
        // Finalización de la actividad
        finish();
    }

    /**
     * Método para comenzar la partida
     * @param view -> Referencia a la vista
     */
    public void startGame(View view) {
        // Obtención de objeto Intent para el cambio de actividad
        Intent int_game = new Intent(this, GameActivity.class);
        // Inicio de la actividad
        startActivity(int_game);
        // Finalización de la actividad
        finish();
    }

    /**
     * Método para cerrar el juego
     * @param view -> Referencia a la vista
     */
    public void endGame(View view) {
        // Función de cierre
        System.exit(0);
    }
}