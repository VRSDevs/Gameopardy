package com.mrwojack.gameopardy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    //
    TextView txtViewFinalPoints;
    TextView txtViewFinalHits;
    TextView txtViewFinalMistakes;
    //
    int finalPoints = 0;
    int finalHits = 0;
    int finalMistakes = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //
        txtViewFinalPoints = findViewById(R.id.txtView_finalPoints);
        txtViewFinalHits = findViewById(R.id.txtView_finalHits);
        txtViewFinalMistakes = findViewById(R.id.txtView_finalMistakes);
        txtViewFinalMistakes = findViewById(R.id.txtView_finalMistakes);
        //
        finalPoints = Integer.parseInt(getIntent().getStringExtra("points"));
        finalHits = Integer.parseInt(getIntent().getStringExtra("hits"));
        finalMistakes = Integer.parseInt(getIntent().getStringExtra("mistakes"));
        //
        txtViewFinalPoints.setText(String.valueOf(finalPoints));
        txtViewFinalHits.setText(String.valueOf(finalHits));
        txtViewFinalMistakes.setText(String.valueOf(finalMistakes));
    }

    /**
     *
     * @param view
     */
    public void playAgain(View view) {
        //
        Intent int_game = new Intent(this, GameActivity.class);

        startActivity(int_game);
        finish();
    }

    /**
     *
     * @param view
     */
    public void goHome(View view) {
        // Creación de objeto intent
        Intent int_home = new Intent(this, MainActivity.class);

        startActivity(int_home);
        finish();
    }
}