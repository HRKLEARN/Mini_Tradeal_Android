package tn.esprit.mini_tradeal_android.models;


import java.util.List;

public class Group {
	private int id;
	private String groupName;
	private String groupDescription;
	private String author;
	private String category;
	private String urlGroupImage;
	private int DrawableResource;
	private List<User> members;
	
	public Group() {
	}
	
	public Group(int id, String groupName, String author, String category) {
		this.id = id;
		this.groupName = groupName;
		this.author = author;
		this.category = category;
	}
	
	
	public Group(int id, String groupName, String groupDescription, String author, String category, String urlGroupImage, List<User> members) {
		this.id = id;
		this.groupName = groupName;
		this.groupDescription = groupDescription;
		this.author = author;
		this.category = category;
		this.urlGroupImage = urlGroupImage;
		this.members = members;
	}
	
	public Group(int drawableResource) {
		DrawableResource = drawableResource;
	}
	
	public int getDrawableResource() {
		return DrawableResource;
	}
	
	public void setDrawableResource(int drawableResource) {
		DrawableResource = drawableResource;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getGroupName() {
		return groupName;
	}
	
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	
	public String getGroupDescription() {
		return groupDescription;
	}
	
	public void setGroupDescription(String groupDescription) {
		this.groupDescription = groupDescription;
	}
	
	public String getUrlGroupImage() {
		return urlGroupImage;
	}
	
	public void setUrlGroupImage(String urlGroupImage) {
		this.urlGroupImage = urlGroupImage;
	}
	
	public List<User> getMembers() {
		return members;
	}
	
	public void setMembers(List<User> members) {
		this.members = members;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
}
