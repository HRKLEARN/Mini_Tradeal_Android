package tn.esprit.mini_tradeal_android.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.jetbrains.annotations.NotNull;

import tn.esprit.mini_tradeal_android.ui.fragments.FavoriteFragment;
import tn.esprit.mini_tradeal_android.ui.fragments.NewtradeFragment;
import tn.esprit.mini_tradeal_android.ui.fragments.ProfilFragment;
import tn.esprit.mini_tradeal_android.R;
import tn.esprit.mini_tradeal_android.ui.fragments.GroupFragment;
import tn.esprit.mini_tradeal_android.ui.fragments.HomeFragment;

public class navigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
	
	private final BottomNavigationView.OnNavigationItemSelectedListener navListener =
			item -> {
				Fragment selectedFragment = null;
				switch (item.getItemId()) {
					case R.id.home:
						selectedFragment = new HomeFragment();
						break;
					case R.id.Groups:
						selectedFragment = new GroupFragment();
						break;
					case R.id.fab:
						selectedFragment = new NewtradeFragment();
						break;
					case R.id.Favorite:
						selectedFragment = new FavoriteFragment();
						break;
					case R.id.profil:
						selectedFragment = new ProfilFragment();
						break;
				}
				
				return loadFragment(selectedFragment);
			};
	private FirebaseAuth mAuth;
	private NavController navController;
	private DrawerLayout drawerLayout;
	private ActionBarDrawerToggle toggle;
	private NavigationView navigationView;
	private GroupFragment fragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_navigation);
		//loading the default fragment
		loadFragment(new HomeFragment());
		BottomNavigationView bottomNavigation = findViewById(R.id.bottomNavigationView);
		bottomNavigation.setBackground(null);
		bottomNavigation.setOnNavigationItemSelectedListener(navListener);
		bottomNavigation.getMenu().getItem(2).setEnabled(false);
		FloatingActionButton fab = findViewById(R.id.fab);
		/*fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				FragmentManager fragmentManager = getSupportFragmentManager();
				FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
				fragmentTransaction.replace(R.id.flFragment.);
				fragmentTransaction.commit();
			}
		});*/
		
		
		drawerLayout = findViewById(R.id.drawerlayout);
		navigationView = findViewById(R.id.navigation_view);
		
		toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);
		
		drawerLayout.addDrawerListener(toggle);
		toggle.syncState();
		
		navigationView.setNavigationItemSelectedListener(this);
		
		mAuth = FirebaseAuth.getInstance();
		
	}
	
	@Override
	protected void onStart() {
		super.onStart();
		FirebaseUser user = mAuth.getCurrentUser();
		if (user == null) {
			startActivity(new Intent(navigationActivity.this, LoginActivity.class));
		}
		
	}
	
	private boolean loadFragment(Fragment fragment) {
		//switching fragment
		if (fragment != null) {
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.flFragment, fragment)
					.commit();
			return true;
		}
		return false;
	}
	
	@Override
	public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
		if (item.getItemId() == R.id.logout) {
			Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show();
		}
		return false;
	}
}