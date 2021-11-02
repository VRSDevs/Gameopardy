package com.mrwojack.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    //region Variables

    /**
     * Referencia a texto de la puntuación
     */
    TextView pointsTxt;
    /**
     * Referencia a texto de los aciertos
     */
    TextView hitsTxt;
    /**
     * Referencia a texto de los fallos
     */
    TextView mistakesTxt;
    /**
     * Referencia a texto del cronómetro
     */
    TextView timerTxt;

    /**
     * Número máximo de usuarios en el ranking
     */
    final int MAX_USERS_IN_RANK = 5;

    /**
     * Puntos finales del jugador
     */
    int points;
    /**
     * Aciertos finales del jugador
     */
    int hits;
    /**
     * Fallos finales del jugador
     */
    int mistakes;
    /**
     * Categoría de la partida
     */
    String category;
    /**
     * Tiempo final empleado (para aplicar reducción)
     */
    int time;
    /**
     * Tiempo empleado (texto)
     */
    String timer;

    //endregion

    //region Métodos - Ciclo de vida

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        initVariables();
        setTexts();
    }

    //endregion

    //region Métodos - Inicialización

    /**
     * Método para inicializar las variables
     */
    private void initVariables() {
        // Inicialización de variables
        points = Integer.parseInt(getIntent().getStringExtra("points"));
        hits = Integer.parseInt(getIntent().getStringExtra("hits"));
        mistakes = Integer.parseInt(getIntent().getStringExtra("mistakes"));
        category = getIntent().getStringExtra("category");
        time = Integer.parseInt(getIntent().getStringExtra("time"));
        timer = getIntent().getStringExtra("timer");

        // Obtención de referencias
        pointsTxt = findViewById(R.id.txtVw_finalPoints);
        hitsTxt = findViewById(R.id.txtVw_finalHits);
        mistakesTxt = findViewById(R.id.txtVw_finalMiss);
        timerTxt = findViewById(R.id.txtVw_finalTime);
    }

    /**
     * Método para ajustar los textos de la pantalla de resultados
     */
    private void setTexts() {
        // Actualización de puntuación
        points -= time;

        // Asignación texto
        pointsTxt.setText(String.valueOf(points));
        hitsTxt.setText(String.valueOf(hits));
        mistakesTxt.setText(String.valueOf(mistakes));
        timerTxt.setText(timer);
    }

    //endregion

    //region Métodos - Navegación

    /**
     * Método para volver a jugar
     * @param view
     */
    public void playAgain(View view) {
        savePlayerStats();

        // Obtención de objeto Intent para el cambio de actividad
        Intent int_playAgain = new Intent(this, GameActivity.class);
        // Inicio de la actividad
        startActivity(int_playAgain);
        // Finalización de la actividad
        finish();
    }

    /**
     * Método para ir al menú principal
     * @param view
     */
    public void goMainMenu(View view) {
        savePlayerStats();

        // Obtención de objeto Intent para el cambio de actividad
        Intent int_mainMenu = new Intent(this, MainActivity.class);
        // Inicio de la actividad
        startActivity(int_mainMenu);
        // Finalización de la actividad
        finish();
    }

    //endregion

    //region Métodos - Otros

    /**
     * Método para guardar las estadísticas
     */
    private void savePlayerStats() {
        // Obtención de fichero y editor
        SharedPreferences rankingFile = getSharedPreferences("ranking", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = rankingFile.edit();

        // Array de valores
        int positions [] = {1,2,3,4,5};
        String puntuations[] = {"", "", "", "", ""};

        
        // Comprobación de huecos libres
        for(int i = 0; i < MAX_USERS_IN_RANK; i++) {
            if(rankingFile.getString("player" + i, "-").equals("-")) {
                editor.putString("player" + i, getSharedPreferences("jugador", Context.MODE_PRIVATE).getString("username", "Anónimo"));
                editor.putString("puntuation" + i, String.valueOf(points));
                editor.putString("timer" + i, timer);
                editor.commit();
                break;
            } else {
                puntuations[i] = rankingFile.getString("puntuation" + i, "0");
            }
        }

        // Comprobación de puntuación
        for(int i = 0; i < MAX_USERS_IN_RANK; i++) {
            if(points >= Integer.parseInt(rankingFile.getString("puntuation" + i,"0"))) {
                editor.putString("player" + i, getSharedPreferences("jugador", Context.MODE_PRIVATE).getString("username", "Anónimo"));
                editor.putString("puntuation" + i, String.valueOf(points));
                editor.putString("timer" + i, timer);
                editor.commit();
                break;
            }
        }

    }

    //endregion
}