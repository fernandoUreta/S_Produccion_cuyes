package com.example.appproduccioncuyes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.appproduccioncuyes.ModeloDatos.ActividadCardview;



import java.util.List;

public class RecyclerViewAdaptador extends RecyclerView.Adapter<RecyclerViewAdaptador.ViewHolder>
{
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView idCuy, idPoza, edadCuy;
        //  ImageView fotoActividad;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            idCuy = (TextView) itemView.findViewById(R.id.tvIdCuy);
            idPoza = (TextView) itemView.findViewById(R.id.tvIdPoza);
            edadCuy = (TextView) itemView.findViewById(R.id.tvEdadCuy);

        }
    }
        public List<ActividadCardview> actividadLista;

    public RecyclerViewAdaptador(List<ActividadCardview>actividadLista) {
        this.actividadLista=actividadLista;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_actividad,parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
            return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.idCuy.setText(actividadLista.get(position).getIdCuy());
        holder.idPoza.setText(actividadLista.get(position).getIdPoza());
        holder.edadCuy.setText(actividadLista.get(position).getEdadCuy());
    }

    @Override
    public int getItemCount() {
            return actividadLista.size();
    }
}
