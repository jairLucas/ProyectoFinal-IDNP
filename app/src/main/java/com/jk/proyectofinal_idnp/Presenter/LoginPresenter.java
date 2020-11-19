package com.jk.proyectofinal_idnp.Presenter;

public interface LoginPresenter {
    void validateCredentials(String username, String password);
    void onDestroy();
}
