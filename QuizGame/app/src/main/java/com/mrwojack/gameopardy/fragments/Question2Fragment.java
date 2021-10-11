package com.mrwojack.gameopardy.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.mrwojack.gameopardy.R;
import com.mrwojack.gameopardy.ResultsActivity;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Question2Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Question2Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Question2Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Question2Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Question2Fragment newInstance(String param1, String param2) {
        Question2Fragment fragment = new Question2Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController NAV_CONTROLLER = Navigation.findNavController(view);

        Button btn_answers[] = new Button[4];
        btn_answers[0] = view.findViewById(R.id.btt_q2a1);
        btn_answers[1] = view.findViewById(R.id.btt_q2a2);
        btn_answers[2] = view.findViewById(R.id.btt_q2a3);
        btn_answers[3] = view.findViewById(R.id.btt_q2a4);

        for (Button btn:
                btn_answers) {
            btn.setOnClickListener(new View.OnClickListener() {

                /**
                 *
                 * @param view
                 */
                @Override
                public void onClick(View view) {
                    checkAnswer(view);

                    Activity a = FragmentManager.findFragment(view).getActivity();

                    Intent int_results = new Intent(view.getContext(), ResultsActivity.class);
                    startActivity(int_results);
                    a.finish();
                }

                /**
                 *
                 * @param view
                 */
                private void checkAnswer(View view) {
                    String optionText = (String)btn.getText();
                    String correctAnswer = "PlayStation 2";

                    if(!optionText.equals(correctAnswer)) {
                        Toast.makeText(view.getContext(), "Incorrecto", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    Toast.makeText(view.getContext(), "Correcto", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}