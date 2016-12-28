package com.antonioleiva.mvpexample.app.Login;

import android.os.Handler;
import android.text.TextUtils;

public class LoginModelImpl implements LoginModel {

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener listener) {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        boolean error = false;
        if (TextUtils.isEmpty(username)) {
            listener.onUsernameError();
            error = true;
            return;
        }
        if (TextUtils.isEmpty(password)) {
            listener.onPasswordError();
            error = true;
            return;
        }
        final boolean finalError = error;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!finalError) {
                    listener.onSuccess();
                }
            }
        }, 2000);
    }
}
