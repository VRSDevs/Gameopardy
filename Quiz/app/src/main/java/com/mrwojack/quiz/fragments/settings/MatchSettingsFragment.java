package com.mrwojack.quiz.fragments.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.mrwojack.quiz.R;

public class MatchSettingsFragment extends Fragment {

    //region Variables
    /**
     * Referencia a spinner de dificultades
     */
    Spinner difficultySpinner;
    /**
     * Referencia al botón de guardado de configuración de partida
     */
    Button saveButton;
    //endregion

    //region Constructores

    public MatchSettingsFragment() {}

    //endregion

    //region Métodos - Ciclo de Vida

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
        return inflater.inflate(R.layout.fragment_match_settings, container, false);
    }

    /**
     * Método ejecutado instantes posteriores a @onCreateView
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicialización de referencias
        difficultySpinner = view.findViewById(R.id.spn_Difficulty);
        saveButton = view.findViewById(R.id.btt_Save);

        setupDifficultySpinner();

        // Asignación de evento de escucha al botón de guardado
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveMatchPreferences();
            }
        });
    }

    //endregion

    //region Métodos - Otros

    /**
     * Método para configurar el spinner de dificultad
     */
    private void setupDifficultySpinner() {
        // Variables
        String[] difficulties = {"Fácil", "Normal", "Difícil"};     // Array de valores
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(),  // Array adapter
                R.layout.spinner_item_settings,
                difficulties);

        // Asignación del adaptador
        difficultySpinner.setAdapter(adapter);

        // Obtención de la dificultad guardada
        String savedDifficulty = this.getActivity().getSharedPreferences(
                "preferencias", Context.MODE_PRIVATE).getString("difficulty", "ERROR");

        // Selección de la dificultad en función del valor almacenado
        switch (savedDifficulty){
            case "Fácil":
                difficultySpinner.setSelection(0);
                break;
            case "Normal":
                difficultySpinner.setSelection(1);
                break;
            case "Difícil":
                difficultySpinner.setSelection(2);
                break;
            default:
                Toast.makeText(this.getActivity(), "No se encontró dificultad", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    /**
     * Método para guardar las preferencias de la partida
     */
    public void saveMatchPreferences() {
        // Obtención del fichero y su editor
        SharedPreferences preferences = this.getActivity().getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        // Inserción de la dificultad
        editor.putString("difficulty", difficultySpinner.getSelectedItem().toString());
        editor.commit();
    }

    //endregion
}