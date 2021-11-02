package com.mrwojack.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class GameCategoryActivity extends AppCompatActivity {

    //region Variables

    /**
     * Referencia al botón de jugar
     */
    Button playButton;

    /**
     * Categoría seleccionada
     */
    String category;

    //endregion

    //region Métodos - Ciclo de vida

    /**
     * Método ejecutado cuando se crea la actividad
     * @param savedInstanceState -> Referencia a objeto bundle que guarda el estado anterior de la actividad
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_category);

        // Obtención de referencias
        playButton = findViewById(R.id.btt_PlayGame);

        // Desactivación botón de jugar
        playButton.setClickable(false);
        playButton.setBackgroundColor(Color.GRAY);
    }

    //endregion

    //region Métodos - Navegación

    /**
     * Método para acceder a la partida
     * @param view
     */
    public void playGame(View view) {
        // Obtención de objeto Intent para el cambio de actividad
        Intent int_Game = new Intent(this, GameActivity.class);
        // Inserción de dato en Intent para el envío a otra actividad
        int_Game.putExtra("category", category);
        // Inicio de la actividad
        startActivity(int_Game);
        // Finalización de la actividad
        finish();
    }

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

    //region Métodos - Otros

    /**
     * Método para activar el botón de jugar y asignación de categoría
     * @param view
     */
    public void enablePlayButton(View view){
        playButton.setClickable(true);
        playButton.setBackgroundColor(Color.rgb(98,0,238));

        RadioButton buttonPressed = view.findViewById(view.getId());

        category = buttonPressed.getText().toString();
        Toast.makeText(this, category, Toast.LENGTH_SHORT).show();
    }

    //endregion
}