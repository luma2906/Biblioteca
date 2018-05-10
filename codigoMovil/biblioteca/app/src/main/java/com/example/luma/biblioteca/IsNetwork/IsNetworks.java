package com.example.luma.biblioteca.IsNetwork;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class IsNetworks {
    private Context contexto;

    public IsNetworks(Context contexto) {
        this.contexto = contexto;
    }

    public boolean isNetDisponible() {

        ConnectivityManager connectivityManager = (ConnectivityManager)
                contexto.getSystemService(contexto.getApplicationContext().CONNECTIVITY_SERVICE);

        NetworkInfo actNetInfo = connectivityManager.getActiveNetworkInfo();

        return (actNetInfo != null && actNetInfo.isConnected());
    }
}
