package tn.esprit.mini_tradeal_android.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
	private static final String BASE_URL = "http://10.0.2.2:5000/";
	private static ApiClient clientObject;
	private static Retrofit retrofit;
	
	public ApiClient() {
		retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
	}
	
	public static synchronized ApiClient getInstance() {
		if (clientObject == null)
			clientObject = new ApiClient();
		return clientObject;
	}
	/*
	public ProductService getProductRepo(){
		return retrofit.create(ProductService.class);
	}
	
	public UserService getUserService()
	{
		return retrofit.create(UserService.class);
	}
	
	public GroupService getGroupeService(){return  retrofit.create(GroupService.class);}
	
	public EchangeService getOrderService(){return  retrofit.create(EchangeService.class);}
*/
}
