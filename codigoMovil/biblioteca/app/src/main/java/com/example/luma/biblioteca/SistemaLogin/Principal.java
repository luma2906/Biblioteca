package com.example.luma.biblioteca.SistemaLogin;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
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
import com.example.luma.biblioteca.HomePrincipal.Home;
import com.example.luma.biblioteca.IsNetwork.IsNetworks;
import com.example.luma.biblioteca.R;

import org.json.JSONException;
import org.json.JSONObject;

public class Principal extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener,ApiServidor{

    private  JsonObjectRequest jsonObjectRequest;
    private RequestQueue request;
    private IsNetworks internet;
    private Alertas alertas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        request= Volley.newRequestQueue(getApplicationContext());
        internet=new IsNetworks(this);
        alertas=new Alertas(this);


    }


    public void Login(View v){
        EditText correo=(EditText) findViewById(R.id.correo);
        EditText password=(EditText) findViewById(R.id.password);
        if(internet.isNetDisponible()==true){
            CargarWebService(correo.getText().toString(),password.getText().toString(),"ApiLogin");
        }else{
            alertas.MostrarAlertaCancel();
        }


    }
    private void CargarWebService(String correo, String password,String metodo){
        String url=BaseUrl+metodo+"/"+correo+"/"+password;
        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url, (String) null,this,this);
        request.add(jsonObjectRequest);

    }

    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(),"Error de conexion"+error,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        String RESP=response.optString("resultado");
        if(RESP.equals("exito")){
            JSONObject json=response.optJSONObject("usuario");
            try {
                String token=json.getString("api_token");
                int id_usuario=json.getInt("id_usuario");
                String nombre_usuario=json.getString("nombre");
                String apellido_usuario=json.getString("apellido");
                //obtenemos las preferencias por defecto de la app
                //SharedPreferences preferencia= PreferenceManager.getDefaultSharedPreferences(this);
                //para crear una preferencia propia
                SharedPreferences p1=getSharedPreferences(ConstantesPreferencias.PREFERENCIA_1,MODE_PRIVATE);
                SharedPreferences.Editor edit=p1.edit();
                edit.putString(ConstantesPreferencias.DATO1_PRE_TOKEN,token);
                edit.putString(ConstantesPreferencias.DATO3_PRE_NOMBRE,nombre_usuario);
                edit.putString(ConstantesPreferencias.DATO4_PRE_APELLIDO,apellido_usuario);
                edit.putInt(ConstantesPreferencias.DATO2_PRE_ID_USUARIO,id_usuario);
                //sincrono funciona el commit
                //edit.commit();
                //asincrono
                edit.apply();
                Intent home=new Intent(getApplicationContext(),Home.class);
                startActivity(home);

                //obtengo el valor guardado en la preferencia
                //String tok=p1.getString(ConstantesPreferencias.DATO1_PRE,"n/a");

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else{
            alertas.MostrarAlertaLogin();
        }

    }
}
