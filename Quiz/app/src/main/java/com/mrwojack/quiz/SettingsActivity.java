package com.mrwojack.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



import com.mrwojack.quiz.fragments.settings.MatchSettingsFragment;
import com.mrwojack.quiz.fragments.settings.MusicSettingsFragment;

public class SettingsActivity extends AppCompatActivity {

    //region Variables
    //endregion

    //region Métodos - Ciclo de vida

    /**
     * Método ejecutado cuando se crea la actividad
     * @param savedInstanceState -> Referencia a objeto bundle que guarda el estado anterior de la actividad
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    //endregion

    //region Métodos - Navegación

    /**
     * Método para volver al menú principal
     * @param view
     */
    public void goToMainMenu(View view) {
        // Obtención de objeto Intent para el cambio de actividad
        Intent int_MainMenu = new Intent(this, MainActivity.class);
        // Inicio de la actividad
        startActivity(int_MainMenu);
        // Finalización de la actividad
        finish();
    }

    /**
     * Método para mostrar los ajustes de la música
     * @param view
     */
    public void showMusicSettings(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragCV_Settings, new MusicSettingsFragment()).commit();
    }

    /**
     * Método para mostrar ajustes de la partida
     * @param view
     */
    public void showMatchSettings(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragCV_Settings, new MatchSettingsFragment()).commit();
    }

    //endregion
}