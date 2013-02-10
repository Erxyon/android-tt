package com.merguez.apps.tripletriad;

import com.actionbarsherlock.app.SherlockFragment;
import com.merguez.apps.tripletriad.data.ListeCartes;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CardsActivity extends SherlockFragment {
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View view = inflater.inflate(R.layout.cards_activity, container, false);
		return view;
	}
   
}