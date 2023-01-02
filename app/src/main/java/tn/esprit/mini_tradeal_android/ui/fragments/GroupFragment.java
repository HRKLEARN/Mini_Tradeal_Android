package tn.esprit.mini_tradeal_android.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import tn.esprit.mini_tradeal_android.R;
import tn.esprit.mini_tradeal_android.ui.adapters.GroupAdapter;
import tn.esprit.mini_tradeal_android.models.Group;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GroupFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GroupFragment extends Fragment {
	
	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "param1";
	private static final String ARG_PARAM2 = "param2";
	
	// TODO: Rename and change types of parameters
	private String mParam1;
	private String mParam2;
	private List<Group> mdata;
	private GroupAdapter groupAdapter;
	private RecyclerView recyclerView;
	
	public GroupFragment() {
		// Required empty public constructor
	}
	
	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @param param1 Parameter 1.
	 * @param param2 Parameter 2.
	 * @return A new instance of fragment GroupFragment.
	 */
	// TODO: Rename and change types and number of parameters
	public static GroupFragment newInstance(String param1, String param2) {
		GroupFragment fragment = new GroupFragment();
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
		View view = inflater.inflate(R.layout.fragment_group, container, false);
		// Add the following lines to create RecyclerView
		recyclerView = view.findViewById(R.id.rvGroups);
		recyclerView.setHasFixedSize(true);
		recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
		initmDataGroup();
		groupAdapter = new GroupAdapter(mdata);
		recyclerView.setAdapter(groupAdapter);
		return view;
		
	}
	
	private void initmDataGroup() {
		mdata = new ArrayList<>();
		mdata.add(new Group(1, "GoldenGroup", "Haitham", "Music"));
		mdata.add(new Group(2, "GoldenGroup", "Haitham", "Music"));
		mdata.add(new Group(3, "GoldenGroup", "Haitham", "Music"));
		mdata.add(new Group(4, "GoldenGroup", "Haitham", "Music"));
		mdata.add(new Group(5, "GoldenGroup", "Haitham", "Music"));
		
	}
}