package com.mrwojack.quiz.fragments.questions;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mrwojack.quiz.R;

import java.util.List;

public class NormalQuestionFragment extends Fragment {

    TextView question;
    List<Button> options;
    String answer;

    public NormalQuestionFragment() {
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
        return inflater.inflate(R.layout.fragment_normal_question, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        question = view.findViewById(R.id.txtVw_nq_q);
        options.add(view.findViewById(R.id.btt_nq_o1));
        options.add(view.findViewById(R.id.btt_nq_o2));
        options.add(view.findViewById(R.id.btt_nq_o3));
        options.add(view.findViewById(R.id.btt_nq_o4));
    }
}