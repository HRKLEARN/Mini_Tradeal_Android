package tn.esprit.mini_tradeal_android.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
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
import tn.esprit.mini_tradeal_android.ui.activities.SignInActivity;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {
	EditText editTextEmail, editTextPassword, editTextPasswordVerify;
	private TextView signin;
	private FirebaseAuth mAuth;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		signin = findViewById(R.id.SigninTextview);
		editTextEmail = findViewById(R.id.editTextEmail);
		editTextPassword = findViewById(R.id.editTextPassword);
		editTextPasswordVerify = findViewById(R.id.editTextPasswordVerify);
		
		findViewById(R.id.buttonSignUp).setOnClickListener(this);
		mAuth = FirebaseAuth.getInstance();
		
		signin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), SignInActivity.class));
				finish();
			}
		});
		
	}
	
	private void registerUser() {
		
		String email = editTextEmail.getText().toString().trim();
		String password = editTextPassword.getText().toString().trim();
		String repeatpassword = editTextPasswordVerify.getText().toString().trim();
		
		if (email.isEmpty()) {
			editTextEmail.setError("Email is required !");
			editTextEmail.requestFocus();
			return;
		}
		
		if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
			editTextEmail.setError("please enter a valid email");
			editTextEmail.requestFocus();
			return;
		}
		if (password.isEmpty()) {
			editTextPassword.setError("Password is required");
			editTextPassword.requestFocus();
			return;
		}
		if (password.length() < 6) {
			editTextPassword.setError("Minimum lenght of password should be 6 ");
			editTextPassword.requestFocus();
			return;
		}
		
		mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
			
			@Override
			public void onComplete(@NonNull @NotNull Task<AuthResult> task) {
				if (task.isSuccessful()) {
					Toast.makeText(getApplicationContext(), "User Registerer Successfully", Toast.LENGTH_SHORT).show();
					
				} else {
					Toast.makeText(getApplicationContext(), "User Registerer Error :" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
					
				}
			}
		});
		
		
	}
	
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
			case R.id.buttonSignUp:
				registerUser();
				break;
			case R.id.SigninTextview:
				startActivity(new Intent(getApplicationContext(), SignInActivity.class));
				break;
			
		}
	}
}