package com.mrwojack.quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
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
     * Referencia al botón de atrás
     */
    Button backButton;

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
     * Tiempo total (en segundos) de la partida
     */
    int time;
    /**
     * Tiempo en segundos
     */
    int secs;
    /**
     * Tiempo en minutos
     */
    int mins;
    /**
     * Hilo para la ejecución del cronómetro
     */
    Thread timerThr;
    /**
     * Manejador para el hilo
     */
    Handler timerHand = new Handler();

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
        backButton = findViewById(R.id.btt_exitMatch);

        // Inicialización de cadenas
        questionsText.setText(questionNumber + " / " + maxQuestions);
        hitsText.setText("Acertadas: " + hits);
        missText.setText("Fallidas: " + mistakes);
        pointsText.setText("" + points);
        timerText.setText("00 : 00");

        // Inserción de escucha de eventos
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                exit();
            }
        });

        // Creación del hilo para el cronómetro (ejecución concurrente)
        timerThr = new Thread(new Runnable() {
            @Override
            public void run() {

                while(true){
                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    // Suma de segundos
                    secs++;
                    time++;

                    if(secs == 60) {
                        mins++;
                        secs = 0;
                    }

                    // Manejador para la obtención del cronómetro en texto
                    timerHand.post( () -> {
                        String m, s = "";

                        if(secs < 10) {
                            s = "0" + secs;
                        } else {
                            s = "" + secs;
                        }

                        if(mins < 10) {
                            m = "0" + mins;
                        } else {
                            m = "" + mins;
                        }

                        timerText.setText(m + " : " + s);
                    });
                }
            }
        });
        
        // Comienzo de la ejecución del hilo
        timerThr.start();
    }

    //endregion

    //region Métodos - Navegación

    /**
     * Método para llamar a la advertencia de cierre de partida
     */
    public void exitGame() {
        exit();
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
        time = secs = mins = 0;

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

    /**
     * Método para lanzar una alerta antes de cerrar la partida
     */
    private void exit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("¿Seguro que desea salir de la partida?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Obtención de objeto Intent para el cambio de actividad
                        Intent intClose = new Intent(builder.getContext(), MainActivity.class);
                        // Inicio de la actividad
                        startActivity(intClose);
                        // Finalización de la actividad
                        finish();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        builder.show();
    }

    //endregion
}