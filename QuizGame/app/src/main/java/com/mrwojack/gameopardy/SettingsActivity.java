package com.mrwojack.gameopardy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SettingsActivity extends AppCompatActivity {

    // Eventos de ciclo de vida de la aplicación //
    /**
     * 
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    // Eventos de cambio de actividad //
    /**
     *
     * @param view
     */
    public void openMainMenu(View view) {
        // Creación de objeto intent
        Intent int_mainM = new Intent(this, MainActivity.class);

        startActivity(int_mainM);
    }
}