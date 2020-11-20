package com.jk.proyectofinal_idnp.Model.LoginModel;

import android.text.TextUtils;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class LoginInteractorImpl implements LoginInteractor {

    @Override
    public void login(final String username,final String password,final OnLoginFinishedListener listener) {
        new Handler() {
            public void postDelayed(Runnable runnable, int i) {
            }

            @Override
            public void publish(LogRecord record) {
                
            }

            @Override
            public void flush() {

            }

            @Override
            public void close() throws SecurityException {

            }
        }.postDelayed(new Runnable(){
            @Override
            public void run() {
                if(TextUtils.isEmpty(username)){
                    listener.onUsernameError();
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    listener.onPasswordError();
                    return;
                }
                listener.onSuccess();
            }
        },1000);
    }
}
