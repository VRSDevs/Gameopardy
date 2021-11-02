package com.mrwojack.quiz.fragments.settings;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

import com.mrwojack.quiz.R;

public class MusicSettingsFragment extends Fragment {

    //region Variables

    /**
     * Referencia a SeekBar de la música
     */
    SeekBar musicBar;
    /**
     * Referencia a SeekBar de los sonidos
     */
    SeekBar sfxBar;
    /**
     * Referencia al botón de guardado de las preferencias de la música
     */
    Button saveButton;

    //endregion

    //region Constructores

    public MusicSettingsFragment() {
        // Required empty public constructor
    }

    //endregion

    //region Métodos - Ciclo de vida

    /**
     * Método ejecutado cuando se crea el fragmento
     * @param savedInstanceState -> Referencia a objeto bundle que guarda el estado anterior de la actividad
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * Método ejecutado y que devuelve la vista creada asignada al fragmento
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_music_settings, container, false);
    }

    /**
     * Método ejecutado instantes posteriores a @onCreateView
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Inicialización de referencias
        musicBar = view.findViewById(R.id.sb_Music);
        sfxBar = view.findViewById(R.id.sb_Effects);
        saveButton = view.findViewById(R.id.btt_SaveMusic);

        // Asignación de progreso a SeekBars
        musicBar.setProgress(
                this.getActivity().getSharedPreferences("preferencias", Context.MODE_PRIVATE).getInt("musicVol", 0)
        );
        sfxBar.setProgress(
                this.getActivity().getSharedPreferences("preferencias", Context.MODE_PRIVATE).getInt("sfxVol", 0)
        );

        // Asignación de evento de escucha al botón de guardado
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveMusicPreferences();
            }
        });
    }

    //endregion

    //region Métodos - Otros

    /**
     * Método para guardar las preferencias de la música
     */
    private void saveMusicPreferences() {
        // Obtención del fichero y su editor
        SharedPreferences preferences = this.getActivity().getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();

        // Inserción de la dificultad
        editor.putInt("musicVol", musicBar.getProgress());
        editor.putInt("sfxVol", sfxBar.getProgress());
        editor.commit();
    }

    //endregion
}