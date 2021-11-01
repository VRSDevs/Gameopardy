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

    ///////////////////////// VARIABLES /////////////////////////
    /**
     * Referencia a spinner de dificultades
     */
    Spinner difficultySpinner;
    /**
     * Referencia al botón de guardado de configuración de partida
     */
    Button saveButton;

    ///////////////////////// COSNTRUCTORES /////////////////////////

    public MatchSettingsFragment() {}

    ///////////////////////// MÉTODOS DE CICLO DE VIDA /////////////////////////

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_match_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        difficultySpinner = view.findViewById(R.id.spn_Difficulty);
        saveButton = view.findViewById(R.id.btt_Save);

        setupDifficultySpinner();

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveMatchPreferences();
            }
        });
    }

    ///////////////////////// OTROS MÉTODOS /////////////////////////

    private void setupDifficultySpinner() {
        String[] difficulties = {"Fácil", "Normal", "Difícil"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(),
                R.layout.spinner_item_settings,
                difficulties);

        difficultySpinner.setAdapter(adapter);

        String savedDifficulty = this.getActivity().getSharedPreferences(
                "preferencias", Context.MODE_PRIVATE).getString("difficulty", "ERROR");

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

    public void saveMatchPreferences() {
        SharedPreferences preferences = this.getActivity().getSharedPreferences("preferencias", Context.MODE_PRIVATE);

        Toast.makeText(this.getActivity(), "Dificultad: " + difficultySpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();

        SharedPreferences.Editor editor = preferences.edit();

        editor.putString("difficulty", difficultySpinner.getSelectedItem().toString());

        editor.commit();
    }
}