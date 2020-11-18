package com.example.proyectocuy.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectocuy.ModeloDatos.Actividad;
import com.example.proyectocuy.R;

import java.util.List;

public class ActividadesAdapter extends RecyclerView.Adapter<ActividadesAdapter.MyViewHolder> {
    private List<Actividad> listActividades;

    private LayoutInflater mInflater;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView tvPozaID,tvCuyID,tvCuyEdad,tvGenero,tvCategoria,tvDescripcion;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvPozaID=itemView.findViewById(R.id.tvIdPoza_item);
            tvCuyID=itemView.findViewById(R.id.tvIdCuy_item);
            tvCuyEdad=itemView.findViewById(R.id.tvEdadCuy_item);
            tvGenero=itemView.findViewById(R.id.tvGenero_item);
            tvCategoria=itemView.findViewById(R.id.tvCategoria_item);
            tvDescripcion=itemView.findViewById(R.id.tvDescripcion_item);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public ActividadesAdapter(Context context, List<Actividad> listActividades) {
        this.mInflater= LayoutInflater.from(context);
        this.listActividades = listActividades;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = mInflater.inflate(R.layout.actividad_item, parent, false);
        //RecyclerView.LayoutParams layoutParams=new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
          //      ViewGroup.LayoutParams.WRAP_CONTENT);
        //v.setLayoutParams(layoutParams);
        return new MyViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.tvPozaID.setText(listActividades.get(position).getIdPoza());
        holder.tvCuyID.setText(listActividades.get(position).getIdCuy());
        holder.tvCuyEdad.setText(String.valueOf(listActividades.get(position).getCuyEdad()));
        holder.tvGenero.setText(listActividades.get(position).getGenero());
        holder.tvCategoria.setText(listActividades.get(position).getCategoria());
        holder.tvDescripcion.setText(listActividades.get(position).getDescripcion());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return listActividades.size();
    }
}