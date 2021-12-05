package com.buzz_ht.sharabhproject.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.buzz_ht.sharabhproject.Model.Bag;
import com.buzz_ht.sharabhproject.R;

import java.util.List;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.MyViewHolder> {

    Context context;
    List<Bag> list;

    public RecViewAdapter(Context context, List<Bag> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.recview_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.image.setImageResource(list.get(position).getImage());
        holder.txtProduct.setText(list.get(position).getBagName());
        holder.txtColor.setText(list.get(position).getColor());
        holder.txtDimensions.setText(list.get(position).getBagDimensions());
        holder.txtAvail.setText(list.get(position).getAvailability());
        holder.txtPrice.setText(list.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtProduct, txtColor, txtDimensions, txtPrice, txtAvail;
        ImageView image;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtPrice = itemView.findViewById(R.id.txtprice);
            txtProduct = itemView.findViewById(R.id.txtproduct);
            txtColor = itemView.findViewById(R.id.txtcolor);
            txtDimensions = itemView.findViewById(R.id.txtdimensions);
            txtAvail = itemView.findViewById(R.id.txtavail);

            image = itemView.findViewById(R.id.image);


        }
    }

}
