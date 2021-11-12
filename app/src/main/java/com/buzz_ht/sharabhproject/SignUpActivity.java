package com.buzz_ht.sharabhproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {


    EditText etemail,etpassword;
    Button signup;
    FirebaseAuth firebaseAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        init();

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String email = etemail.getText().toString().trim();
                String password = etpassword.getText().toString().trim();

                if(email.isEmpty()){
                    etemail.setError("Email can't be blank");
                    etemail.requestFocus();
                    return;
                }
                if(password.isEmpty()){
                    etpassword.setError("Password can't be blank");
                    etpassword.requestFocus();
                    return;
                }


                firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        //TODO Replace Snackbar with Toast

                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"SignUp successful", Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getApplicationContext(),MainActivityBtm.class);
                            startActivity(i);
                            finish();
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });


    }

    void init(){

        etemail=findViewById(R.id.editText2);
        etpassword=findViewById(R.id.editText);
        signup=findViewById(R.id.imageView);
        firebaseAuth= FirebaseAuth.getInstance();

    }


    public void GoToLogin(View view) {
        startActivity(new Intent(getApplicationContext(),LoginActivity.class));
    }
}