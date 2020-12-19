package com.jk.proyectofinal_idnp;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.jk.proyectofinal_idnp.View.ComienzoView.ComienzoActivity;

public abstract class Main extends AppCompatActivity implements View.OnClickListener {
    EditText user, pass;
    Button btnEntrar, btnRegistrar;
    daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user=(EditText)findViewById(R.id.inputUsername);
        pass=(EditText)findViewById(R.id.inputEmail);
        btnEntrar=(Button)findViewById(R.id.button_login);
        btnRegistrar=(Button)findViewById(R.id.button_login2);

        btnEntrar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
        dao= new daoUsuario(this);
    }
/*
    public void onClickCR(View v){
        switch (v.getId()){
            case R.id.button_login:
                String u=user.getText().toString();
                String p=pass.getText().toString();
                if(u.equals("")&&p.equals("")){
                    Toast.makeText(this, "Error: Campos vacios", Toast.LENGTH_SHORT).show();
                }else if(dao.login(u,p)==1){
                    Usuario ux= dao.getUsuario(u,p);
                    Toast.makeText(this, "Datos correctos", Toast.LENGTH_SHORT).show();
                    Intent i2= new Intent (Main.this, ComienzoActivity.class);
                    i2.putExtra("id", ux.getId());
                    startActivity(i2);
                    finish();
                }else{
                    Toast.makeText(this, "Usuario y/o password incorrectos", Toast.LENGTH_SHORT).show();
                }

                break;
            case R.id.button_login2:
                Intent i=new Intent(Main.this, Registrar.class);
                startActivity(i);
                break;
        }


    }*/
    /*
    public void iniciar(View view){
        String u=user.getText().toString();
        String p=pass.getText().toString();
        if(u.equals("")&&p.equals("")){
            Toast.makeText(this, "Error: Campos vacios", Toast.LENGTH_SHORT).show();
        }else if(dao.login(u,p)==1){
            Usuario ux= dao.getUsuario(u,p);
            Toast.makeText(this, "Datos correctos", Toast.LENGTH_SHORT).show();
            Intent i2= new Intent (Main.this, ComienzoActivity.class);
            i2.putExtra("id", ux.getId());
            startActivity(i2);
            finish();
        }else{
            Toast.makeText(this, "Usuario y/o password incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    public void registrar(View view){
        Intent i=new Intent(Main.this, Registrar.class);
        startActivity(i);
    }

*/
}