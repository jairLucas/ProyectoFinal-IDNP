package com.jk.proyectofinal_idnp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.jk.proyectofinal_idnp.View.LoginView.LoginActivity;

public class Bienvenido extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /*
Button siguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//dsdsdghj
        siguiente = (Button) findViewById(R.id.button2);
        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Bienvenido.this, Main.class);
                startActivityForResult(intent, 0);
            }
        });
    }
*/
    /*
    public void toLogin(View v){
        Intent intent_login = new Intent(this, LoginActivity.class);
        startActivityForResult(intent_login,0);
    }*/
}