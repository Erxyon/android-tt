package com.merguez.apps.tripletriad;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.os.Debug;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.merguez.apps.tripletriad.data.DatabaseStream;
import com.merguez.apps.tripletriad.cards.Card;
import com.merguez.apps.tripletriad.cards.CompleteCardView;
import com.merguez.apps.tripletriad.R;

public class Cards extends ListActivity
{

	private Context context;
	private CardAdapter adapter;

	private ArrayList<Object> listeCartes;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		//Debug.startMethodTracing("calc");
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cards);

		context = this;

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
		
		getListView().setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
				if (!(v instanceof TextView)) {
					Card carte = (Card) adapter.mThumbIds.get(position);
					Toast.makeText(Cards.this, "Nom : " + carte.getName(), Toast.LENGTH_SHORT).show();
					
					View toolbar = v.findViewById(R.id.ligne2);
	                // Creating the expand animation for the item
	                ExpandAnimation expandAni = new ExpandAnimation(context, toolbar, 70, true);
	                expandAni.setDuration(1000);
	                
	                Interpolator interpolator = new AccelerateInterpolator();
	                expandAni.setInterpolator(interpolator);
	                
	                // Start the animation on the toolbar
	                toolbar.startAnimation(expandAni);
	                if (adapter.cartesAffichees.contains((Integer)position)) {
	                	adapter.cartesAffichees.remove((Integer)position);
	                  } else {
	  					Log.d("gredgred", "gdsgsgs");
	                	  adapter.cartesAffichees.add((Integer)position);
	                  }
				}
			}

		});
		//getWindow().requestFeature(Window.FEATURE_NO_TITLE);

	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		//Debug.stopMethodTracing();
	}

	static class ViewHolder {

		public TextView nomCarte;
		public TextView texteNombre;
		public CheckBox checkBox;
		
		public CompleteCardView cv;
		public View ligne2;

	}
	/*public class EfficientAdapter extends BaseAdapter {

		LayoutInflater inflater;
		Context context;
		private ArrayList<Integer> items;
		private CardAdapter adapter;

		public EfficientAdapter(Context context, ArrayList<Integer> niveaux) {
			inflater = LayoutInflater.from(context);
			this.context = context;
			this.items = niveaux;
		}

		public View getView(final int position, View convertView, ViewGroup parent) {
			ViewHolder holder;

			if(convertView == null){

				convertView = inflater.inflate(R.layout.grid, null);
				holder = new ViewHolder();

				holder.gridview = (GridView)convertView.findViewById(R.id.grid);
				holder.text = (TextView)convertView.findViewById(R.id.text1);

				convertView.setTag(holder);
			}else{

				holder = (ViewHolder)convertView.getTag();
			}

			// Bind the data efficiently with the holder.

			holder.text.setText("NIVEAU "+items.get(position));

			return convertView;
		}


	}*/


	class CardAdapter extends BaseAdapter
	{	
		private ArrayList<Object> mThumbIds;
		private ArrayList<Integer> cartesSelectionnees;
		public ArrayList<Integer> cartesAffichees;
		private Context context;

		public CardAdapter(Context context, ArrayList<Object> listeCartes) 
		{
			this.context = context;
			this.cartesSelectionnees = new ArrayList<Integer>();
			this.cartesAffichees = new ArrayList<Integer>();
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
				CompleteCardView cv;
	
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
				
				holder.cv.setCard(card);
				
				holder.checkBox.setTag(position);
				if (cartesSelectionnees.contains(position)) {
					holder.checkBox.setChecked(true);
				} else {
					holder.checkBox.setChecked(false);
				}
				
				
				if (cartesAffichees.contains((Integer)position)) {
					Log.d("izhgsuizgki", "kihgsizhg");
					DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
					holder.ligne2.getLayoutParams().height = (int)((70 * displayMetrics.density) + 0.5);
					

				} else {
					holder.ligne2.getLayoutParams().height = 0;

				}
				
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
				
				//holder.ligne2.getLayoutParams().height = 0;
				

	           // ((RelativeLayout.LayoutParams) holder.ligne2.getLayoutParams()).bottomMargin = -70;
	          //  holder.ligne2.setVisibility(View.GONE);

				return convertView;
			}
		}
	}
}
