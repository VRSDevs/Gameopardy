package com.mrwojack.gameopardy.fragments.questions;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mrwojack.gameopardy.R;

import java.util.List;

public class Question1Fragment extends Fragment {

    ///////////////////////// VARIABLES /////////////////////////
    // VARIABLES REFERENCIA A COMPONENTES //
    TextView txtViewPoints;     // TextView de la puntuación del jugador
    TextView txtViewQuestions;  // TextView del número de preguntas
    // OTRAS VARIABLES //
    int points = 0;     // Puntuación del jugador
    int hits = 0;       // Número de aciertos
    int mistakes = 0;   // Número de errores
    int questionNumber = 1;     // Número de pregunta actual
    private List<Questions> questionsList;
    /**
     *  Constructor vacío
     */
    public Question1Fragment() {
    }

    /**
     * Método ejecutado cuando se crea el fragmento
     * @param savedInstanceState -> Referencia a objeto bundle que guarda el estado anterior de la actividad
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        return inflater.inflate(R.layout.fragment_question1, container, false);
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
        txtViewPoints = view.findViewById(R.id.txtView_points);
        txtViewQuestions = view.findViewById(R.id.txtView_questions);
        Button btn_answers[] = new Button[4];
        btn_answers[0] = view.findViewById(R.id.btt_q1a1);
        btn_answers[1] = view.findViewById(R.id.btt_q1a2);
        btn_answers[2] = view.findViewById(R.id.btt_q1a3);
        btn_answers[3] = view.findViewById(R.id.btt_q1a4);

        // Asignación de texto a componente del número de preguntas
        txtViewQuestions.setText(questionNumber + " / 9");

        // Por cada botón de respuesta
        for (Button btn:
            btn_answers) {
            // Añadir un evento de escucha de clic
            btn.setOnClickListener(new View.OnClickListener() {

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
                    NAV_CONTROLLER.navigate(R.id.question2Fragment);
                }

                /**
                 * Método de comprobación de respuesta introducida
                 * @param view -> Referencia a la vista
                 */
                private boolean checkAnswer(View view) {
                    // VARIABLES //
                    // Respuesta del jugador
                    String optionText = btn.getText().toString();
                    // Respuesta correcta
                    String correctAnswer = "FIFA INTERNATIONAL SOCCER (FIFA 94)";

                    // Si no son iguales
                    if(!optionText.equals(correctAnswer)) {
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
                    getParentFragmentManager().setFragmentResult("data", bundle);
                }
            });
        }
    }
}