package com.jk.proyectofinal_idnp.View.TrayectoriaView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jk.proyectofinal_idnp.R;
import com.jk.proyectofinal_idnp.View.ComienzoView.ComienzoActivity;
import com.jk.proyectofinal_idnp.View.ComienzoView.Fragments.ComienzoDatosFragment;
import com.jk.proyectofinal_idnp.View.ComienzoView.Fragments.ComienzoHistorialFragment;
import com.jk.proyectofinal_idnp.View.MusicaView.MusicaActivity;
import com.jk.proyectofinal_idnp.View.TrayectoriaView.Fragments.MapsFragment;

public class TrayectoriaActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    FragmentTransaction transaccion;
    Fragment Fmaps,Ftrayectorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trayectoria);
        Fmaps = new MapsFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragment_trayectoria_maps,Fmaps).commit();
        Ftrayectorias = new ComienzoHistorialFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragment_trayectorias,Ftrayectorias).commit();
        inicializarBottomNavigationView();
    }
    private void inicializarBottomNavigationView(){
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.trayectoria);

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
                        return true;
                }
                return false;
            }
        });
    }
}