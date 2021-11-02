package com.mrwojack.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ResultsActivity extends AppCompatActivity {

    //region Variables
    //endregion

    //region Métodos - Ciclo de vida

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
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