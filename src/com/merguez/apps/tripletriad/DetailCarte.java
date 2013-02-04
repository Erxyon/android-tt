package com.merguez.apps.tripletriad;

import com.merguez.apps.tripletriad.cards.Card;
import com.merguez.apps.tripletriad.cards.CompleteCardView;
import com.merguez.apps.tripletriad.data.ListeCartes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DetailCarte extends Fragment{

	public static DetailCarte newInstance(int index) {
		DetailCarte f = new DetailCarte();

        // Supply index input as an argument.
        Bundle args = new Bundle();
        args.putInt("index", index);
        f.setArguments(args);

        return f;
    }

    public int getShownIndex() {
    	Log.d("aa", "merguez");
    	Log.d("aa", getArguments().toString());
    	
        return getArguments().getInt("index", 0);
    }
	
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
		
		View view = inflater.inflate(R.layout.detail_carte, null);
		
		int id = getShownIndex();
		CompleteCardView cv = (CompleteCardView) view.findViewById(R.id.carte);
		Card card = (Card) ListeCartes.defaut.get(id);
			
		cv.setCard(card);
        return view;
	}
}
