package com.example.projektpajisjemobile2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class forget_password extends AppCompatActivity {

    EditText emailForget;
    Button resbutton;
    TextView backlogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_forget_password);
        emailForget=findViewById(R.id.emailForget);
        resbutton=findViewById(R.id.resbutton);
        backlogin=findViewById(R.id.backlogin);

        backlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(forget_password.this, Login.class);
                startActivity(i);
            }
        });

    }
}