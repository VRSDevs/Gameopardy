package com.mrwojack.gameopardy.fragments.questions;

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
import android.widget.ToggleButton;

import com.mrwojack.gameopardy.R;
import com.mrwojack.gameopardy.ResultsActivity;

public class Question3VFFragment extends Fragment {

    ///////////////////////// VARIABLES /////////////////////////
    // VARIABLES REFERENCIA A COMPONENTES //
    TextView txtViewPoints;     // TextView de la puntuación del jugador
    TextView txtViewQuestions;
    // OTRAS VARIABLES //
    int points = 0;     // Puntuación del jugador
    int hits = 0;
    int mistakes = 0;
    int questionNumber;

    public Question3VFFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("data2_vf", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                points = Integer.parseInt(result.getString("points"));
                hits = Integer.parseInt(result.getString("hits"));
                mistakes = Integer.parseInt(result.getString("mistakes"));
                questionNumber = Integer.parseInt(result.getString("questionNumber"));
                txtViewPoints.setText(String.valueOf(points));
                txtViewQuestions.setText(questionNumber + " / 10");
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question3_v_f, container, false);
    }

    /**
     *
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //
        final NavController NAV_CONTROLLER = Navigation.findNavController(view);

        //
        txtViewPoints = view.findViewById(R.id.txtView_points3_vf);
        txtViewQuestions = view.findViewById(R.id.txtView_questions3_vf);
        ToggleButton optionsButton = view.findViewById(R.id.togBtt_q3_vf);
        Button confirmButton = view.findViewById(R.id.btt_q3_vf);

        confirmButton.setOnClickListener(new View.OnClickListener() {

            /**
             *
             * @param view
             */
            @Override
            public void onClick(View view) {
                updatePoints(
                        view,
                        checkAnswer(view)
                );

                Intent int_results = new Intent(view.getContext(), ResultsActivity.class);
                int_results.putExtra("points", String.valueOf(points));
                int_results.putExtra("hits", String.valueOf(hits));
                int_results.putExtra("mistakes", String.valueOf(mistakes));

                startActivity(int_results);

                Activity a = FragmentManager.findFragment(view).getActivity();
                a.finish();
            }

            /**
             *
             * @param view
             */
            private boolean checkAnswer(View view) {
                if(!optionsButton.isChecked()) {
                    Toast.makeText(view.getContext(), "Incorrecto", Toast.LENGTH_SHORT).show();
                    return false;
                }

                Toast.makeText(view.getContext(), "Correcto", Toast.LENGTH_SHORT).show();
                return true;
            }

            /**
             *
             * @param view
             * @param result
             */
            private void updatePoints(View view, boolean result){
                //
                points = Integer.parseInt(txtViewPoints.getText().toString());
                if(!result) {
                    points -= 50;
                    mistakes++;
                } else {
                    points += 100;
                    hits++;
                }
            }

            /**
             *
             */
            private void createBundle(){
                //
                Bundle bundle = new Bundle();
                bundle.putString("points", String.valueOf(points));
                bundle.putString("hits", String.valueOf(hits));
                bundle.putString("mistakes", String.valueOf(mistakes));
                questionNumber += 1;
                bundle.putString("questionNumber", String.valueOf(questionNumber));
                getParentFragmentManager().setFragmentResult("data2_vf", bundle);
            }
        });
    }
}