package tn.esprit.mini_tradeal_android.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import tn.esprit.mini_tradeal_android.entity.OnBoardingItem;
import tn.esprit.mini_tradeal_android.R;

public class OnboardingAdapter extends RecyclerView.Adapter<OnboardingAdapter.OnboardingViewHolder> {
	
	private final List<OnBoardingItem> onBoardingItems;
	
	public OnboardingAdapter(List<OnBoardingItem> onBoardingItems) {
		this.onBoardingItems = onBoardingItems;
	}
	
	@NonNull
	@NotNull
	@Override
	public OnboardingViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
		return new OnboardingViewHolder(
				LayoutInflater.from(parent.getContext()).inflate(
						R.layout.item_container_onboarding, parent, false
				)
		);
	}
	
	@Override
	public void onBindViewHolder(@NonNull @NotNull OnboardingAdapter.OnboardingViewHolder holder, int position) {
		holder.setOnboardingData(onBoardingItems.get(position));
	}
	
	@Override
	public int getItemCount() {
		return onBoardingItems.size();
	}
	
	static class OnboardingViewHolder extends RecyclerView.ViewHolder {
		private final TextView textTitle;
		private final TextView textDescription;
		private final ImageView imageOnboarding;
		
		public OnboardingViewHolder(@NonNull @NotNull View itemView) {
			super(itemView);
			textTitle = itemView.findViewById(R.id.textTitle);
			textDescription = itemView.findViewById(R.id.textDescription);
			imageOnboarding = itemView.findViewById(R.id.imageOnbording);
			
		}
		
		void setOnboardingData(OnBoardingItem onBoardingItem) {
			textTitle.setText(onBoardingItem.getTitle());
			textDescription.setText(onBoardingItem.getDescription());
			imageOnboarding.setImageResource(onBoardingItem.getImage());
		}
		
	}
}
