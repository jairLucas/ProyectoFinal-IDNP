package com.jk.proyectofinal_idnp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.jk.proyectofinal_idnp.Fragments.ComienzoDatosFragment;

public class ComienzoActivity extends AppCompatActivity {
    FragmentTransaction transaccion;
    ComienzoDatosFragment Fdatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comienzo);
        //inicializar fragments
        Fdatos = new ComienzoDatosFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.contenedor_fragment_comienzo_datos,Fdatos).commit();

    }


}