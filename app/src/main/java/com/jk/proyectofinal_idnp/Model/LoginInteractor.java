package com.jk.proyectofinal_idnp.Model;

public interface LoginInteractor {
    /*escuchar al activity*/
    interface OnLoginFinishedListener{
        void onUsernameError();
        void onPasswordError();
        void onSuccess();
    }

    void login(String username, String password, OnLoginFinishedListener listener);
}
