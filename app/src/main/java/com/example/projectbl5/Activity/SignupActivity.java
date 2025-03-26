package com.example.projectbl5.Activity;

import static android.content.ContentValues.TAG;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.projectbl5.R;
import com.example.projectbl5.databinding.ActivitySignupBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class SignupActivity extends BaseActivity {
    ActivitySignupBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setVariable();

    }

    private void setVariable() {
        binding.signupBtn.setOnClickListener(view -> {
            String email = binding.emailEdt.getText().toString();
            String password = binding.passwordEdt.getText().toString();
            if (email.isEmpty()) {
                binding.emailEdt.setError("Email is required");
                binding.emailEdt.requestFocus();
                return;
            }
            if (password.isEmpty()) {
                binding.passwordEdt.setError("Password is required");
                binding.passwordEdt.requestFocus();
                return;
            }
            if (password.length() < 6) {
                binding.passwordEdt.setError("Password must be at least 6 characters");
                binding.passwordEdt.requestFocus();
                return;
            }
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignupActivity.this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Log.i(TAG, "onComplete: ");
                        startActivity(new Intent(SignupActivity.this, MainActivity.class));
                    } else {
                        Log.i(TAG, "failure: ", task.getException());
                        Toast.makeText(SignupActivity.this, "Sign up failed", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        });
    }
}