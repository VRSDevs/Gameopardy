package com.mrwojack.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.mrwojack.quiz.fragments.settings.MusicSettingsFragment;

public class SettingsActivity extends AppCompatActivity {

    /****************** VARIABLES *******************/


    /****************** CICLO DE VIDA *******************/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    /****************** MÉTODOS DE NAVEGACIÓN *******************/

    public void showMusicSettings(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragCV_Settings, new MusicSettingsFragment()).commit();
    }

    public void showMatchSettings(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragCV_Settings, new MusicSettingsFragment()).commit();
    }
}