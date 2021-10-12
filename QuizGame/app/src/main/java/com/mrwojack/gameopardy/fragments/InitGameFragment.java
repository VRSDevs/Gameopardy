package com.mrwojack.gameopardy.fragments;

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

import com.mrwojack.gameopardy.R;

public class InitGameFragment extends Fragment {

    /**
     *  Constructor vacío
     */
    public InitGameFragment() {
        // Required empty public constructor
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
        return inflater.inflate(R.layout.fragment_init_game, container, false);
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
        Button btn = view.findViewById(R.id.btt_start);

        // Asignación de evento de escucha al botón de comienzo
        btn.setOnClickListener(new View.OnClickListener() {
            /**
             * Método ejecutado cuando se hace clic en el botón
             * @param view -> Referencia a la vista
             */
            @Override
            public void onClick(View view) {
                // Navegación al siguiente fragmento
                NAV_CONTROLLER.navigate(R.id.question1Fragment);
            }
        });
    }
}