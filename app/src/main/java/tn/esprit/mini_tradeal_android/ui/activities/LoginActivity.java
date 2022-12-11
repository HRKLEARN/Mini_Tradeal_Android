package tn.esprit.mini_tradeal_android.ui.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import tn.esprit.mini_tradeal_android.R;

public class LoginActivity extends AppCompatActivity {
	private static final String TAG = "CustomAuthActivity";
	// Configure Google Sign In
	GoogleSignInOptions gso = new GoogleSignInOptions
			.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
			.requestIdToken(getString(R.string.default_web_client_id))
			.requestEmail()
			.build();
	private String mCustomToken;
	private FirebaseAuth mAuth;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		mAuth = FirebaseAuth.getInstance();
	}
	
	public void onStart() {
		super.onStart();
		FirebaseUser currentUser = mAuth.getCurrentUser();
		updateUI(currentUser);
	}
	// Pour déconnecter un utilisateur, appelez signOut :
	// FirebaseAuth.getInstance().signOut();
	
	/*
	private void startSignIn() {
		// [START sign_in_custom]
		mAuth.signInWithCustomToken(mCustomToken)
				.addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
					@Override
					public void onComplete(@NonNull Task<AuthResult> task) {
						if (task.isSuccessful()) {
							// Sign in success, update UI with the signed-in user's information
							Log.d(TAG, "signInWithCustomToken:success");
							FirebaseUser user = mAuth.getCurrentUser();
							updateUI(user);
						} else {
							// If sign in fails, display a message to the user.
							Log.w(TAG, "signInWithCustomToken:failure", task.getException());
							Toast.makeText(LoginActivity.this, "Authentication failed.",
									Toast.LENGTH_SHORT).show();
							updateUI(null);
						}
					}
				});
		// [END sign_in_custom]
	}
*/
	private void updateUI(FirebaseUser currentUser) {
	}
}