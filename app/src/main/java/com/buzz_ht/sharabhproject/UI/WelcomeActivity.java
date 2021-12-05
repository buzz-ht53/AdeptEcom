package com.buzz_ht.sharabhproject.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.buzz_ht.sharabhproject.R;
import com.buzz_ht.sharabhproject.UI.LoginActivity;
import com.buzz_ht.sharabhproject.UI.MainActivityBtm;
import com.google.firebase.auth.FirebaseAuth;

public class WelcomeActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        getSupportActionBar().hide();


        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivityBtm.class));
            finish();
        }



    }




    public void GoToLogin(View view) {

        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();


    }
}