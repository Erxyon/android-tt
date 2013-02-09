package com.merguez.apps.tripletriad;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Debug;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.ListFragment;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.merguez.apps.tripletriad.data.DatabaseStream;
import com.merguez.apps.tripletriad.cards.Card;
import com.merguez.apps.tripletriad.cards.CompleteCardView;


public class Cards extends ListFragment
{

	private Context context;
	private CardAdapter adapter;

	private ArrayList<Object> listeCartes;
	
	int positionAffichee = -1;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.cards, null);
        return view;
	}
	
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("curChoice", positionAffichee);
    }

	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		context = getActivity().getApplicationContext();
		
		listeCartes = new ArrayList<Object>();

		DatabaseStream dbs = new DatabaseStream(context);
		dbs.load();
		
		for (int i=1; i<=10; i++) {
			ArrayList<Card> cartes = dbs.getAllCards(i);
			
			listeCartes.add("Niveau "+i);
			listeCartes.addAll(cartes);

		}
		
		adapter = new CardAdapter(context, listeCartes); 
		setListAdapter(adapter);
		
		getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		
		if (savedInstanceState != null) {
            // Restore last state for checked position.
            positionAffichee = savedInstanceState.getInt("curChoice", -1);
        }
		showDetails(positionAffichee);
		
		/*getListView().setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				
			}

		});*/
		
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		
		if (!(v instanceof TextView)) {
			Card carte = (Card) adapter.mThumbIds.get(position);
			String texte =  "Nom : " + carte.getName();
			Toast.makeText(context, texte, Toast.LENGTH_SHORT).show();
			
			showDetails(position);
			
           
		}
		
	}
	
    public void showDetails(int index) {
        positionAffichee = index;
       
        // We can display everything in-place with fragments, so update
        // the list to highlight the selected item and show the data.
        int id = -1;
        if (index > -1) {
        	 getListView().setItemChecked(index, true);
             
         	Card carte = (Card) adapter.mThumbIds.get(index);
         	id = carte.id;
        }

        // Check what fragment is currently shown, replace if needed.
        DetailCarte details = (DetailCarte)
                getFragmentManager().findFragmentById(R.id.fragment2);
        
        if (details == null || !details.isInLayout()) {
        	
        	Log.d("testfrg", "fragment details null");

            // Execute a transaction, replacing any existing fragment
            // with this one inside the frame.
            Intent launchingIntent = new Intent(getActivity(),DetailCarte.class);
  		  launchingIntent.putExtra("ID_CARTE", id);
  		  startActivity(launchingIntent);
        } else {
        	details.updateCarte(id);
    	}

       
    }

	
	

	static class ViewHolder {

		public TextView nomCarte;
		public TextView texteNombre;
		public CheckBox checkBox;
		
		public CompleteCardView cv;
		public View ligne2;

	}


	class CardAdapter extends BaseAdapter
	{	
		private ArrayList<Object> mThumbIds;
		private ArrayList<Integer> cartesSelectionnees;
		private Context context;

		public CardAdapter(Context context, ArrayList<Object> listeCartes) 
		{
			this.context = context;
			this.cartesSelectionnees = new ArrayList<Integer>();
			this.mThumbIds = listeCartes;
		}

		public int getCount() 
		{
			return mThumbIds.size();
		}

		public Object getItem(int position) 
		{
			return mThumbIds.get(position);
		}

		public long getItemId(int position) 
		{
			return 0;
		}

		// Vues multiples
		@Override
		public int getViewTypeCount() {
			return 2;
		}
		@Override
		public int getItemViewType(int position) {
			if (mThumbIds.get(position) instanceof String) {
			//if (position%12 == 0){
				return 1;
			} else {
				return 0;
			}
		}
		
		public View getView(int position, View convertView, ViewGroup parent) 
		{
			// Pour les TextView "Niveau 1", "Niveau 2", ...
			if (getItemViewType(position) == 1) {
				TextView text;
				if(convertView == null) {
					text = new TextView(context);
					text.setPadding(2, 2, 2, 2);
				} else {
					text = (TextView) convertView;
				}
				
				text.setText((String) mThumbIds.get(position));
			
				return text;
				
			// Pour les lignes correspondants aux cartes
			} else {

				ViewHolder holder;
	
				if(convertView == null) {
					
			        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			        convertView = inflater.inflate(R.layout.affichage_carte, parent, false);
			       
			        holder = new ViewHolder();
			        
			        holder.cv = (CompleteCardView) convertView.findViewById(R.id.carte);
					holder.nomCarte = (TextView) convertView.findViewById(R.id.nomCarte);
					holder.texteNombre = (TextView) convertView.findViewById(R.id.nombre);
		            holder.ligne2 = convertView.findViewById(R.id.ligne2);
					holder.checkBox = (CheckBox) convertView.findViewById(R.id.checkBox1);
		            
		            holder.checkBox.setOnClickListener( new View.OnClickListener() {
		                public void onClick(View v) {
		                  CheckBox cb = (CheckBox) v;
		                  Integer pos = (Integer) cb.getTag();
		                  if (cartesSelectionnees.contains(pos)) {
		                	  cartesSelectionnees.remove(pos);
		                  } else {
		                	  cartesSelectionnees.add(pos);
		                  }

		                }
		              });
			        
			        convertView.setTag(holder);
					
	
				} else {
					holder = (ViewHolder) convertView.getTag();
				}
				
				Card card = (Card) mThumbIds.get(position);
				
				//holder.cv.setCard(card);
				
				holder.checkBox.setTag(position);
				if (cartesSelectionnees.contains(position)) {
					holder.checkBox.setChecked(true);
				} else {
					holder.checkBox.setChecked(false);
				}
				
				
				
				holder.ligne2.getLayoutParams().height = 0;
				
				int nombre = 0;
				if (DatabaseStream.nombreCartes.indexOfKey(card.id) >= 0) {
					nombre = DatabaseStream.nombreCartes.get(card.id);
				}
				

				holder.nomCarte.setText(card.getName());
				if (nombre == 0) {
					holder.texteNombre.setText("0");
					holder.texteNombre.setEnabled(false);
					holder.nomCarte.setEnabled(false);
				}
				else {
					holder.texteNombre.setText(Integer.toString(nombre));
					holder.texteNombre.setEnabled(true);
					holder.nomCarte.setEnabled(true);
				}
				
				return convertView;
			}
		}
	}
}
