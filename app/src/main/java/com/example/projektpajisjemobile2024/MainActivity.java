package com.example.projektpajisjemobile2024;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView hometext;
    Button HomeLogin,singupHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        hometext=findViewById(R.id.hometext);
        HomeLogin=findViewById(R.id.loginHome);
        singupHome=findViewById(R.id.signupHome);

        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation slideIn = AnimationUtils.loadAnimation(this, R.anim.slide_in_left);

        hometext.setVisibility(View.VISIBLE);
        hometext.startAnimation(fadeIn);
        HomeLogin.setVisibility(View.VISIBLE);
        HomeLogin.startAnimation(slideIn);
        singupHome.setVisibility(View.VISIBLE);
        singupHome.startAnimation(slideIn);

        singupHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Signup.class);
                startActivity(i);
            }
        });

        HomeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,Login.class);
                startActivity(i);
            }
        });
    }
}