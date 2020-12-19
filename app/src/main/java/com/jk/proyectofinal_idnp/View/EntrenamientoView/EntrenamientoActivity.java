package com.jk.proyectofinal_idnp.View.EntrenamientoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jk.proyectofinal_idnp.R;
import com.jk.proyectofinal_idnp.View.ComienzoView.ComienzoActivity;
import com.jk.proyectofinal_idnp.View.MusicaView.MusicaActivity;
import com.jk.proyectofinal_idnp.View.TrayectoriaView.Fragments.MapsFragment;
import com.jk.proyectofinal_idnp.View.TrayectoriaView.TrayectoriaActivity;

public class EntrenamientoActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;
    Fragment Fmaps;
    Spinner opciones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrenamiento);
        //fragments
        Fmaps = new MapsFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragment_entrenamiento_maps,Fmaps).commit();
        opciones = (Spinner)findViewById(R.id.spinner_trayectorias);
        ArrayAdapter<CharSequence> adapter  = ArrayAdapter.createFromResource(this,R.array.opciones, android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter);
        inicializarBottomNavigationView();
    }
    public void A_configuracion(View view){
        Intent intent_entrenamiento = new Intent(this, EntrenamientoActivity.class);
        startActivity(intent_entrenamiento);
    }
    private void inicializarBottomNavigationView(){
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        //bottomNavigationView.setSelectedItemId(R.id.trayectoria);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.comienzo:
                        startActivity(new Intent(getApplicationContext(), ComienzoActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.musica:
                        startActivity(new Intent(getApplicationContext(), MusicaActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.trayectoria:
                        startActivity(new Intent(getApplicationContext(), TrayectoriaActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

}