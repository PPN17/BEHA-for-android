package com.example.android.logindemo.activity;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.logindemo.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import org.apache.commons.lang3.StringUtils;

public class PasswordActivity extends AppCompatActivity {

    private EditText passwordEmail;
    private Button resetPassword;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);

        passwordEmail = (EditText) findViewById(R.id.etPasswordEmail);
        resetPassword = (Button) findViewById(R.id.btnPasswordReset);
        firebaseAuth = FirebaseAuth.getInstance();

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userEmail = passwordEmail.getText().toString().trim();

                if (StringUtils.isBlank(userEmail)) {
                    Toast.makeText(PasswordActivity.this, "Please enter your registered email ID", Toast.LENGTH_SHORT).show();
                } else {
                    firebaseAuth.sendPasswordResetEmail(userEmail).addOnCompleteListener(getFirebaseAuthOnCompleteListener());
                }
            }
        });

    }

    private OnCompleteListener<Void> getFirebaseAuthOnCompleteListener() {
        return new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(PasswordActivity.this, "Password reset email sent!", Toast.LENGTH_SHORT).show();
                    finish();
                    startActivity(new Intent(PasswordActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(PasswordActivity.this, "Error in sending password reset email", Toast.LENGTH_SHORT).show();
                }
            }
        };
    }

}
