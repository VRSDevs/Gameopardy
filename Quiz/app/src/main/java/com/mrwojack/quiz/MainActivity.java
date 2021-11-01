package com.mrwojack.quiz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /****************** MÉTODOS DE CICLO DE VIDA *******************/
    /**
     * Método ejecutado cuando se crea la actividad
     * @param savedInstanceState -> Referencia a objeto bundle que guarda el estado anterior de la actividad
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createSharedPreferences();
    }

    /****************** MÉTODOS DE NAVEGACIÓN *******************/
    /**
     * Método para abrir el menú de ajustes
     * @param view -> Referencia a la vista
     */
    public void openSettings(View view) {
        // Obtención de objeto Intent para el cambio de actividad
        Intent int_Settings = new Intent(this, SettingsActivity.class);
        // Inicio de la actividad
        startActivity(int_Settings);
        // Finalización de la actividad
        finish();
    }

    /**
     *
     * @param view
     */
    public void closeGame(View view){
        close();
    }

    /****************** MÉTODOS DE EVENTO *******************/
    /**
     * Método para sobreescribir el comportamiento de teclas pulsadas
     * @param keyCode -> Código de la tecla
     * @param event -> Evento de la tecla pulsada
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch(keyCode) {
            case KeyEvent.KEYCODE_BACK:
                close();
                break;
        }

        return super.onKeyDown(keyCode, event);
    }

    /**
     * Método sobreescrito para el comportamiento del botón de retroceso
     */
    @Override
    public void onBackPressed() {}

    /****************** OTROS MÉTODOS *******************/

    private void createSharedPreferences() {
        SharedPreferences preferences = getSharedPreferences("preferenceias", Context.MODE_PRIVATE);

        if(preferences != null) {
            Toast.makeText(this, "Fichero encontrado", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("musicVol", 100);
        editor.putInt("sfxVol", 100);
        editor.putString("difficulty", "Fácil");

        editor.commit();
    }

    /**
     *
     */
    private void close() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage("¿Seguro que desea salir?")
                .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //
                        Intent intClose = new Intent(Intent.ACTION_MAIN);
                        intClose.addCategory(Intent.CATEGORY_HOME);
                        intClose.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        //
                        startActivity(intClose);
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
        builder.show();
    }
}