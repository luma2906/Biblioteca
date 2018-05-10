package com.example.luma.biblioteca.HomePrincipal;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.luma.biblioteca.Alerta.Alertas;
import com.example.luma.biblioteca.Api.ApiServidor;
import com.example.luma.biblioteca.ConstantesPreferencias.ConstantesPreferencias;
import com.example.luma.biblioteca.IsNetwork.IsNetworks;
import com.example.luma.biblioteca.Libros.Libros;
import com.example.luma.biblioteca.R;
import com.example.luma.biblioteca.SistemaLogin.Principal;

import org.json.JSONObject;

public class Home extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener,ApiServidor {
    private String usuarioRegistrado="";
    private JsonObjectRequest jsonObjectRequest;
    private RequestQueue request;
    private IsNetworks internet;
    private  Alertas alerta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        SharedPreferences p1=getSharedPreferences(ConstantesPreferencias.PREFERENCIA_1,MODE_PRIVATE);
        //obtengo el valor guardado en la preferencia
        usuarioRegistrado=p1.getString(ConstantesPreferencias.DATO3_PRE_NOMBRE,"n/a");
        toolbar.setTitle("Bienvenid@ "+usuarioRegistrado);
        setSupportActionBar(toolbar);
        internet=new IsNetworks(this);
        alerta=new Alertas(this);
        request= Volley.newRequestQueue(getApplicationContext());


    }





    private void CargarWebService(String metodo){
        String url=BaseUrl+metodo;
        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url, (String) null,this,this);
        request.add(jsonObjectRequest);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            if(internet.isNetDisponible()==true) {
                CargarWebService("ApiLogOut");
            }else{
                alerta.MostrarAlertaCancel();
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(),"Error no se encontro el servidor"+error,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        CerrarSesion(response);
    }

    public void CerrarSesion(JSONObject response){
        String RESP=response.optString("resultado");
        if(RESP.equals("exito")){
            SharedPreferences p1=getSharedPreferences(ConstantesPreferencias.PREFERENCIA_1,MODE_PRIVATE);
            //Borro la preferencia
            p1.edit().clear().commit();
            Intent inicio=new Intent(getApplicationContext(), Principal.class);
            startActivity(inicio);
        }
    }

    public void VerPrestamoLibros(View v){
        Intent librosPrestado=new Intent(getApplicationContext(), Libros.class);
        startActivity(librosPrestado);
    }
}
