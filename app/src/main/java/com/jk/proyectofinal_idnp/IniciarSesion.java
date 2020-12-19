package com.jk.proyectofinal_idnp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.jk.proyectofinal_idnp.View.ComienzoView.ComienzoActivity;

public class IniciarSesion extends AppCompatActivity {
    EditText user, pass;

    daoUsuario dao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
        user=(EditText)findViewById(R.id.inputUsername);
        pass=(EditText)findViewById(R.id.inputEmail);
        dao= new daoUsuario(this);
    }

    public void iniciar(View view){
        
        String u=user.getText().toString();
        String p=pass.getText().toString();
        if(u.equals("")&&p.equals("")){
            Toast.makeText(this, "Error: Campos vacios", Toast.LENGTH_SHORT).show();
        }else if(dao.login(u,p)==1){
            Usuario ux= dao.getUsuario(u,p);
            Toast.makeText(this, "Datos correctos", Toast.LENGTH_SHORT).show();
            Intent i2= new Intent (this, ComienzoActivity.class);
            i2.putExtra("id", ux.getId());
            startActivity(i2);
            finish();
        }else{
            Toast.makeText(this, "Usuario y/o password incorrectos", Toast.LENGTH_SHORT).show();
        }



    }

    public void registrar(View view){
        Intent i=new Intent(this, RegisterActivity.class);
        startActivity(i);
    }
}