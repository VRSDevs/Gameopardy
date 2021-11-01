package com.mrwojack.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    /****************** MÉTODOS DE NAVEGACIÓN *******************/

    public void showMusicSettings(View view) {
        // VARIABLES //
        // Variable de navegación entre fragmentos
        final NavController NAV_CONTROLLER = Navigation.findNavController(view);
        // Referencias a componentes de la vista
        Button btn = view.findViewById(R.id.btt_Music);

        // Asignación de evento de escucha al botón de comienzo
        btn.setOnClickListener(new View.OnClickListener() {
            /**
             * Método ejecutado cuando se hace clic en el botón
             * @param view -> Referencia a la vista
             */
            @Override
            public void onClick(View view) {
                // Navegación al siguiente fragmento
                NAV_CONTROLLER.navigate(R.id.musicSettingsFragment);
            }
        });
    }


}