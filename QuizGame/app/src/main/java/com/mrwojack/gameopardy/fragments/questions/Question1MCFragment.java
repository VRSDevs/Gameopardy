package com.mrwojack.gameopardy.fragments.questions;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.mrwojack.gameopardy.R;
import com.mrwojack.gameopardy.ResultsActivity;

public class Question1MCFragment extends Fragment {

    ///////////////////////// VARIABLES /////////////////////////
    // VARIABLES REFERENCIA A COMPONENTES //
    TextView txtViewPoints;     // TextView de la puntuación del jugador
    TextView txtViewQuestions;  // TextView del número de preguntas
    // OTRAS VARIABLES //
    int points = 0;     // Puntuación del jugador
    int hits = 0;       // Número de aciertos
    int mistakes = 0;   // Número de errores
    int questionNumber = 1;     // Número de pregunta actual

    /**
     *  Constructor vacío
     */
    public Question1MCFragment() {
        // Required empty public constructor
    }

    /**
     * Método ejecutado cuando se crea el fragmento
     * @param savedInstanceState -> Referencia a objeto bundle que guarda el estado anterior de la actividad
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Asignación de resultado de fragmento a una clave determinada (la establecida en el fragmento anterior)
        getParentFragmentManager().setFragmentResultListener("data3_vf", this, new FragmentResultListener() {
            /**
             * Método para administrar los resultados pasados entre fragmentos
             * @param requestKey -> Clave de petición
             * @param result -> Bundle resultado de la petición
             */
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                // Asignación de valores
                points = Integer.parseInt(result.getString("points"));
                hits = Integer.parseInt(result.getString("hits"));
                mistakes = Integer.parseInt(result.getString("mistakes"));
                questionNumber = Integer.parseInt(result.getString("questionNumber"));
                // Actualización de la UI dados los valores
                txtViewPoints.setText(String.valueOf(points));
                txtViewQuestions.setText(questionNumber + " / 9");
            }
        });

    }

    /**
     * Método ejecutado y que devuelve la vista creada asignada al fragmento
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question1_m_c, container, false);
    }

    /**
     * Método ejecutado instantes posteriores a @onCreateView
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // VARIABLES //
        // Variable de navegación entre fragmentos
        final NavController NAV_CONTROLLER = Navigation.findNavController(view);
        // Referencias a componentes de la vista
        txtViewPoints = view.findViewById(R.id.txtView_points1_mc);
        txtViewQuestions = view.findViewById(R.id.txtView_questions1_mc);
        CheckBox btn_answers[] = new CheckBox[6];
        btn_answers[0] = view.findViewById(R.id.ckbx_q1a1);
        btn_answers[1] = view.findViewById(R.id.ckbx_q1a2);
        btn_answers[2] = view.findViewById(R.id.ckbx_q1a3);
        btn_answers[3] = view.findViewById(R.id.ckbx_q1a4);
        btn_answers[4] = view.findViewById(R.id.ckbx_q1a5);
        btn_answers[5] = view.findViewById(R.id.ckbx_q1a6);
        Button confirmButton = view.findViewById(R.id.btt_answer_q1_mc);

        // Asignación de evento de escucha al botón de confirmación
        confirmButton.setOnClickListener(new View.OnClickListener() {

            /**
             * Método ejecutado cuando se hace clic en el botón
             * @param view -> Referencia a la vista
             */
            @Override
            public void onClick(View view) {
                updatePoints(
                        view,
                        checkAnswer(view)
                );
                createBundle();
                // Navegación al siguiente fragmento
                NAV_CONTROLLER.navigate(R.id.question2MCFragment);
            }

            /**
             * Método de comprobación de respuesta introducida
             * @param view -> Referencia a la vista
             */
            private boolean checkAnswer(View view) {
                // VARIABLES //
                // Número de respuestas correctas
                int correctAnswers = 0;
                // Respuestas correctas
                String[] answers = {
                        "Inazuma Eleven",
                        "Ni No Kuni",
                        "Profesor Layton"
                };

                // Por cada checkbox de la vista
                for (CheckBox ckbox:
                     btn_answers) {
                    // Si no está pulsado
                    if(!ckbox.isChecked())
                        // Siguiente respuesta marcada
                        continue;

                    // Por cada respuesta de la solución
                    for (String answer:
                         answers) {
                        // Si coinciden las respuestas
                        if(answer.equals(ckbox.getText().toString())){
                            // Suma de variable de control de respuestas correctas
                            correctAnswers += 1;
                        }
                    }
                }

                // Si no es el número de respuestas correctas
                if(correctAnswers != answers.length) {
                    // Advertencia de respuesta incorrecta
                    Toast.makeText(view.getContext(), "Incorrecto", Toast.LENGTH_SHORT).show();
                    return false;
                }

                // Advertencia de respuesta correcta
                Toast.makeText(view.getContext(), "Correcto", Toast.LENGTH_SHORT).show();
                return true;
            }

            /**
             * Método para la actualización de puntos
             * @param view -> Referencia a la vista
             * @param result -> Resultado de la comprobación de respuesta
             */
            private void updatePoints(View view, boolean result){
                // Obtención de los puntos mostrados en la UI
                points = Integer.parseInt(txtViewPoints.getText().toString());

                // Si falló
                if(!result) {
                    // Resta de puntos
                    points -= 50;
                    // Suma de respuestas incorrectas
                    mistakes++;
                } else {
                    // Suma de puntos
                    points += 100;
                    // Suma de respuestas de correctas
                    hits++;
                }
            }

            /**
             * Método para la generación de un bundle
             */
            private void createBundle(){
                // VARIABLES //
                // Bundle de comunicación
                Bundle bundle = new Bundle();
                // Inserción de datos en el bundle
                bundle.putString("points", String.valueOf(points));
                bundle.putString("hits", String.valueOf(hits));
                bundle.putString("mistakes", String.valueOf(mistakes));
                questionNumber += 1;
                bundle.putString("questionNumber", String.valueOf(questionNumber));
                // Envío del bundle al FragmentManager
                getParentFragmentManager().setFragmentResult("data_mc", bundle);
            }
        });
    }
}