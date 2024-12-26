package com.example.projektpajisjemobile2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Signup extends AppCompatActivity {
    TextView goLogin;
    EditText FullName,UserName,EmailAddressS,PasswordS;
    Button SignUpS;
    DBconnect DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        goLogin=findViewById(R.id.goLogin);
        FullName=findViewById(R.id.FullName);
        UserName=findViewById(R.id.UserName);
        EmailAddressS=findViewById(R.id.EmailAddressS);
        PasswordS=findViewById(R.id.PasswordS);
        SignUpS=findViewById(R.id.SignUpS);
        DB = new DBconnect(this);

        SignUpS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = UserName.getText().toString();
                String fname = FullName.getText().toString();
                String email = EmailAddressS.getText().toString();
                String pass = PasswordS.getText().toString();



                if(user.isEmpty()||pass.isEmpty()||fname.isEmpty()||email.isEmpty())
                    Toast.makeText(Signup.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else if(!PasswordValidacion.isValidPassword(pass)) {
                    Toast.makeText(Signup.this, "Password must contain at least 1 number, 1 special character, and be 8 characters long.", Toast.LENGTH_LONG).show();
                }
                else{
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user, fname,email,pass);
                            if(insert==true){
                                Toast.makeText(Signup.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent i =new Intent(Signup.this, Verification.class);
                                startActivity(i);
                            }else{
                                Toast.makeText(Signup.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(Signup.this, "User already exists! please login", Toast.LENGTH_SHORT).show();
                        }
                    }

                }
        });


        goLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(Signup.this,Login.class);
                startActivity(i);
            }
        });
    }
}