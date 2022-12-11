package tn.esprit.mini_tradeal_android.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import tn.esprit.mini_tradeal_android.R;

public class MainActivity extends AppCompatActivity {
	
	ImageView image;
	Button button_sign, button_register;
	LinearLayout linearLayout;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_mainn);
		
		button_sign = findViewById(R.id.button_sign);
		button_register = findViewById(R.id.button_register);
		
		button_sign.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), SignInActivity.class));
				finish();
			}
		});
		
		button_register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(getApplicationContext(), SignupActivity.class));
				finish();
			}
		});
	}
	
	
}