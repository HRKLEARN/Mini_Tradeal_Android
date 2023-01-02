package tn.esprit.mini_tradeal_android.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.mini_tradeal_android.R;
import tn.esprit.mini_tradeal_android.ui.adapters.ProductAdapter;
import tn.esprit.mini_tradeal_android.database.AppDataBase;
import tn.esprit.mini_tradeal_android.models.Product;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FavoriteFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FavoriteFragment extends Fragment {
	
	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "param1";
	private static final String ARG_PARAM2 = "param2";
	
	private List<Product> mdata;
	private ProductAdapter productAdapter;
	private RecyclerView recyclerView;
	
	
	// TODO: Rename and change types of parameters
	private String mParam1;
	private String mParam2;
	
	public FavoriteFragment() {
		// Required empty public constructor
	}
	
	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @param param1 Parameter 1.
	 * @param param2 Parameter 2.
	 * @return A new instance of fragment FavoriteFragment.
	 */
	// TODO: Rename and change types and number of parameters
	public static FavoriteFragment newInstance(String param1, String param2) {
		FavoriteFragment fragment = new FavoriteFragment();
		Bundle args = new Bundle();
		args.putString(ARG_PARAM1, param1);
		args.putString(ARG_PARAM2, param2);
		fragment.setArguments(args);
		return fragment;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
			mParam1 = getArguments().getString(ARG_PARAM1);
			mParam2 = getArguments().getString(ARG_PARAM2);
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_favorite, container, false);
		
		AppDataBase database = AppDataBase.getAppDatabase(requireActivity().getApplicationContext());
		
		
		List<Product> productList = database.productDao().getAll();
		
		return view;
	}
	
	
	private void initmDataProduct() {
		mdata = new ArrayList<>();
		mdata.add(new Product(R.drawable.photo1));
		mdata.add(new Product(R.drawable.photo2));
		mdata.add(new Product(R.drawable.photo3));
		mdata.add(new Product(R.drawable.photo4));
		mdata.add(new Product(R.drawable.photo5));
		
	}
}