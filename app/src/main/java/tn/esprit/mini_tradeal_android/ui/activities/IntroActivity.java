package tn.esprit.mini_tradeal_android.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.mini_tradeal_android.models.OnBoardingItem;
import tn.esprit.mini_tradeal_android.ui.adapters.OnboardingAdapter;
import tn.esprit.mini_tradeal_android.R;

public class IntroActivity extends AppCompatActivity {
	
	private OnboardingAdapter onboardingAdapter;
	private LinearLayout LayoutOnboardingIndicators;
	private MaterialButton buttonOnboardingAction;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_intro);
		LayoutOnboardingIndicators = findViewById(R.id.layoutOnboardingIndicators);
		buttonOnboardingAction = findViewById(R.id.buttonOnboardingAction);
		setupOnboardingItems();
		ViewPager2 onboardingViewPager = findViewById(R.id.onboardingViewPager);
		onboardingViewPager.setAdapter(onboardingAdapter);
		setupOnboardingIndicators();
		setCurrentOnboardingIndicator(0);
		onboardingViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
			@Override
			public void onPageSelected(int position) {
				super.onPageSelected(position);
				setCurrentOnboardingIndicator(position);
			}
		});
		
		buttonOnboardingAction.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (onboardingViewPager.getCurrentItem() + 1 < onboardingAdapter.getItemCount()) {
					onboardingViewPager.setCurrentItem(onboardingViewPager.getCurrentItem() + 1);
				} else {
					startActivity(new Intent(getApplicationContext(), MainActivity.class));
					finish();
				}
			}
		});
	}
	
	private void setupOnboardingItems() {
		List<OnBoardingItem> onBoardingItems = new ArrayList<>();
		OnBoardingItem itemMakeDeal = new OnBoardingItem();
		itemMakeDeal.setTitle("Make a deal and\n" +
				"save your money!");
		itemMakeDeal.setDescription("It's your time to shine.");
		itemMakeDeal.setImage(R.drawable.image1);
		OnBoardingItem itemStartTrade = new OnBoardingItem();
		
		itemStartTrade.setTitle("Stop Buying\n" +
				"Start Trading!");
		itemStartTrade.setDescription("Follow the best economical way.");
		itemStartTrade.setImage(R.drawable.image2);
		OnBoardingItem itemMakeChange = new OnBoardingItem();
		
		itemMakeChange.setTitle("Time to make\n" +
				"a change!");
		itemMakeChange.setDescription("Join Tradeal and be the change.");
		itemMakeChange.setImage(R.drawable.image3);
		onBoardingItems.add(itemMakeDeal);
		onBoardingItems.add(itemStartTrade);
		onBoardingItems.add(itemMakeChange);
		onboardingAdapter = new OnboardingAdapter(onBoardingItems);
	}
	
	private void setupOnboardingIndicators() {
		ImageView[] indicators = new ImageView[onboardingAdapter.getItemCount()];
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
				ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
		);
		layoutParams.setMargins(8, 0, 8, 0);
		for (int i = 0; i < indicators.length; i++) {
			indicators[i] = new ImageView(getApplicationContext());
			indicators[i].setImageDrawable(ContextCompat.getDrawable(
					getApplicationContext(),
					R.drawable.onboarding_indicator_inactive
			));
			indicators[i].setLayoutParams(layoutParams);
			LayoutOnboardingIndicators.addView(indicators[i]);
		}
	}
	
	private void setCurrentOnboardingIndicator(int index) {
		int childCount = LayoutOnboardingIndicators.getChildCount();
		for (int i = 0; i < childCount; i++) {
			ImageView imageView = (ImageView) LayoutOnboardingIndicators.getChildAt(i);
			if (i == index) {
				imageView.setImageDrawable(
						ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_active)
				);
				
			} else {
				imageView.setImageDrawable(
						ContextCompat.getDrawable(getApplicationContext(), R.drawable.onboarding_indicator_inactive)
				);
			}
			
		}
		if (index == onboardingAdapter.getItemCount() - 1) {
			buttonOnboardingAction.setText("Start");
		} else {
			buttonOnboardingAction.setText("Next");
		}
	}
}