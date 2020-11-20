package com.jk.proyectofinal_idnp.View.LoginView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jk.proyectofinal_idnp.Model.LoginModel.LoginInteractorImpl;
import com.jk.proyectofinal_idnp.Presenter.LoginPresenter.LoginPresenter;
import com.jk.proyectofinal_idnp.Presenter.LoginPresenter.LoginPresenterImpl;
import com.jk.proyectofinal_idnp.R;

public class LoginActivity extends Activity implements LoginView, View.OnClickListener {
    private ProgressBar progressBar;
    private EditText usuario, password;
    private LoginPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        progressBar = (ProgressBar)findViewById(R.id.progressBar_login);
        usuario = (EditText)findViewById(R.id.editText_login_usuario);
        password = (EditText)findViewById(R.id.editText_login_password);

        findViewById(R.id.button_login).setOnClickListener(this);
        presenter = new LoginPresenterImpl(this,new LoginInteractorImpl());
    }

    @Override
    protected void onDestroy() {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        presenter.validateCredentials(usuario.getText().toString(),password.getText().toString());
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError() {
        usuario.setText("Error de usuario");
    }
    @Override
    public void setPasswordError(){
        password.setError("Error de password");
    }



    @Override
    public void navigateToHome() {
        Toast.makeText(this, "Ingresó", Toast.LENGTH_SHORT).show();
    }
}