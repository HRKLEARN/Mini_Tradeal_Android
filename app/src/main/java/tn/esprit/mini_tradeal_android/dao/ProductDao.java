package tn.esprit.mini_tradeal_android.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import tn.esprit.mini_tradeal_android.entity.Product;

@Dao

public interface ProductDao {
	
	@Query("SELECT * FROM product_table")
	List<Product> getAll();
	
	@Query("SELECT * FROM product_table WHERE uid IN (:ProductIds)")
	List<Product> loadAllByIds(int[] ProductIds);
	
	@Query("SELECT * FROM product_table WHERE product_name == :productName LIMIT 1")
	Product findByName(String productName);
	
	@Insert
	void insertAll(Product... products);
	
	@Insert
	void insertOne(Product product);
	
	@Delete
	void delete(Product product);
	
	@Update
	void update(Product product);
}
