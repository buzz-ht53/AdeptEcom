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




public class LoginActivity extends AppCompatActivity {

    EditText etemail,etpassword;
    Button buttonlogin;
    FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();


        buttonlogin.setOnClickListener(new View.OnClickListener() {
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


                firebaseAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Login successful", Toast.LENGTH_LONG).show();
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
        buttonlogin=findViewById(R.id.imageView);
        firebaseAuth= FirebaseAuth.getInstance();

    }

    public void GoToSignUp(View view) {

        startActivity(new Intent(getApplicationContext(),SignUpActivity.class));


    }
}