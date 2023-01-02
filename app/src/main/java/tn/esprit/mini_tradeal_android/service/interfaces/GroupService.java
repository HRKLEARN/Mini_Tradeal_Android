package tn.esprit.mini_tradeal_android.service.interfaces;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import tn.esprit.mini_tradeal_android.models.Group;


public interface GroupService {
    @GET("/groupe/getGroupes/{id}")
    public Call<List<Group>> getGroups(@Header("Authorization") String auth, @Path("id") String id);
    
    @GET("/groupe/getAllGroupes")
    public Call<List<Group>> getAllGroups(@Header("Authorization") String auth);
    
    @POST("/groupe/addGoupe")
    public Call<Group> addGroup(@Header("Authorization") String auth, @Body HashMap<String, String> map);
    
    @DELETE("/groupe/deleteGroupe/{id}")
    public Call<String> deleteGroup(@Header("Authorization") String auth, @Path("id") String id);
    
}
