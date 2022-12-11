package tn.esprit.mini_tradeal_android.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Date;

@Entity(tableName = "product_table")
public class Product {
	@PrimaryKey(autoGenerate = true)
	private int uid;
	@ColumnInfo(name = "product_name")
	private String productName;
	@ColumnInfo(name = "description")
	private String description;
	@ColumnInfo(name = "author")
	private String author;
	@ColumnInfo(name = "imgUrl")
	private String imgUrl;
	@ColumnInfo(name = "product_type")
	private String productType;
	@ColumnInfo(name = "location")
	private String location;
	@ColumnInfo(name = "date")
	private Date date;
	@ColumnInfo(name = "price")
	private int price;
	@ColumnInfo(name = "distance")
	private int distance;
	@ColumnInfo(name = "rating")
	private float rating;
	@ColumnInfo(name = "drawableResource")
	private int DrawableResource;
	
	public Product() {
	}
	
	public Product(String productName, String description, String author, String imgUrl, String productType, String location, Date date, int price, int distance, float rating, int drawableResource) {
		this.productName = productName;
		this.description = description;
		this.author = author;
		this.imgUrl = imgUrl;
		this.productType = productType;
		this.location = location;
		this.date = date;
		this.price = price;
		this.distance = distance;
		this.rating = rating;
		this.DrawableResource = drawableResource;
	}
	
	
	@Ignore
	public Product(int drawableResource) {
		this.DrawableResource = drawableResource;
	}
	
	
	public Product(int uid, String productName, String description, String author, String imgUrl, String productType, String location, Date date, int price, int distance, float rating, int drawableResource) {
		this.uid = uid;
		this.productName = productName;
		this.description = description;
		this.author = author;
		this.imgUrl = imgUrl;
		this.productType = productType;
		this.location = location;
		this.date = date;
		this.price = price;
		this.distance = distance;
		this.rating = rating;
		this.DrawableResource = drawableResource;
	}
	
	public int getUid() {
		return uid;
	}
	
	public void setUid(int uid) {
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
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
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
}
