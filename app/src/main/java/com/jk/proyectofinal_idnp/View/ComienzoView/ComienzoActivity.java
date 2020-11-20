package com.jk.proyectofinal_idnp.View.ComienzoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.jk.proyectofinal_idnp.View.ComienzoView.Fragments.ComienzoDatosFragment;
import com.jk.proyectofinal_idnp.View.ComienzoView.Fragments.ComienzoHistorialFragment;
import com.jk.proyectofinal_idnp.R;

public class ComienzoActivity extends AppCompatActivity{
    FragmentTransaction transaccion;
    Fragment Fdatos,Fhistorial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comienzo);
        //inicializar y sincronizar fragments
        Fdatos = new ComienzoDatosFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragment_comienzo_datos,Fdatos).commit();
        Fhistorial = new ComienzoHistorialFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragment_comienzo_historial,Fhistorial).commit();
    }
}