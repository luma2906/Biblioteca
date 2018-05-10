package com.example.luma.biblioteca.Libros;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.luma.biblioteca.Adaptador.adaptadorLibros;
import com.example.luma.biblioteca.Alerta.Alertas;
import com.example.luma.biblioteca.Api.ApiServidor;
import com.example.luma.biblioteca.ConstantesPreferencias.ConstantesPreferencias;
import com.example.luma.biblioteca.HomePrincipal.Home;
import com.example.luma.biblioteca.IsNetwork.IsNetworks;
import com.example.luma.biblioteca.Listas.ListaLibros;
import com.example.luma.biblioteca.Modelos.Prestamo;
import com.example.luma.biblioteca.Modelos.Usuario;
import com.example.luma.biblioteca.R;
import com.example.luma.biblioteca.SistemaLogin.Principal;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Libros extends AppCompatActivity implements Response.Listener<JSONObject>,Response.ErrorListener,ApiServidor {
    private JsonObjectRequest jsonObjectRequest;
    private RequestQueue request;
    private List<Prestamo> listaPrestamos;
    private ArrayList<ListaLibros> list;
    private IsNetworks internet;
    private Alertas alerta;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libros);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recargar();
            }
        });
        internet=new IsNetworks(this);
        alerta=new Alertas(this);
        request= Volley.newRequestQueue(getApplicationContext());
        AgregarAdaptador();


    }

    public void AgregarAdaptador(){
        list= new ArrayList<ListaLibros>();
        listaPrestamos=new ArrayList<Prestamo>();
        int i=0;
        int id_usuario;
        String token="";

        //lleno mi lista
        SharedPreferences p1=getSharedPreferences(ConstantesPreferencias.PREFERENCIA_1,MODE_PRIVATE);
        id_usuario=p1.getInt(ConstantesPreferencias.DATO2_PRE_ID_USUARIO,0);
        token=p1.getString(ConstantesPreferencias.DATO1_PRE_TOKEN,"n/a");
        if(id_usuario!=0 && !token.equals("n/a")){
            if(internet.isNetDisponible()==true) {
                CargarWebService(token, id_usuario,"ApiPrestamos");
            }else{
                alerta.MostrarAlertaCancel();
            }
        }else{
            Intent login=new Intent(getApplicationContext(),Principal.class);
            startActivity(login);
        }

    }

    private void CargarWebService(String token,int id_usuario,String metodo){
        String url=BaseUrl+metodo+"/"+token+"/"+id_usuario;

        jsonObjectRequest=new JsonObjectRequest(Request.Method.GET,url, (String) null,this,this);
        request.add(jsonObjectRequest);

    }
    public void recargar(){
        finish();
        startActivity(getIntent());
    }






    @Override
    public void onErrorResponse(VolleyError error) {
        Toast.makeText(getApplicationContext(),"Error de conexion"+error,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onResponse(JSONObject response) {
        String RESP=response.optString("resultado");

        if(RESP.equals("exito")){
            SharedPreferences p1=getSharedPreferences(ConstantesPreferencias.PREFERENCIA_1,MODE_PRIVATE);
            JSONArray json=response.optJSONArray("Prestamos");
            JSONArray json2=response.optJSONArray("Libros");

            try {
                for (int j=0; j<json.length();j++){
                    JSONObject jsonob = json.getJSONObject(j);
                    for (int z=0; z<json2.length();z++) {

                        JSONObject jsonob2 = json2.getJSONObject(z);
                       if(jsonob.optInt("id_libro")==jsonob2.optInt("id_libro")){
                            Prestamo user = new Prestamo(jsonob.optInt("id_prestamo"), jsonob.optString("fecha_prestamo"), jsonob.optString("fecha_entrega"), jsonob2.optString("nombre_libro"), jsonob.optInt("id_usuario"), jsonob.optString("created_at"), jsonob.optString("updated_at"), jsonob.optString("deleted_at"));
                            listaPrestamos.add(user);
                       }

                    }

                }
                LlenarCardView();







            } catch (JSONException e) {
                e.printStackTrace();
            }
        }else{
            Intent login=new Intent(getApplicationContext(),Principal.class);
            startActivity(login);
        }

    }

    public void LlenarCardView(){
        int i=0;
        if(listaPrestamos!=null){
            while(i<listaPrestamos.size()){
                list.add(new ListaLibros("Nombre: "+listaPrestamos.get(i).getId_libro(),"Fecha Prestamo: "+listaPrestamos.get(i).getFecha_prestamo(), "Fecha entrega: "+listaPrestamos.get(i).getFecha_entrega()));
                i++;

            }
        }else{
            list.add(new ListaLibros("vacio","vacio","vacio"));
            Toast.makeText(getApplicationContext(),"No tiene libros prestados",Toast.LENGTH_LONG).show();
        }

        RecyclerView contenedor2=(RecyclerView) findViewById(R.id.libros);

        contenedor2.setHasFixedSize(true);
        //layout verticar o horizontal
        //LinearLayoutManager layout=new LinearLayoutManager(getApplicationContext());
        //layout.setOrientation(LinearLayoutManager.VERTICAL);

        //grid layout

        GridLayoutManager layout=new GridLayoutManager(this,2);


        adaptadorLibros adp=new adaptadorLibros(list);

        contenedor2.setAdapter(adp);
        contenedor2.setLayoutManager(layout);
    }
}
