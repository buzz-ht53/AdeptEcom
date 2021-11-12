package com.buzz_ht.sharabhproject;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;

import com.buzz_ht.sharabhproject.databinding.ActivityMainBtmBinding;

public class MainActivityBtm extends AppCompatActivity {

    private ActivityMainBtmBinding binding;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        binding = ActivityMainBtmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);


        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.navigation_Home:
                        FragmentHome f1 = new FragmentHome();
                        FragmentManager fm1 = getSupportFragmentManager();
                        fm1.beginTransaction().replace(R.id.ll,f1,f1.getTag()).commit();
                        break;

                    case R.id.navigation_Shop:
                        FragmentShop f2 = new FragmentShop();
                        FragmentManager fm2 = getSupportFragmentManager();
                        fm2.beginTransaction().replace(R.id.ll,f2, f2.getTag()).commit();
                        break;

                    case R.id.navigation_AboutUs:
                        FragmentAbout f3 = new FragmentAbout();
                        FragmentManager fm3 = getSupportFragmentManager();
                        fm3.beginTransaction().replace(R.id.ll,f3,f3.getTag()).commit();
                        break;

                    case R.id.navigation_Contact:
                        FragmentContact f4 = new FragmentContact();
                        FragmentManager fm4 = getSupportFragmentManager();
                        fm4.beginTransaction().replace(R.id.ll,f4,f4.getTag()).commit();
                        break;

                }

                return false;
            }
        });


    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//         super.onCreateOptionsMenu(menu);
//
//            getMenuInflater().inflate(R.menu.main_menu,menu);
//
//        return true;
//    }
}