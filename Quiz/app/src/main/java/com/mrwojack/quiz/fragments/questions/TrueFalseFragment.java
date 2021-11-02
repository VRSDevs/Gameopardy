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
import android.widget.ToggleButton;

import com.mrwojack.quiz.GameActivity;
import com.mrwojack.quiz.R;

import java.util.List;

public class TrueFalseFragment extends Fragment {

    //region Variables

    /**
     * Referencia al TextView de la pregunta
     */
    TextView questionTxtVw;
    /**
     * Lista de referencias de botones de las opciones
     */
    ToggleButton optionBtt;
    /**
     * Referencia al botón de confirmar
     */
    Button confirmButton;

    /**
     * Pregunta
     */
    String question;
    /**
     * Respuesta correcta
     */
    String answer;

    //endregion

    //region Constructores

    public TrueFalseFragment() {
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
        View _view = inflater.inflate(R.layout.fragment_true_false, container, false);

        // Obtención de valores del Bundle de la actividad
        question = getArguments().getString("question");
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

        // Obtención de referencias a los componentes
        questionTxtVw = view.findViewById(R.id.txtVw_tf_q);
        optionBtt = view.findViewById(R.id.togBtt_tf);
        confirmButton = view.findViewById(R.id.btt_tf_conf);

        initFragmentUI();

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
                // Si está pulsado el botón (verdadero)
                if(optionBtt.isChecked()) {
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

    //region Métodos - Inicialización

    /**
     * Método para inicializar la interfaz del fragmento
     */
    private void initFragmentUI() {
        // Pregunta
        questionTxtVw.setText(question);
    }

    //endregion
}