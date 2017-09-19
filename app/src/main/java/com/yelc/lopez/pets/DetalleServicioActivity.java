package com.yelc.lopez.pets;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;
import android.view.Gravity;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DetalleServicioActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private Toolbar toolbar;
    private Dato dato;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_servicio);

        instanciasObj();
        transicionEntrada();
        //changeProperties();
        //buttonUp();

        updateDatos();

    }


    // instaciar objetos
    public void instanciasObj(){
        imageView = (ImageView) findViewById(R.id.app_bar_image);
        textView = (TextView) findViewById(R.id.textView);
        toolbar = (Toolbar) findViewById(R.id.toolbar);

        // objeto que se recibe atravez del intent
        dato = (Dato) getIntent().getParcelableExtra("bitMap");

    }

    // modificarDatos de acuerdo a los parametros recibidos
    public void updateDatos(){
        imageView.setImageBitmap(dato.getImagen());
        textView.setText(dato.getDetalle());
        toolbar.setTitle(dato.getTitulo());
    }


    // public void cambiar propiedades de personalizacion
    public void changeProperties(){
        toolbar.setTitleTextColor(getResources().getColor(R.color.colorAccent));
        setSupportActionBar(toolbar);
    }

    // transicion para fragment
    public void transicionEntrada(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Fade fade = new Fade();
            fade.setDuration(500);
            fade.setInterpolator(new DecelerateInterpolator());
            getWindow().setEnterTransition(fade);
            getWindow().setAllowEnterTransitionOverlap(false);
        }
    }

    // Enable the Up button
    public void buttonUp(){
        ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);
    }
}
