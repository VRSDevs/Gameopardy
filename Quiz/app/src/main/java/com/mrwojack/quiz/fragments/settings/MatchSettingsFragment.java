package com.mrwojack.quiz.fragments.settings;

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

    Spinner difficultySpinner;
    Button saveButton;

    public MatchSettingsFragment() {
        // Required empty public constructor
    }

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
                Toast.makeText(getContext(), "Guardado", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setupDifficultySpinner() {
        String[] difficulties = {"Fácil", "Normal", "Difícil"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(),
                R.layout.spinner_item_settings,
                difficulties);

        difficultySpinner.setAdapter(adapter);
    }
}