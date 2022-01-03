package com.example.cahpintar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class register extends AppCompatActivity {

    EditText registerUserName, registerEmail, registerPassword, registerConPass;
    Button btnRegister;
    TextView pageLogin;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerUserName = findViewById(R.id.registerUserName);
        registerEmail = findViewById(R.id.registerEmail);
        registerPassword = findViewById(R.id.registerPassword);
        registerConPass = findViewById(R.id.registerConPass);
        btnRegister = findViewById(R.id.btnRegister);
        pageLogin = findViewById(R.id.pageLogin);

        fAuth = FirebaseAuth.getInstance();

        pageLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),login.class));
                finish();
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ekstrak data dari form
                String UserName = registerUserName.getText().toString();
                String email = registerEmail.getText().toString();
                String password = registerPassword.getText().toString();
                String conPass = registerConPass.getText().toString();

                if(UserName.isEmpty()){
                    registerUserName.setError("User Name Harus Diisi");
                    return;
                }
                if(email.isEmpty()){
                    registerEmail.setError("Email Harus Diisi");
                    return;
                }
                if(password.isEmpty()){
                    registerPassword.setError("Password Harus Diisi");
                    return;
                }
                if(conPass.isEmpty()){
                    registerConPass.setError("Retype-Pass Harus Diisi");
                    return;
                }
                if(!password.equals(conPass)){
                    registerConPass.setError("Password tidak sama");
                    return;
                }

                Toast.makeText(register.this, "Register Berhasil", Toast.LENGTH_SHORT).show();
                fAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        startActivity(new Intent(getApplicationContext(),MenuMembaca.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(register.this, "", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
}