package com.mrwojack.quiz.fragments.questions;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.mrwojack.quiz.GameActivity;
import com.mrwojack.quiz.R;

import java.util.List;

public class MultipleChoiceFragment extends Fragment {

    //region Variables

    /**
     * Referencia al TextView de la pregunta
     */
    TextView questionTxtVw;
    /**
     * Lista de referencias de botones de las opciones
     */
    List<CheckBox> optionsBtt;
    /**
     * Referencia al botón de confirmar
     */
    Button confirmButton;

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

    public MultipleChoiceFragment() {
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
        options = new String[6];
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
        View _view = inflater.inflate(R.layout.fragment_multiple_choice, container, false);

        // Obtención de valores del Bundle de la actividad
        question = getArguments().getString("question");
        options[0] = getArguments().getString("option1");
        options[1] = getArguments().getString("option2");
        options[2] = getArguments().getString("option3");
        options[3] = getArguments().getString("option4");
        options[4] = getArguments().getString("option5");
        options[5] = getArguments().getString("option6");
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
        questionTxtVw = view.findViewById(R.id.txtVw_mc_q);
        optionsBtt.add(view.findViewById(R.id.chkBox_mc_o1));
        optionsBtt.add(view.findViewById(R.id.chkBox_mc_o2));
        optionsBtt.add(view.findViewById(R.id.chkBox_mc_o3));
        optionsBtt.add(view.findViewById(R.id.chkBox_mc_o4));
        optionsBtt.add(view.findViewById(R.id.chkBox_mc_o5));
        optionsBtt.add(view.findViewById(R.id.chkBox_mc_o6));
        confirmButton = view.findViewById(R.id.btt_mc_conf);

        // Asignación de evento de escucha al botón de confirmación
        confirmButton.setOnClickListener(new View.OnClickListener() {

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
                // Creación y relleno de la respuesta del jugador
                String userAnswer = "";

                for (CheckBox ckbox:
                        optionsBtt) {
                    // Si no está pulsado
                    if(!ckbox.isChecked())
                        // Siguiente respuesta marcada
                        continue;

                    userAnswer += ckbox.getText().toString() + ",";
                }

                // Si no son iguales
                if(!userAnswer.equals(answer)) {
                    // Advertencia de respuesta incorrecta
                    Toast.makeText(view.getContext(), "Incorrecto", Toast.LENGTH_SHORT).show();
                    return false;
                }

                // Advertencia de respuesta correcta
                Toast.makeText(view.getContext(), "Correcto", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    //endregion
}