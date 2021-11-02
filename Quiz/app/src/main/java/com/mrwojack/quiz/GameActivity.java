package com.mrwojack.quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mrwojack.quiz.classes.questions.Question;
import com.mrwojack.quiz.database.DbHelper;
import com.mrwojack.quiz.fragments.EmptyFragment;
import com.mrwojack.quiz.fragments.questions.MultipleChoiceFragment;
import com.mrwojack.quiz.fragments.questions.NormalQuestionFragment;
import com.mrwojack.quiz.fragments.questions.TrueFalseFragment;

import java.util.ArrayList;
import java.util.List;

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
     * Categoría de la partida
     */
    String category;

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

    /**
     * Lista de todas las preguntas
     */
    private List<Question> questionsList;
    /**
     * Lista aleatorizada y limitada a la dificultad
     */
    private List<Question> randomizedQuestionsList;

    //endregion

    //region Métodos - Ciclo de vida

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        InitGameVars();
        getQuestionsFromDB();

        Toast.makeText(this, questionsList.get(0).getQuestion(), Toast.LENGTH_SHORT).show();

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

    @Override
    protected void onStart() {
        super.onStart();

        // Llamada al primer fragmento
        generateFragment();
    }

    //endregion

    //region Métodos - Navegación

    /**
     * Método para finalizar la partida
     */
    private void finishGame() {

        // Obtención de objeto Intent para el cambio de actividad
        Intent int_Results = new Intent(this, GameActivity.class);
        // Inserción de dato en Intent para el envío a otra actividad
        int_Results.putExtra("points", points);
        int_Results.putExtra("hits", hits);
        int_Results.putExtra("mistakes", mistakes);
        int_Results.putExtra("category", category);
        int_Results.putExtra("time", time);
        int_Results.putExtra("timer", timerText.getText().toString());
        // Inicio de la actividad
        startActivity(int_Results);
        // Finalización de la actividad
        finish();
    }

    //endregion

    //region Métodos - Inicialización

    /**
     * Método para inicializar las variables de la partida
     */
    private void InitGameVars() {
        points = 0;
        hits = 0;
        mistakes = 0;
        questionNumber = 1;
        category = getIntent().getStringExtra("category");
        time = secs = mins = 0;

        // Obtención de la dificultad guardada
        String selectedDifficulty = getSharedPreferences(
                "preferencias", Context.MODE_PRIVATE).getString("difficulty", "Fácil");

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
     * Método para obtener las preguntas de la base de datos
     */
    private void getQuestionsFromDB(){
        DbHelper _dbHelper = new DbHelper(this);
        questionsList = _dbHelper.getAllQuestions();
        randomizedQuestionsList = questionsList;

         /*switch (category) {
            case "Historia de los videojuegos":
                questionsList = _dbHelper.getQuestions("historia");
                break;
            case "Empresas de videojuegos":
                questionsList = _dbHelper.getQuestions("empresa");
                break;
            case "Cultura general":
                questionsList = _dbHelper.getQuestions("curiosidades");
                break;
            case "Sagas de videojuegos":
                questionsList = _dbHelper.getQuestions("sagas");
                break;
        }



        Toast.makeText(this, questionsList.get(0).getQuestion(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, questionsList.get(1).getQuestion(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, questionsList.get(2).getQuestion(), Toast.LENGTH_SHORT).show();

        randomizedQuestionsList = new ArrayList<>();
        int[] pickedIndexes = new int[maxQuestions];
        int index;
        boolean isAssigned;
        boolean indexFound;

        for (int i = 0; i < maxQuestions; i++) {

            isAssigned = false;

            do {
                index = (int) (Math.random() * maxQuestions);
                indexFound = false;

                for (int j = 0; j < pickedIndexes.length; j++) {
                    if(pickedIndexes[j] == index) {
                        indexFound = true;
                        break;
                    }
                }

                if(!indexFound) {
                    isAssigned = true;
                }

            } while(!isAssigned);

            //Toast.makeText(this, questionsList.get(index).getQuestion(), Toast.LENGTH_SHORT).show();

            //randomizedQuestionsList.add(questionsList.get(index));
        }

         */
    }

    //endregion

    //region Métodos - Actualización

    /**
     * Método para la actualización de puntos
     * @param result -> Resultado de la comprobación de respuesta
     */
    public void updatePoints(boolean result) {
        if(!result) {
            points -= 50;
            mistakes++;
        } else {
            points += 100;
            hits++;
        }

        questionNumber++;
    }

    /**
     * Método para actualizar el HUD de la partida
     */
    public void updateHUD() {
        questionsText.setText(questionNumber + " / " + maxQuestions);
        hitsText.setText("Acertadas: " + hits);
        missText.setText("Fallidas: " + mistakes);
        pointsText.setText("" + points);
    }

    //endregion

    //region Métodos - Otros

    /**
     * Método para la generación del primer fragmento con contenido
     */
    public void generateFragment(){

        if(questionNumber == maxQuestions + 1) {
            finishGame();
        }

        // Creación Bundle
        Bundle args = new Bundle();

        switch (questionsList.get(questionNumber).getType()) {
            case "normal":
                // Inserción de datos
                args.putString("question", questionsList.get(questionNumber).getQuestion());
                args.putString("option1", questionsList.get(questionNumber).getOption1());
                args.putString("option2", questionsList.get(questionNumber).getOption2());
                args.putString("option3", questionsList.get(questionNumber).getOption3());
                args.putString("option4", questionsList.get(questionNumber).getOption4());
                args.putString("answer", questionsList.get(questionNumber).getAnswer());

                // Generación de fragmento y asignación de bundle
                NormalQuestionFragment fragmentN = new NormalQuestionFragment();
                fragmentN.setArguments(args);

                // Reemplazo de fragmento a mostrar
                getSupportFragmentManager().beginTransaction().replace(R.id.frgCont_game, fragmentN).commit();

                break;
            case "multiple":
                // Inserción de datos
                args.putString("question", questionsList.get(questionNumber).getQuestion());
                args.putString("option1", questionsList.get(questionNumber).getOption1());
                args.putString("option2", questionsList.get(questionNumber).getOption2());
                args.putString("option3", questionsList.get(questionNumber).getOption3());
                args.putString("option4", questionsList.get(questionNumber).getOption4());
                args.putString("option5", questionsList.get(questionNumber).getOption5());
                args.putString("option6", questionsList.get(questionNumber).getOption6());
                args.putString("answer", questionsList.get(questionNumber).getAnswer());

                // Generación de fragmento y asignación de bundle
                MultipleChoiceFragment fragmentM = new MultipleChoiceFragment();
                fragmentM.setArguments(args);

                // Reemplazo de fragmento a mostrar
                getSupportFragmentManager().beginTransaction().replace(R.id.frgCont_game, fragmentM).commit();

                break;
            case "binario":
                // Inserción de datos
                args.putString("question", questionsList.get(questionNumber).getQuestion());
                args.putString("answer", questionsList.get(questionNumber).getAnswer());

                // Generación de fragmento y asignación de bundle
                TrueFalseFragment fragmentB = new TrueFalseFragment();
                fragmentB.setArguments(args);

                // Reemplazo de fragmento a mostrar
                getSupportFragmentManager().beginTransaction().replace(R.id.frgCont_game, fragmentB).commit();

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