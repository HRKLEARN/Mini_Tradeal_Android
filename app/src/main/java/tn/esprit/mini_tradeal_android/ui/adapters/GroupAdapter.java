package tn.esprit.mini_tradeal_android.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.google.android.material.imageview.ShapeableImageView;

import java.util.List;

import tn.esprit.mini_tradeal_android.R;
import tn.esprit.mini_tradeal_android.models.Group;


public class GroupAdapter extends RecyclerView.Adapter<GroupAdapter.GroupViewHolder> {
	List<Group> data;
	
	public GroupAdapter(List<Group> data) {
		this.data = data;
	}
	
	@NonNull
	@Override
	public GroupAdapter.GroupViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		View view = LayoutInflater.from(parent.getContext())
				.inflate(R.layout.group_list_item, parent, false);
		return new GroupViewHolder(view);
	}
	
	@Override
	public void onBindViewHolder(@NonNull GroupAdapter.GroupViewHolder holder, int position) {
		Group group = data.get(position);
		holder.groupName.setText(group.getGroupName());
		holder.groupDescription.setText(group.getGroupDescription());
		holder.groupImage.setImageResource(group.getDrawableResource());
		Glide.with(holder.itemView.getContext()).
				load(data.get(position).getUrlGroupImage())
				.transform(new CenterCrop(), new RoundedCorners(16))
				.into(holder.groupImage);
	}
	
	@Override
	public int getItemCount() {
		return data.size();
	}
	
	public class GroupViewHolder extends RecyclerView.ViewHolder {
		TextView groupName, groupDescription, owner, category;
		ShapeableImageView groupImage;
		
		public GroupViewHolder(@NonNull View itemView) {
			super(itemView);
			groupName = itemView.findViewById(R.id.tvGroupName);
			groupDescription = itemView.findViewById(R.id.tvGroupDescription);
			owner = itemView.findViewById(R.id.tvOwnerName);
			category = itemView.findViewById(R.id.tvCategory);
			groupImage = itemView.findViewById(R.id.groupImg);
			
		}
	}
}
