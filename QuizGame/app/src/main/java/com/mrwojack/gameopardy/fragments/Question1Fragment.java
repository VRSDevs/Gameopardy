package com.mrwojack.gameopardy.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.mrwojack.gameopardy.R;

public class Question1Fragment extends Fragment {

    ///////////////////////// VARIABLES /////////////////////////
    // VARIABLES REFERENCIA A COMPONENTES //
    TextView txtViewPoints;     // TextView de la puntuación del jugador
    // OTRAS VARIABLES //
    int points = 0;     // Puntuación del jugador

    /**
     *  Constructor vacío
     */
    public Question1Fragment() {
    }

    /**
     * Método ejecutado cuando se crea el fragmento
     * @param savedInstanceState -> Referencia a objeto bundle que guarda el estado anterior de la actividad
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question1, container, false);
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
        txtViewPoints = view.findViewById(R.id.txtView_points);
        Button btn_answers[] = new Button[4];
        btn_answers[0] = view.findViewById(R.id.btt_q1a1);
        btn_answers[1] = view.findViewById(R.id.btt_q1a2);
        btn_answers[2] = view.findViewById(R.id.btt_q1a3);
        btn_answers[3] = view.findViewById(R.id.btt_q1a4);

        //
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

                    NAV_CONTROLLER.navigate(R.id.question2Fragment);
                }

                /**
                 *
                 * @param view
                 */
                private boolean checkAnswer(View view) {
                    String optionText = btn.getText().toString();
                    String correctAnswer = "FIFA INTERNATIONAL SOCCER (FIFA 94)";

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
                    } else {
                        points += 100;
                    }
                }

                /**
                 *
                 */
                private void createBundle(){
                    //
                    Bundle bundle = new Bundle();
                    bundle.putString("points", String.valueOf(points));
                    getParentFragmentManager().setFragmentResult("data", bundle);
                }
            });
        }
    }
}