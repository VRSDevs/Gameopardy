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

import com.mrwojack.quiz.R;

import java.util.List;

public class MultipleChoiceFragment extends Fragment {

    TextView question;
    List<CheckBox> options;
    Button confirmButton;

    public MultipleChoiceFragment() {
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
        return inflater.inflate(R.layout.fragment_multiple_choice, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        question = view.findViewById(R.id.txtVw_mc_q);
        options.add(view.findViewById(R.id.chkBox_mc_o1));
        options.add(view.findViewById(R.id.chkBox_mc_o2));
        options.add(view.findViewById(R.id.chkBox_mc_o3));
        options.add(view.findViewById(R.id.chkBox_mc_o4));
        options.add(view.findViewById(R.id.chkBox_mc_o5));
        options.add(view.findViewById(R.id.chkBox_mc_o6));
        confirmButton = view.findViewById(R.id.btt_mc_conf);
    }
}