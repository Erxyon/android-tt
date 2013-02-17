package com.merguez.apps.tripletriad;

import java.util.ArrayList;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.actionbarsherlock.app.SherlockFragment;
import com.actionbarsherlock.app.SherlockListFragment;
import com.merguez.apps.tripletriad.MesCartes.CardAdapter;
import com.merguez.apps.tripletriad.cards.Card;
import com.merguez.apps.tripletriad.data.Adversaire;
import com.merguez.apps.tripletriad.data.DatabaseStream;

public class Jouer extends SherlockListFragment {

	private Context context;
	private CardAdapter adapter;
	private ArrayList<Object> listeAdversaires;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.jouer, container, false);

		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		context = getActivity().getApplicationContext();

		listeAdversaires = new ArrayList<Object>();

		DatabaseStream dbs = new DatabaseStream(context);
		dbs.load();


		ArrayList<Adversaire> adversaires = new ArrayList<Adversaire>();
		for (int j = 0; j < 12; j++) {
			adversaires.add(new Adversaire("Merguez"));
		}

		
		listeAdversaires.add("CPU");
		listeAdversaires.addAll(adversaires);



		adapter = new CardAdapter(context, listeAdversaires); 
		setListAdapter(adapter);

		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);


	
	}



}