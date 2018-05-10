package com.example.luma.biblioteca.CardView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.luma.biblioteca.R;
/*
* Se crea  una clase para obtener los datos del cardview que se encuentran en layout cardview_libros.xml
* */

public class CardViewMercado extends RecyclerView.ViewHolder {
    //se crean los atributos para el card view del libro para saber que datos se van a usar como el libro la fecha de entrega etc
    public TextView nombreLlibro;
    public TextView fechaEntrega;
    public TextView fechaPrestamo;
    //se inicializan los atributos en el constructor  los cuales estos parametros se le pasan en la clase adaptadorLlibros
    public CardViewMercado(View itemView) {
        super(itemView);

        nombreLlibro = (TextView) itemView.findViewById(R.id.nombreLibro);
        fechaEntrega = (TextView) itemView.findViewById(R.id.fechaEntrega);
        fechaPrestamo = (TextView) itemView.findViewById(R.id.fechaPrestamo);
    }



}