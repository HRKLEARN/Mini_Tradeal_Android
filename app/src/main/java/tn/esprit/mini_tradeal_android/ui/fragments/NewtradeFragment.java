package tn.esprit.mini_tradeal_android.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import tn.esprit.mini_tradeal_android.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewtradeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewtradeFragment extends Fragment {
	// TODO: Rename parameter arguments, choose names that match
	// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
	private static final String ARG_PARAM1 = "param1";
	private static final String ARG_PARAM2 = "param2";
	Spinner spinner;
	RadioButton Rb1, Rb2;
	RadioGroup Rg;
	// TODO: Rename and change types of parameters
	private String mParam1;
	private String mParam2;
	
	public NewtradeFragment() {
		// Required empty public constructor
	}
	
	/**
	 * Use this factory method to create a new instance of
	 * this fragment using the provided parameters.
	 *
	 * @param param1 Parameter 1.
	 * @param param2 Parameter 2.
	 * @return A new instance of fragment NewtradeFragment.
	 */
	// TODO: Rename and change types and number of parameters
	public static NewtradeFragment newInstance(String param1, String param2) {
		NewtradeFragment fragment = new NewtradeFragment();
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
		View view = inflater.inflate(R.layout.fragment_newtrade, container, false);
		
		spinner = (Spinner) view.findViewById(R.id.spinner);
		
		return view;
	}
	
	@Override
	public void onActivityCreated(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		// Create an ArrayAdapter using the string array and a default spinner layout
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
				R.array.Category_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
		spinner.setAdapter(adapter);
	}
	
	public void onRadioButtonClicked(View view) {
		// Is the button now checked?
		boolean checked = ((RadioButton) view).isChecked();
		
		// Check which radio button was clicked
		switch (view.getId()) {
			case R.id.radio_goods:
				if (checked)
					// Pirates are the best
					break;
			case R.id.radio_services:
				if (checked)
					// Ninjas rule
					break;
		}
	}
}