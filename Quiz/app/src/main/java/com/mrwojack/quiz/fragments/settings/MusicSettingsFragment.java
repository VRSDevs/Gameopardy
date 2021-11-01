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
import android.widget.SeekBar;

import com.mrwojack.quiz.R;

public class MusicSettingsFragment extends Fragment {

    SeekBar musicBar;
    SeekBar sfxBar;

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

        musicBar.setProgress(
                getActivity().getSharedPreferences("preferenceias", Context.MODE_PRIVATE).getInt("musicVol", 0)
        );
        sfxBar.setProgress(
                getActivity().getSharedPreferences("preferenceias", Context.MODE_PRIVATE).getInt("sfxVol", 0)
        );
    }
}