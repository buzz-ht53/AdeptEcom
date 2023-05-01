package com.buzz_ht.sharabhproject.UI;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.buzz_ht.sharabhproject.Fragments.FragmentAbout;
import com.buzz_ht.sharabhproject.Fragments.FragmentCart;
import com.buzz_ht.sharabhproject.Fragments.FragmentHome;
import com.buzz_ht.sharabhproject.Fragments.FragmentShop;
import com.buzz_ht.sharabhproject.R;
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


        binding = ActivityMainBtmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().setTitle("PaperBag Inc.");
        BottomNavigationView navView = findViewById(R.id.nav_view);
        FragmentManager fm5 = getSupportFragmentManager();
        fm5.beginTransaction().replace(R.id.ll, new FragmentHome()).commit();


        // navView.setSelectedItemId(R.id.navigation_Home); // change to whichever id should be default
        // toolbar=findViewById(R.id.toolbar);

//        View decorView = getWindow().getDecorView();
//        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
//                | View.SYSTEM_UI_FLAG_FULLSCREEN;
//        decorView.setSystemUiVisibility(uiOptions);
        navView.setElevation(8);

        navView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {

                    case R.id.navigation_Home:
                        FragmentHome f1 = new FragmentHome();
                        FragmentManager fm1 = getSupportFragmentManager();
                        fm1.beginTransaction().replace(R.id.ll, f1, f1.getTag()).commit();
                        break;

                    case R.id.navigation_Shop:
                        FragmentShop f2 = new FragmentShop();
                        FragmentManager fm2 = getSupportFragmentManager();
                        fm2.beginTransaction().replace(R.id.ll, f2, f2.getTag()).commit();
                        break;

                    case R.id.navigation_Cart:
                        FragmentCart f4 = new FragmentCart();
                        FragmentManager fm4 = getSupportFragmentManager();
                        fm4.beginTransaction().replace(R.id.ll, f4, f4.getTag()).commit();
                        break;

                    case R.id.navigation_About_Us:
                        FragmentAbout f3 = new FragmentAbout();
                        FragmentManager fm3 = getSupportFragmentManager();
                        fm3.beginTransaction().replace(R.id.ll, f3, f3.getTag()).commit();
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