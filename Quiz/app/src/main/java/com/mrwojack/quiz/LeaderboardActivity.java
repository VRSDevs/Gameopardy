package com.mrwojack.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

public class LeaderboardActivity extends AppCompatActivity {

    //region Variables

    /**
     * Referencia a spinner de dificultades
     */
    ListView ranking;

    /**
     * Número máximo de usuarios en el ranking
     */
    final int MAX_USERS_IN_RANK = 5;
    /**
     * Lista de posiciones
     */
    String positions[] = {"1.", "2.", "3.", "4.", "5."};

    /**
     * Lista de nombres de usuarios
     */
    String username[] = {"-", "-", "-", "-", "-"};

    /**
     * Lista de puntuaciones
     */
    String puntuation[] = {"-", "-", "-", "-", "-"};

    /**
     * Lista de tiempos
     */
    String timer[] = {"-", "-", "-", "-", "-"};

    //endregion

    //region Métodos - Ciclo de vida

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        // Obtención referencias
        ranking = findViewById(R.id.lstVw_ranking);

        getValuesFromRankingFile();
        setupRankingList();
    }

    //endregion

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

    //region Métodos - Inicialización

    /**
     * Método para obtener los datos del fichero de ranking
     */
    private void getValuesFromRankingFile() {
        // Obtención del fichero
        SharedPreferences rankingFile = getSharedPreferences("ranking", Context.MODE_PRIVATE);

        // Si no existe el fichero
        if(getSharedPreferences("ranking", Context.MODE_PRIVATE) == null)
            return;

        for (int i = 0; i < MAX_USERS_IN_RANK; i++) {
            // Si el slot está vacío
            if(rankingFile.getString("player" + i, "-").equals("-"))
                break;

            username[i] = rankingFile.getString("player" + i, "-");
            puntuation[i] = rankingFile.getString("puntuation" + i, "-");
            timer[i] = rankingFile.getString("timer" + i, "-");
        }
    }

    /**
     * Método para ajustar el list view
     */
    private void setupRankingList() {
        // Inicialización y relleno de array
        String array[] = {"No se encontró registro.", "", "", "", ""};
        for (int i = 0; i < MAX_USERS_IN_RANK; i++) {
            if(username[i].equals("-"))
                continue;

            array[i] = positions[i] + " ////// " + username[i] + " ////// "
                    + puntuation[i] + " ////// " + timer[i];
        }

        // Creación y asignación de array
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,  // Array adapter
                R.layout.list_view_ranking,
                array);
        ranking.setAdapter(adapter);
    }

    //endregion
}