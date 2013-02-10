package com.merguez.apps.tripletriad;

import com.merguez.apps.tripletriad.cards.Card;
import com.merguez.apps.tripletriad.cards.CompleteCardView;
import com.merguez.apps.tripletriad.data.ListeCartes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DetailCarte extends Fragment{

	public int id = -1;
	public CompleteCardView cv;
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		if (ListeCartes.defaut == null) {
			ListeCartes.listeDesCartes(getActivity());
		}
		
		if (Cards.idAffiche > -1) {
			id = Cards.idAffiche;
		}
		
		
		View view = inflater.inflate(R.layout.detail_carte, null);
		
		cv = (CompleteCardView) view.findViewById(R.id.carte);
		
		updateCarte(id);
		
        return view;
	}
	
	public void updateCarte(int id) {
		Log.d("updateCarte", "ID : " + id);
		this.id = id;
		if (id > 0) {
			Card card = (Card) ListeCartes.defaut.get(id);
			cv.setCard(card);
		}
		
	}
}
