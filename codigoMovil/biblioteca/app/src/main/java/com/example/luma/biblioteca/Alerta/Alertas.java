package com.example.luma.biblioteca.Alerta;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.text.InputType;
import android.widget.EditText;

public class Alertas {
    private Context contexto;

    public Alertas(Context contexto) {
        this.contexto = contexto;
    }

    public void MostrarAlertaBotones(){
        AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
        builder.setTitle("Nombre de la nueva lista de mercado");

        // Set up the input
        final EditText input = new EditText(contexto);
        // Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_NORMAL);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton("Agregar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
               //texto1

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();


    }
    public void MostrarAlertaLogin(){

        AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
        builder.setTitle("No se pudo iniciar sesion");

        // Set up the input




        builder.setNegativeButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
    public void MostrarAlertaCancel(){

        AlertDialog.Builder builder = new AlertDialog.Builder(contexto);
        builder.setTitle("No tienes acceso a internet, Por el momento no se puede realizar ninguna operacion");




        builder.setNegativeButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }
}
