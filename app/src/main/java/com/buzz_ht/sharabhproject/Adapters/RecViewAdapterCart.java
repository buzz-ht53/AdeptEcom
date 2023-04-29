package com.buzz_ht.sharabhproject.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.buzz_ht.sharabhproject.Model.Bag;
import com.buzz_ht.sharabhproject.R;

import java.util.List;

public class RecViewAdapterCart extends RecyclerView.Adapter<RecViewAdapterCart.MyViewHolder> {

    Context context;
    public List<Bag> list;

    public RecViewAdapterCart(Context context, List list) {
        this.context = context;
        this.list = list;
    }

    public RecViewAdapterCart() {

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.recview_layout_cart, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView.setText("Hello");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.txt1);
        }
    }


}
