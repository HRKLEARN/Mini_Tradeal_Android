package tn.esprit.mini_tradeal_android.service.interfaces;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import tn.esprit.mini_tradeal_android.models.Group;
import tn.esprit.mini_tradeal_android.models.Product;

public interface ProductService {
    @GET("/product/getProducts")
    public Call<List<Product>> getAllProducts(@Header("Authorization") String auth);
    
    @GET("/product/getProduct/{id}")
    public Call<List<Group>> getProduct(@Header("Authorization") String auth, @Path("id") String id);
    
    @DELETE("/product/deleteProduct/{id}")
    public Call<String> deleteProduct(@Header("Authorization") String auth, @Path("id") String id);
    
    @POST("/product/addProduct")
    public Call<Product> addProduct(@Header("Authorization") String auth, @Body HashMap<String, String> map);
    
    @PUT("/product/editProduct/{id}")
    public Call<Product> editProduct(@Header("Authorization") String auth, @Body HashMap<String, String> map, @Path("id") String id);
}
