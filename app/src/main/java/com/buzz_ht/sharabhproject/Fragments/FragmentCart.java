package com.buzz_ht.sharabhproject.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.buzz_ht.sharabhproject.Adapters.RecViewAdapter;
import com.buzz_ht.sharabhproject.Adapters.RecViewAdapterCart;
import com.buzz_ht.sharabhproject.Model.Bag;
import com.buzz_ht.sharabhproject.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentCart extends Fragment {

    public static void updateCart(Bag bag, String quantity) {
        bag.setCurrentQuantity(quantity);
        list.add(bag);
    }

    RecyclerView recyclerView;
    RecViewAdapterCart recViewAdapterCart;
    static List list = new ArrayList<Bag>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        list = new ArrayList<Bag>();
        recyclerView = view.findViewById(R.id.recview_cart);
        recViewAdapterCart = new RecViewAdapterCart(getContext(), new RecViewAdapterCart().list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recViewAdapterCart);


        return view;
    }
}