package com.mrwojack.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class GameActivity extends AppCompatActivity {

    //region Variables

    /**
     * Referencia a la pregunta actual (texto)
     */
    TextView questionsText;
    /**
     * Referencia a las respuestas acertadas (texto)
     */
    TextView hitsText;
    /**
     * Referencia a las respuestas fallidas (texto)
     */
    TextView missText;
    /**
     * Referencia a los puntos del jugador (texto)
     */
    TextView pointsText;
    /**
     * Referencia al cronómetro (texto)
     */
    TextView timerText;

    /**
     * Puntos del jugador
     */
    int points;
    /**
     * Aciertos del jugador
     */
    int hits;
    /**
     * Fallos del jugador
     */
    int mistakes;
    /**
     * Número actual de pregunta
     */
    int questionNumber;
    /**
     * Número máximo de preguntas
     */
    int maxQuestions;
    /**
     * Tiempo de la partida
     */
    int time;

    //endregion

    //region Métodos - Ciclo de vida

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        InitGameVars();

        // Referencias a objetos
        questionsText = findViewById(R.id.txtVw_questions);
        hitsText = findViewById(R.id.txtVw_hits);
        missText = findViewById(R.id.txtVw_miss);
        pointsText = findViewById(R.id.txtVw_points);
        timerText = findViewById(R.id.txtVw_timer);

        // Inicialización
        questionsText.setText(questionNumber + " / " + maxQuestions);
        hitsText.setText("Acertadas: " + hits);
        missText.setText("Fallidas: " + mistakes);
        pointsText.setText(points);
    }

    //endregion

    //region Métodos - Otros

    /**
     * Método para inicializar las variables de la partida
     */
    private void InitGameVars() {
        points = 0;
        hits = 0;
        mistakes = 0;
        questionNumber = 1;
        time = 0;

        // Obtención de la dificultad guardada
        String selectedDifficulty = getSharedPreferences(
                "preferencias", Context.MODE_PRIVATE).getString("difficulty", "ERROR");

        // Selección de la dificultad en función del valor almacenado
        switch (selectedDifficulty){
            case "Fácil":
                maxQuestions = 5;
                break;
            case "Normal":
                maxQuestions = 10;
                break;
            case "Difícil":
                maxQuestions = 15;
                break;
            default:
                Toast.makeText(this, "No se encontró dificultad", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    //endregion
}