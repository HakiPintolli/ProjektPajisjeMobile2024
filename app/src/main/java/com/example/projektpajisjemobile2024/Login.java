package com.example.projektpajisjemobile2024;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Login extends AppCompatActivity {
    TextView goForget;
    EditText UserName ,Password;
    Button login,signup;
    DBconnect DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        UserName=findViewById(R.id.UserName);
        Password=findViewById(R.id.editTextNumberPassword);
        goForget=findViewById(R.id.goForget);
        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);
        DB = new DBconnect(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String user = UserName.getText().toString();
                String pass = Password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(Login.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user, pass);
                    if(checkuserpass==true){
                        Toast.makeText(Login.this, "Login successfull", Toast.LENGTH_SHORT).show();
//                        NotificationCompat.Builder builder= new NotificationCompat.Builder(Login.this,"Notifacion");
//                        builder.setContentTitle("Notification");
//                        builder.setContentText("Your successfully loged in");
//                        builder.setAutoCancel(true);
//
//                        NotificationManagerCompat managerCompat=NotificationManagerCompat.from(Login.this);
//                        managerCompat.notify(1,builder.build());
                        Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(Login.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        goForget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login.this,forget_password.class);
                startActivity(i);
            }
        });


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i= new Intent(Login.this,Signup.class);
                startActivity(i);

            }
        });

    }
}