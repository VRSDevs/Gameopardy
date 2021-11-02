package com.mrwojack.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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
        // Obtención de objeto Intent para el cambio de actividad
        Intent int_mainMenu = new Intent(this, MainActivity.class);
        // Inicio de la actividad
        startActivity(int_mainMenu);
        // Finalización de la actividad
        finish();
    }

    //endregion
}