package com.jk.proyectofinal_idnp.View.LoginView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.jk.proyectofinal_idnp.Main;
import com.jk.proyectofinal_idnp.Model.Model.LoginModel.LoginInteractorImpl;
import com.jk.proyectofinal_idnp.Presenter.LoginPresenter.LoginPresenter;
import com.jk.proyectofinal_idnp.Presenter.LoginPresenter.LoginPresenterImpl;
import com.jk.proyectofinal_idnp.R;
import com.jk.proyectofinal_idnp.Registrar;
import com.jk.proyectofinal_idnp.Usuario;
import com.jk.proyectofinal_idnp.View.ComienzoView.ComienzoActivity;
import com.jk.proyectofinal_idnp.daoUsuario;

public class LoginActivity extends Activity implements LoginView, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public void showProgress() {

    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void setUsernameError() {

    }

    @Override
    public void setPasswordError() {

    }

    @Override
    public void navigateToHome() {

    }

    @Override
    public void onClick(View v) {

    }
}