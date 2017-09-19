package com.yelc.lopez.pets;

import android.content.Intent;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // crear un splash durante el tiempo que se carga los componentes de la actividad principal
        startActivity(new Intent(this, OpcionesActivity.class));
        finish();
    }
}
