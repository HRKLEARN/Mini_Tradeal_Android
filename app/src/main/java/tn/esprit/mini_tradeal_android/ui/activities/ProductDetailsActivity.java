package tn.esprit.mini_tradeal_android.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import tn.esprit.mini_tradeal_android.R;
import tn.esprit.mini_tradeal_android.models.Product;

public class ProductDetailsActivity extends AppCompatActivity {
	
	private TextView productName, price, description, type, category, location, rating, addFavorite;
	private ImageView productImage;
	private Product product;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_product_details);
		initView();
	}
	
	private void initView() {
		productName = findViewById(R.id.tvProductTitle);
//		description = view.findViewById(R.id.de);
		type = findViewById(R.id.tvType);
		category = findViewById(R.id.tvCategory);
		location = findViewById(R.id.tvLocation);
		rating = findViewById(R.id.tvRating);
		productImage = findViewById(R.id.ivProductImg);
		addFavorite = findViewById(R.id.addFavoriteBtn);
		
	}
}