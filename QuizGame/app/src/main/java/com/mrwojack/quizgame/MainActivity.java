package com.mrwojack.quizgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // Eventos de ciclo de vida de la aplicación //
    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Eventos de cambio de actividad //
    /**
     *
     * @param view
     */
    public void openSettingsMenu(View view) {
        // Creación de objeto intent
        Intent int_settingsM = new Intent(this, SettingsActivity.class);

        startActivity(int_settingsM);
    }
}