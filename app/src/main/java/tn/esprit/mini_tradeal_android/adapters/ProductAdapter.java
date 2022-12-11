package tn.esprit.mini_tradeal_android.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import tn.esprit.mini_tradeal_android.entity.Product;
import tn.esprit.mini_tradeal_android.R;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    
    List<Product> mData;
    
    public ProductAdapter(List<Product> mData) {
        this.mData = mData;
    }
    
    @NonNull
    @NotNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list_biens, parent, false);
        return new ProductViewHolder(view);
    }
    
    @Override
    public void onBindViewHolder(@NonNull @NotNull ProductAdapter.ProductViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext()).
                load(mData.get(position).getDrawableResource())
                .transform(new CenterCrop(), new RoundedCorners(16))
                .into(holder.productImg);
        holder.ratingBar.setRating((float) 4.5);
    }
    
    @Override
    public int getItemCount() {
        return mData.size();
    }
    
    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        
        TextView title, description, author, Type, location, date, price;
        RatingBar ratingBar;
        ImageView productImg;
        
        
        public ProductViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            
            title = itemView.findViewById(R.id.productTitle);
            description = itemView.findViewById(R.id.description);
            author = itemView.findViewById(R.id.authorname);
            Type = itemView.findViewById(R.id.typeProduct);
            location = itemView.findViewById(R.id.Location);
            date = itemView.findViewById(R.id.DateCreation);
            price = itemView.findViewById(R.id.PrixCookie);
            ratingBar = itemView.findViewById(R.id.RatingBar);
            productImg = itemView.findViewById(R.id.productImg);
            
        }
    }
    
    
}
