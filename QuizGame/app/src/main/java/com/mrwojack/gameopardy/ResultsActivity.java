package com.mrwojack.gameopardy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    ///////////////////////// VARIABLES /////////////////////////
    // VARIABLES REFERENCIA A COMPONENTES //
    TextView txtViewFinalPoints;        // TextView de la puntuación final
    TextView txtViewFinalHits;          // TextView del número total de aciertos
    TextView txtViewFinalMistakes;      // TextView del número total de fallos
    // OTRAS VARIABLES //
    int finalPoints = 0;        // Puntuación final
    int finalHits = 0;          // Número total de aciertos
    int finalMistakes = 0;      // Número total de fallos

    /**
     * Método ejecutado cuando se crea el fragmento
     * @param savedInstanceState -> Referencia a objeto bundle que guarda el estado anterior de la actividad
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // Referencias a componentes de la vista
        txtViewFinalPoints = findViewById(R.id.txtView_finalPoints);
        txtViewFinalHits = findViewById(R.id.txtView_finalHits);
        txtViewFinalMistakes = findViewById(R.id.txtView_finalMistakes);
        txtViewFinalMistakes = findViewById(R.id.txtView_finalMistakes);
        // Obtención de valores del objeto Intent
        finalPoints = Integer.parseInt(getIntent().getStringExtra("points"));
        finalHits = Integer.parseInt(getIntent().getStringExtra("hits"));
        finalMistakes = Integer.parseInt(getIntent().getStringExtra("mistakes"));
        // Asignación de valores a componentes de la vista
        txtViewFinalPoints.setText(String.valueOf(finalPoints));
        txtViewFinalHits.setText(String.valueOf(finalHits));
        txtViewFinalMistakes.setText(String.valueOf(finalMistakes));
    }

    /**
     * Método para volver a jugar una partida
     * @param view -> Referencia a la vista
     */
    public void playAgain(View view) {
        // Obtención de objeto Intent para el cambio de actividad
        Intent int_game = new Intent(this, GameActivity.class);
        // Inicio de la actividad
        startActivity(int_game);
        // Finalización de la actividad
        finish();
    }

    /**
     * Método para volver al menú principal
     * @param view -> Referencia a la vista
     */
    public void goHome(View view) {
        // Obtención de objeto Intent para el cambio de actividad
        Intent int_home = new Intent(this, MainActivity.class);
        // Inicio de la actividad
        startActivity(int_home);
        // Finalización de la actividad
        finish();
    }
}