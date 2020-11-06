package com.example.appproduccioncuyes;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.appproduccioncuyes.ModeloDatos.Actividad;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private List<Actividad> mDataset;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView idPoza,idCuy,edadCuy;
        public MyViewHolder(TextView v) {
            super(v);
            idPoza = v.findViewById(R.id.tvIdPoza_Card);
            idCuy=v.findViewById(R.id.tvIdCuy_Card);
            edadCuy=v.findViewById(R.id.tvEdadCuy_Card);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MyAdapter(List<Actividad> myDataset)
    {
        mDataset = myDataset;
    }


    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_actividad, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.idCuy.setText(mDataset.get(position).getCuyId());
        holder.idPoza.setText(mDataset.get(position).getIdPoza());
        holder.edadCuy.setText(mDataset.get(position).getEdad());

    }

    // Return the size of your dataset (invoked by the laout manager)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
