package com.mrwojack.quiz.fragments.settings;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrwojack.quiz.R;


public class EmptySettingsFragment extends Fragment {

    //region Constructores

    public EmptySettingsFragment() {
        // Required empty public constructor
    }

    //endregion

    //region Métodos - Ciclo de vida

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_empty_settings, container, false);
    }

    //endregion
}