package com.mrwojack.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LeaderboardActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
    }

    //region Métodos - Navegación

    /**
     * Método para volver al menú principal
     * @param view
     */
    public void goBack(View view) {
        // Obtención de objeto Intent para el cambio de actividad
        Intent int_MainMenu = new Intent(this, MainActivity.class);
        // Inicio de la actividad
        startActivity(int_MainMenu);
        // Finalización de la actividad
        finish();
    }

    //endregion
}