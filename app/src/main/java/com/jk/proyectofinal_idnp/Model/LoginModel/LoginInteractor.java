package com.jk.proyectofinal_idnp.Model.LoginModel;

public interface LoginInteractor {
    /*escuchar al activity*/
    interface OnLoginFinishedListener{
        void onUsernameError();
        void onPasswordError();
        void onSuccess();
    }

    void login(String username, String password, OnLoginFinishedListener listener);
}
