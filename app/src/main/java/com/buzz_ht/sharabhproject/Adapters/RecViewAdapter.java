package com.buzz_ht.sharabhproject.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.buzz_ht.sharabhproject.Fragments.FragmentCart;
import com.buzz_ht.sharabhproject.Model.Bag;

import com.buzz_ht.sharabhproject.R;
import com.buzz_ht.sharabhproject.Util.Utils;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.List;

public class RecViewAdapter extends RecyclerView.Adapter<RecViewAdapter.MyViewHolder> {


    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("user");

    Context context;
    List<Bag> list;
//    static int quantity_0=0;
//    static int quantity_1=0;
//    static int quantity_2=0;
//    static int quantity_3=0;

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
        holder.txtQuantity.setText(list.get(position).getCurrentQuantity());


        holder.imageAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = list.get(position).getCurrentQuantity();
                int i = Integer.parseInt(s) + 100;
                list.get(position).setCurrentQuantity(Integer.toString(i));
                FragmentCart.updateCart(list.get(position), Integer.toString(i));
                // Write a message to the database
                String ID = databaseReference.push().getKey();
                databaseReference.child(ID).setValue(list.get(position).getCurrentQuantity()).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(context.getApplicationContext(), "Data Inseted", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(context.getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
                holder.txtQuantity.setText(Integer.toString(i));

            }
        });


        holder.imageRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = list.get(position).getCurrentQuantity();
                int i = Integer.parseInt(s);
                if (i > 0) {
                    i = i - 100;
                    list.get(position).setCurrentQuantity(Integer.toString(i));
                    holder.txtQuantity.setText(Integer.toString(i));
                }


            }
        });

//        holder.imageAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String clicked = list.get(position).getBagName();
//
//
//                for(int i=0; i < list.size();i++){
//                    if(list.get(i).getBagName()==clicked){
//                        list.get(i).setCurrentQuantity(list.get(i).getCurrentQuantity()+100);
//
//
//                    }
//
//                }
//
//                if(list.get(0).getBagName()==clicked){
//                    //Toast.makeText(context.getApplicationContext(), "Bag 1 added", Toast.LENGTH_SHORT).show();
//                    quantity_0= quantity_0+100;
//                    String strQuantity = Integer.toString(quantity_0);
//                    holder.txtQuantity.setText(strQuantity);
//                    FragmentCart.updateCart(list.get(0),strQuantity);
//                }
//                if(list.get(1).getBagName()==clicked){
//                    //Toast.makeText(context.getApplicationContext(), "Bag 2 added", Toast.LENGTH_SHORT).show();
//                    quantity_1= quantity_1+100;
//                    String strQuantity = Integer.toString(quantity_1);
//                    holder.txtQuantity.setText(strQuantity);
//                    FragmentCart.updateCart(list.get(1),strQuantity);
//
//                }
//                if(list.get(2).getBagName()==clicked){
//                    //Toast.makeText(context.getApplicationContext(), "Bag 3 added", Toast.LENGTH_SHORT).show();
//                    quantity_2= quantity_2+100;
//                    String strQuantity = Integer.toString(quantity_2);
//                    holder.txtQuantity.setText(strQuantity);
//                    FragmentCart.updateCart(list.get(2),strQuantity);
//                }
//                if(list.get(3).getBagName()==clicked){
//                    //Toast.makeText(context.getApplicationContext(), "Bag 4 added", Toast.LENGTH_SHORT).show();
//                    quantity_3= quantity_3+100;
//                    String strQuantity = Integer.toString(quantity_3);
//                    holder.txtQuantity.setText(strQuantity);
//                    FragmentCart.updateCart(list.get(3),strQuantity);
//                }
//
//
//
//            }
//        });
//
//        holder.imageRemove.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                String clicked = list.get(position).getBagName();
//
//                if(list.get(0).getBagName()==clicked){
//                    //Toast.makeText(context.getApplicationContext(), "Bag 1 removed", Toast.LENGTH_SHORT).show();
//                    quantity_0= quantity_0-100;
//                    String strQuantity = Integer.toString(quantity_0);
//                    holder.txtQuantity.setText(strQuantity);
//                    FragmentCart.updateCart(list.get(0),strQuantity);
//                }
//                if(list.get(1).getBagName()==clicked){
//                    //Toast.makeText(context.getApplicationContext(), "Bag 2 removed", Toast.LENGTH_SHORT).show();
//                    quantity_1= quantity_1-100;
//                    String strQuantity = Integer.toString(quantity_1);
//                    holder.txtQuantity.setText(strQuantity);
//                    FragmentCart.updateCart(list.get(1),strQuantity);
//                }
//                if(list.get(2).getBagName()==clicked){
//                    //Toast.makeText(context.getApplicationContext(), "Bag 3 removed", Toast.LENGTH_SHORT).show();
//                    quantity_2= quantity_2-100;
//                    String strQuantity = Integer.toString(quantity_2);
//                    holder.txtQuantity.setText(strQuantity);
//                    FragmentCart.updateCart(list.get(2),strQuantity);
//                }
//                if(list.get(3).getBagName()==clicked){
//                    //Toast.makeText(context.getApplicationContext(), "Bag 4 removed", Toast.LENGTH_SHORT).show();
//                    quantity_3= quantity_3-100;
//                    String strQuantity = Integer.toString(quantity_3);
//                    holder.txtQuantity.setText(strQuantity);
//                    FragmentCart.updateCart(list.get(3),strQuantity);
//                }
//
//
//            }
//        });
//


    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtProduct, txtColor, txtDimensions, txtPrice, txtAvail, txtQuantity;
        ImageView image, imageAdd, imageRemove;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtPrice = itemView.findViewById(R.id.txtprice);
            txtProduct = itemView.findViewById(R.id.txtproduct);
            txtColor = itemView.findViewById(R.id.txtcolor);
            txtDimensions = itemView.findViewById(R.id.txtdimensions);
            txtAvail = itemView.findViewById(R.id.txtavail);
            txtQuantity = itemView.findViewById(R.id.txtquantity);

            image = itemView.findViewById(R.id.image);
            imageAdd = itemView.findViewById(R.id.imageadd);
            imageRemove = itemView.findViewById(R.id.imageremove);


        }
    }

}
