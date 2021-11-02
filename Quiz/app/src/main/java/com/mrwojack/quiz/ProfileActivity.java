package com.mrwojack.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    //region Variables
    EditText username;
    Button saveButton;
    Button deleteButton;

    //endregion

    //region Métodos - Ciclo de vida

    /**
     * Método ejecutado cuando se crea la actividad
     * @param savedInstanceState -> Referencia a objeto bundle que guarda el estado anterior de la actividad
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Búsqueda de referencias
        username = findViewById(R.id.edtTxt_name);
        saveButton = findViewById(R.id.btt_save2);
        deleteButton = findViewById(R.id.btt_del);
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

    //endregion
}