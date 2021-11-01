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
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import com.mrwojack.quiz.R;

public class MusicSettingsFragment extends Fragment {

    SeekBar musicBar;
    SeekBar sfxBar;
    Button saveButton;

    public MusicSettingsFragment() {
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
        return inflater.inflate(R.layout.fragment_music_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        musicBar = view.findViewById(R.id.sb_Music);
        sfxBar = view.findViewById(R.id.sb_Effects);
        saveButton = view.findViewById(R.id.btt_SaveMusic);

        musicBar.setProgress(
                this.getActivity().getSharedPreferences("preferencias", Context.MODE_PRIVATE).getInt("musicVol", 0)
        );
        sfxBar.setProgress(
                this.getActivity().getSharedPreferences("preferencias", Context.MODE_PRIVATE).getInt("sfxVol", 0)
        );

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveMusicPreferences();
            }
        });
    }

    private void saveMusicPreferences() {
        SharedPreferences preferences = this.getActivity().getSharedPreferences("preferencias", Context.MODE_PRIVATE);

        Toast.makeText(this.getActivity(), "Música: " + musicBar.getProgress(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this.getActivity(), "Sonidos: " + sfxBar.getProgress(), Toast.LENGTH_SHORT).show();

        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("musicVol", musicBar.getProgress());
        editor.putInt("sfxVol", sfxBar.getProgress());

        editor.commit();
    }
}