package com.mrwojack.gameopardy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    /**
     * Método ejecutado cuando se crea la actividad
     * @param savedInstanceState -> Referencia a objeto bundle que guarda el estado anterior de la actividad
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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