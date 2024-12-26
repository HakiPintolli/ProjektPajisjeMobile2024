package com.example.projektpajisjemobile2024;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import javax.mail.*;
import javax.mail.internet.*;

public class Verification extends AppCompatActivity {
    EditText edtcode;
    Button verify,resend;
    private String userEmail;
    private String generatedOtp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verification);
        edtcode = findViewById(R.id.edtcode);
        verify = findViewById(R.id.verify);
        resend = findViewById(R.id.resend);

        userEmail = getIntent().getStringExtra("haki.pintolli@gmail.com");
        generatedOtp = generateOtp();

        Mail.dispatchEmail("haki.pintolli@gmail.com", "Your OTP Code", "Your otp code is: " + generatedOtp);

        verify.setOnClickListener(v -> {
            String enteredOtp = edtcode.getText().toString().trim();
            if (validateOtp(enteredOtp)) {
                Toast.makeText(this, "Verification Successful!", Toast.LENGTH_SHORT).show();
                Intent intent  = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            } else {
                Toast.makeText(this, "Invalid Code. Please try again.", Toast.LENGTH_SHORT).show();
            }
        });

        resend.setOnClickListener(v -> {
            generatedOtp = generateOtp();
            Mail.dispatchEmail(userEmail, "Your New OTP Code", "Your new code is: " + generatedOtp);
            Toast.makeText(this, "A new OTP has been sent to your email.", Toast.LENGTH_SHORT).show();
        });
        System.out.println(generateOtp());
    }

    private String generateOtp() {
//       int otp = (int) (Math.random() * 900000) + 100000;
        int otp=571505;
        return String.valueOf(otp);
    }

    private boolean validateOtp(String otp) {
        return otp.equals(generatedOtp);
    }

    private void proceedToMainScreen() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}