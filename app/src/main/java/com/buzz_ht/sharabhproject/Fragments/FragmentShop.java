package com.buzz_ht.sharabhproject.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.buzz_ht.sharabhproject.Adapters.RecViewAdapter;
import com.buzz_ht.sharabhproject.Model.Bag;
import com.buzz_ht.sharabhproject.R;

import java.util.ArrayList;
import java.util.List;


public class FragmentShop extends Fragment {

    RecyclerView recyclerView;
    RecViewAdapter recViewAdapter;
    List<Bag> list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shop, container, false);


        recyclerView = view.findViewById(R.id.recview);

        list = new ArrayList<>();

        list.add(new Bag("Plain bag", "100 * 250 * 350 mm", "Brown", "N/A", "Available", R.drawable.brown_plain, "0"));

        list.add(new Bag("Plain bag", "125 * 300 * 400 mm", "Brown", "N/A", "Available", R.drawable.brown_plain, "0"));

        list.add(new Bag("Plain bag", "175 * 300 * 250 mm", "Brown", "N/A", "Available", R.drawable.brown_plain, "0"));

        list.add(new Bag("Plain bag", "200 * 350 * 250 mm", "Brown", "N/A", "Available", R.drawable.brown_plain, "0"));

        recViewAdapter = new RecViewAdapter(getContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(recViewAdapter);

        return view;
    }
}