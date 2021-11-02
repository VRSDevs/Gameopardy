package com.mrwojack.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ProfileActivity extends AppCompatActivity {

    //region Variables
    EditText username;

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

        // Inicialización de valores
        username.setText(
                getSharedPreferences("jugador", Context.MODE_PRIVATE).getString("username", "Anónimo?")
        );
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

    //region Métodos - Otros

    /**
     * Método para guardar el nombre de usuario
     * @param view
     */
    public void saveUsername(View view) {
        // Obtención del fichero y su editor
        SharedPreferences player = getSharedPreferences("jugador", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = player.edit();

        // Inserción de la dificultad
        String name = username.getText().toString();

        if(name == "") {
            editor.putString("username", "Anónimo");
        } else {
            editor.putString("username", username.getText().toString());
        }
        editor.commit();
    }

    /**
     * Método para borrar el nombre de usuario
     * @param view
     */
    public void deleteUsername(View view) {
        // Borrado de la información
        username.setText("");

        // Obtención del fichero y su editor
        SharedPreferences player = getSharedPreferences("jugador", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = player.edit();

        // Inserción de la dificultad
        editor.putString("username", "Anónimo");
        editor.commit();
    }

    //endregion
}