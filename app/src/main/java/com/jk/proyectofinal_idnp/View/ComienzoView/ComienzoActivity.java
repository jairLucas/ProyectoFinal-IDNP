package com.jk.proyectofinal_idnp.View.ComienzoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jk.proyectofinal_idnp.View.ComienzoView.Fragments.ComienzoDatosFragment;
import com.jk.proyectofinal_idnp.View.ComienzoView.Fragments.ComienzoHistorialFragment;
import com.jk.proyectofinal_idnp.R;
import com.jk.proyectofinal_idnp.View.MusicaView.MusicaActivity;
import com.jk.proyectofinal_idnp.View.TrayectoriaView.TrayectoriaActivity;

public class ComienzoActivity extends AppCompatActivity{
    FragmentTransaction transaccion;
    Fragment Fdatos,Fhistorial;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //inicializar y sincronizar fragments
        Fdatos = new ComienzoDatosFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragment_comienzo_datos,Fdatos).commit();
        Fhistorial = new ComienzoHistorialFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragment_comienzo_historial,Fhistorial).commit();
        inicializarBottomNavigationView();

    }

    private void inicializarBottomNavigationView(){
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        bottomNavigationView.setSelectedItemId(R.id.comienzo);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener(){
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.comienzo:
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