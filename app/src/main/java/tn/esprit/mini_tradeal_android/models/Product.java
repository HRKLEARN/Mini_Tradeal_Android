package tn.esprit.mini_tradeal_android.models;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Product {
	public static final Parcelable.Creator<Product> CREATOR = new Parcelable.Creator<Product>() {
		@Override
		public Product createFromParcel(Parcel in) {
			return new Product(in);
		}
		
		@Override
		public Product[] newArray(int size) {
			return new Product[size];
		}
	};
	private String productName;
	private String description;
	private String author;
	private String imgUrl;
	private String productType;
	@PrimaryKey(autoGenerate = true)
	private Long uid;
	private String location;
	private String category;
	private int price;
	private int distance;
	private float rating;
	private int DrawableResource;
	
	public Product() {
	}
	
	private String date;
	
	public Product(String productName, String description, String author, String imgUrl, String productType, String category, String location, String date, int price, int distance, float rating, int drawableResource) {
		
		this.productName = productName;
		this.description = description;
		this.author = author;
		this.imgUrl = imgUrl;
		this.productType = productType;
		this.category = category;
		this.location = location;
		this.date = date;
		this.price = price;
		this.distance = distance;
		this.rating = rating;
		this.DrawableResource = drawableResource;
	}
	
	protected Product(Parcel in) {
		uid = in.readLong();
		productName = in.readString();
		description = in.readString();
		productType = in.readString();
		category = in.readString();
		location = in.readString();
		date = in.readString();
		author = in.readString();
		imgUrl = in.readString();
		price = in.readInt();
		rating = in.readInt();
	}
	
	@Ignore
	public Product(int drawableResource) {
		this.DrawableResource = drawableResource;
	}
	
	
	public Product(Long uid, String productName, String description, String author, String imgUrl, String productType, String category, String location, String date, int price, int distance, float rating, int drawableResource) {
		this.uid = uid;
		this.productName = productName;
		this.description = description;
		this.author = author;
		this.imgUrl = imgUrl;
		this.productType = productType;
		this.category = category;
		this.location = location;
		this.date = date;
		this.price = price;
		this.distance = distance;
		this.rating = rating;
		DrawableResource = drawableResource;
	}
	
	public Long getUid() {
		return uid;
	}
	
	public void setUid(Long uid) {
		this.uid = uid;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getImgUrl() {
		return imgUrl;
	}
	
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	public String getProductType() {
		return productType;
	}
	
	public void setProductType(String productType) {
		this.productType = productType;
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getDate() {
		return date;
	}
	
	public void setDate(String date) {
		this.date = date;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public float getRating() {
		return rating;
	}
	
	public void setRating(float rating) {
		this.rating = rating;
	}
	
	public int getDrawableResource() {
		return DrawableResource;
	}
	
	public void setDrawableResource(int drawableResource) {
		DrawableResource = drawableResource;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
}
