package com.mrwojack.gameopardy.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mrwojack.gameopardy.R;
import com.mrwojack.gameopardy.ResultsActivity;

public class Question2Fragment extends Fragment {

    ///////////////////////// VARIABLES /////////////////////////
    // VARIABLES REFERENCIA A COMPONENTES //
    TextView txtViewPoints;     // TextView de la puntuación del jugador
    // OTRAS VARIABLES //
    int points = 0;     // Puntuación del jugador

    public Question2Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("data", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                points = Integer.parseInt(result.getString("points"));
                txtViewPoints.setText(String.valueOf(points));
            }
        });
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

        //
        txtViewPoints = view.findViewById(R.id.txtView_points2);
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