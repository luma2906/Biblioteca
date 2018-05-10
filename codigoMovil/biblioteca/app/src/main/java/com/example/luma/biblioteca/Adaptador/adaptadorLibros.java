package com.example.luma.biblioteca.Adaptador;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luma.biblioteca.CardView.CardViewMercado;
import com.example.luma.biblioteca.Listas.ListaLibros;
import com.example.luma.biblioteca.R;

import java.util.List;

public class adaptadorLibros extends RecyclerView.Adapter<CardViewMercado> implements View.OnClickListener{
    //Creo una lista de objetos tipo libros para guardar la estructura del card view
    List<ListaLibros> listasObj;
    //Creo un constructor para inicializar la lista  de objetos  de libros
    public adaptadorLibros(List<ListaLibros> listasObj) {
        this.listasObj = listasObj;
    }
    //Creo el cardview para poder usarlo en mi recyclerview
    @NonNull
    @Override
    public CardViewMercado onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View vista= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_libros,parent,false);
        vista.setOnClickListener(this);
        return new CardViewMercado(vista);
    }
    //le paso los valores al cardview
    @Override
    public void onBindViewHolder(@NonNull CardViewMercado holder, int position) {

        holder.nombreLlibro.setText(listasObj.get(position).getNombre());
        holder.fechaEntrega.setText(listasObj.get(position).getFecha1());
        holder.fechaPrestamo.setText(listasObj.get(position).getFecha2());


    }
    //devuelvo el total de elementos que tiene mi lista de objetos
    @Override
    public int getItemCount() {
        return listasObj.size();
    }

    @Override
    public void onClick(View v) {

    }
}
