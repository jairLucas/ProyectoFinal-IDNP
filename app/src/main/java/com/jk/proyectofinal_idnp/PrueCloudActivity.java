package com.jk.proyectofinal_idnp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.jk.proyectofinal_idnp.Model.Models.Trayectoria;

import java.util.UUID;

public class PrueCloudActivity extends AppCompatActivity {
    private EditText fec,hor,lat,lon,vel;
    //private ListView dat;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prueba_cloud);
        fec = (EditText)findViewById(R.id.fecha);
        hor = (EditText)findViewById(R.id.hora);
        lat = (EditText)findViewById(R.id.latitud);
        lon = (EditText)findViewById(R.id.longitud);
        vel = (EditText)findViewById(R.id.velocidad);
        //dat = (ListView)findViewById(R.id.resultado);
        inicializarFirebase();
    }

    private void inicializarFirebase(){
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }
    public void agregar(View view){
        String fecha = fec.getText().toString();
        String hora = hor.getText().toString();
        String latitud = lat.getText().toString();
        String longitud = lon.getText().toString();
        String velocidad = vel.getText().toString();

        if (fecha.equals("")||hora.equals("")||latitud.equals("")||longitud.equals("")||velocidad.equals("")){
            validar();
        }else{
            Trayectoria t = new Trayectoria();
            t.setId(UUID.randomUUID().toString());
            t.setFecha(fecha);
            t.setHora(hora);
            t.setLatitud(latitud);
            t.setLongitud(longitud);
            t.setVelocidad(velocidad);
            databaseReference.child("Trayectoria").child(t.getId()).setValue(t);
            Toast.makeText(this, "agregado", Toast.LENGTH_SHORT).show();
            limpiarCajas();
        }

    }
    /*
    public void guardar(View view){

    }
    public void eliminar(View view){


    }
    */

    public void validar(){
        String fecha = fec.getText().toString();
        String hora = hor.getText().toString();
        String latitud = lat.getText().toString();
        String longitud = lon.getText().toString();
        String velocidad = vel.getText().toString();
        if (fecha.equals("")){
            fec.setError("Required");
        }
        if (hora.equals("")){
            fec.setError("Required");
        }
        if (latitud.equals("")){
            fec.setError("Required");
        }
        if (longitud.equals("")){
            fec.setError("Required");
        }
        if (velocidad.equals("")){
            fec.setError("Required");
        }
    }
    public void limpiarCajas(){
        fec.setText("");
        hor.setText("");
        lat.setText("");
        lon.setText("");
        vel.setText("");
    }
}