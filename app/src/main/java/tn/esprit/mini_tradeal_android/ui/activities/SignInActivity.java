package tn.esprit.mini_tradeal_android.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import org.jetbrains.annotations.NotNull;

import tn.esprit.mini_tradeal_android.R;

public class SignInActivity extends AppCompatActivity {
	EditText editTextEmail, editTextPassword;
	FirebaseAuth mAuth;
	private TextView forgotpassword, signup;
	private Button button_signin;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		signup = findViewById(R.id.SignupTextview);
		button_signin = findViewById(R.id.buttonLogin);
		editTextEmail = findViewById(R.id.EmailEditText);
		editTextPassword = findViewById(R.id.PasswordEditText);
		forgotpassword = findViewById(R.id.ForgotPasswordTextview);
		mAuth = FirebaseAuth.getInstance();
		
		
		signup.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), SignupActivity.class));
				finish();
			}
		});
		button_signin.setOnClickListener(view -> {
			loginUser();
		});
		
	}
	
	private void loginUser() {
		String email = editTextEmail.getText().toString().trim();
		String password = editTextPassword.getText().toString().trim();
		
		if (email.isEmpty()) {
			editTextEmail.setError("Email is required !");
			editTextEmail.requestFocus();
			
		}
		
		if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
			editTextEmail.setError("please enter a valid email");
			editTextEmail.requestFocus();
			
		}
		if (password.isEmpty()) {
			editTextPassword.setError("Password is required");
			editTextPassword.requestFocus();
			
		} else {
			mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
				
				@Override
				public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
					if (task.isSuccessful()) {
						Toast.makeText(getApplicationContext(), "User Logged Successfully", Toast.LENGTH_SHORT).show();
						startActivity(new Intent(getApplicationContext(), navigationActivity.class));
						
					} else {
						Toast.makeText(getApplicationContext(), "Login Error :" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
						
					}
				}
			});
		}
		
	}
}