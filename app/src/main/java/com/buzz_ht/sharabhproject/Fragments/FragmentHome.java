package com.buzz_ht.sharabhproject.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.buzz_ht.sharabhproject.R;


public class FragmentHome extends Fragment {

    Button btnContactUs;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        btnContactUs = view.findViewById(R.id.btncontactus);
        btnContactUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentAbout f3 = new FragmentAbout();
                FragmentManager fm3 = getActivity().getSupportFragmentManager();
                fm3.beginTransaction().replace(R.id.ll, f3, f3.getTag()).commit();
            }
        });


        return view;
    }
}