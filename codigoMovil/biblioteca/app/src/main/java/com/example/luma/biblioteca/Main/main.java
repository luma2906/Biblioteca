package com.example.luma.biblioteca.Main;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.luma.biblioteca.Alerta.Alertas;
import com.example.luma.biblioteca.R;
import com.example.luma.biblioteca.ConstantesPreferencias.ConstantesPreferencias;
import com.example.luma.biblioteca.HomePrincipal.Home;
import com.example.luma.biblioteca.IsNetwork.IsNetworks;

import com.example.luma.biblioteca.SistemaLogin.Principal;

public class main extends AppCompatActivity {
    private String usuarioRegistrado="";
    private  boolean network;
    private  Alertas alerta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent iniciar=null;
        SharedPreferences p1=getSharedPreferences(ConstantesPreferencias.PREFERENCIA_1,MODE_PRIVATE);
        //obtengo el valor guardado en la preferencia
        usuarioRegistrado=p1.getString(ConstantesPreferencias.DATO3_PRE_NOMBRE,"n/a");
        IsNetworks internet=new IsNetworks(this);
        network=internet.isNetDisponible();
        alerta=new Alertas(this);
        if(network==true){
            if(usuarioRegistrado.equals("n/a")){
                iniciar=new Intent(getApplicationContext(), Principal.class);

            }else{
                iniciar=new Intent(getApplicationContext(), Home.class);
            }
            startActivity(iniciar);

        }else{
            alerta.MostrarAlertaCancel();
        }

    }



}
