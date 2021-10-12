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

import com.mrwojack.gameopardy.R;
import com.mrwojack.gameopardy.ResultsActivity;

public class Question3Fragment extends Fragment {

    ///////////////////////// VARIABLES /////////////////////////
    // VARIABLES REFERENCIA A COMPONENTES //
    TextView txtViewPoints;     // TextView de la puntuación del jugador
    TextView txtViewQuestions;
    // OTRAS VARIABLES //
    int points;     // Puntuación del jugador
    int hits = 0;
    int mistakes = 0;
    int questionNumber;

    public Question3Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getParentFragmentManager().setFragmentResultListener("data2", this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                points = Integer.parseInt(result.getString("points"));
                hits = Integer.parseInt(result.getString("hits"));
                mistakes = Integer.parseInt(result.getString("mistakes"));
                questionNumber = Integer.parseInt(result.getString("questionNumber"));
                txtViewPoints.setText(String.valueOf(points));
                txtViewQuestions.setText(questionNumber + " / 9");
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final NavController NAV_CONTROLLER = Navigation.findNavController(view);

        //
        txtViewPoints = view.findViewById(R.id.txtView_points3);
        txtViewQuestions = view.findViewById(R.id.txtView_questions3);
        Button btn_answers[] = new Button[4];
        btn_answers[0] = view.findViewById(R.id.btt_q3a1);
        btn_answers[1] = view.findViewById(R.id.btt_q3a2);
        btn_answers[2] = view.findViewById(R.id.btt_q3a3);
        btn_answers[3] = view.findViewById(R.id.btt_q3a4);

        for (Button btn:
                btn_answers) {
            btn.setOnClickListener(new View.OnClickListener() {

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

                    createBundle();
                    NAV_CONTROLLER.navigate(R.id.question1VFFragment);
                }

                /**
                 *
                 * @param view
                 */
                private boolean checkAnswer(View view) {
                    String optionText = btn.getText().toString();
                    String correctAnswer = "No Mans Sky";

                    if(!optionText.equals(correctAnswer)) {
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
                    getParentFragmentManager().setFragmentResult("data3", bundle);
                }
            });
        }
    }
}