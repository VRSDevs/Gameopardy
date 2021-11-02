package com.mrwojack.quiz.fragments.questions;

import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mrwojack.quiz.GameActivity;
import com.mrwojack.quiz.R;

import java.util.ArrayList;
import java.util.List;

public class NormalQuestionFragment extends Fragment {

    //region Variables

    /**
     * Referencia al TextView de la pregunta
     */
    TextView questionTxtVw;
    /**
     * Lista de referencias de botones de las opciones
     */
    List<Button> optionsBtt;

    /**
     * Pregunta
     */
    String question;
    /**
     * Lista de opciones
     */
    String[] options;
    /**
     * Respuesta correcta
     */
    String answer;

    //endregion

    //region Constructores

    public NormalQuestionFragment() {
        // Required empty public constructor
    }

    //endregion

    //region Métodos - Ciclo de vida

    /**
     * Método ejecutado cuando se crea el fragmento
     * @param savedInstanceState -> Referencia a objeto bundle que guarda el estado anterior de la actividad
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inicialización de variables
        options = new String[4];
        optionsBtt = new ArrayList<>();
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
        View _view = inflater.inflate(R.layout.fragment_normal_question, container, false);

        // Obtención de valores del Bundle de la actividad
        question = getArguments().getString("question");
        options[0] = getArguments().getString("option1");
        options[1] = getArguments().getString("option2");
        options[2] = getArguments().getString("option3");
        options[3] = getArguments().getString("option4");
        answer = getArguments().getString("answer");

        // Inflate the layout for this fragment
        return _view;
    }

    /**
     * Método ejecutado instantes posteriores a @onCreateView
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Obtención de referencias
        questionTxtVw = view.findViewById(R.id.txtVw_nq_q);
        optionsBtt.add(view.findViewById(R.id.btt_nq_o1));
        optionsBtt.add(view.findViewById(R.id.btt_nq_o2));
        optionsBtt.add(view.findViewById(R.id.btt_nq_o3));
        optionsBtt.add(view.findViewById(R.id.btt_nq_o4));

        initFragmentUI();

        // Por cada botón de respuesta
        for (Button btn:
                optionsBtt) {
            // Añadir un evento de escucha de clic
            btn.setOnClickListener(new View.OnClickListener() {

                /**
                 * Método ejecutado cuando se hace clic en el botón
                 * @param view -> Referencia a la vista
                 */
                @Override
                public void onClick(View view) {
                    ((GameActivity)getActivity()).updatePoints(checkAnswer(view));
                    ((GameActivity)getActivity()).updateHUD();
                    ((GameActivity)getActivity()).generateFragment();
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

                    // Si no son iguales
                    if(!optionText.equals(answer)) {
                        // Advertencia de respuesta incorrecta
                        btn.setBackgroundColor(Color.rgb(244, 67, 54));
                        return false;
                    }

                    // Advertencia de respuesta correcta
                    btn.setBackgroundColor(Color.rgb(76, 175, 80));
                    return true;
                }
            });
        }
    }

    //endregion

    //region Métodos - Inicialización

    /**
     * Método para inicializar la interfaz del fragmento
     */
    private void initFragmentUI() {
        // Pregunta
        questionTxtVw.setText(question);

        // Botones
        int i = 0;

        for (Button btn:
                optionsBtt) {
            btn.setText(options[i]);

            i++;
        }
    }

    //endregion
}