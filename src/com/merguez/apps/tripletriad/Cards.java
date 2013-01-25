package com.merguez.apps.tripletriad;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
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
	                ExpandAnimation expandAni = new ExpandAnimation(toolbar, 1000);
	                // Start the animation on the toolbar
	                toolbar.startAnimation(expandAni);
	                
				}
			}

		});
		//getWindow().requestFeature(Window.FEATURE_NO_TITLE);

	}

	public class ViewHolder {

		public TextView text;
		public GridView gridview;

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
		private Context context;

		public CardAdapter(Context context, ArrayList<Object> listeCartes) 
		{
			this.context = context;

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
			Log.d("merguez", "pos:"+position);
			if (getItemViewType(position) == 1) {
				TextView text;
				if(convertView == null)
				{
					text = new TextView(context);
					text.setPadding(2, 2, 2, 2);
					
				}
				else
				{
					text = (TextView) convertView;
				}
				text.setText((String) mThumbIds.get(position));
			
				return text;
			}
			else {
				View view;
				CompleteCardView cv;
	
				if(convertView == null)
				{
					
			        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			        view = inflater.inflate(R.layout.affichage_carte, parent, false);
			       
			        
			        cv = (CompleteCardView) view.findViewById(R.id.carte);
					cv.setScaleType(ImageView.ScaleType.FIT_XY);
					cv.setPadding(2, 2, 2, 2);
					
	
				}
				else
				{
					view = convertView;
				}
				
				Card card = (Card) mThumbIds.get(position);
		        cv = (CompleteCardView) view.findViewById(R.id.carte);
				cv.setCard(card);
				TextView nomCarte = (TextView) view.findViewById(R.id.nomCarte);
				TextView texteNombre = (TextView) view.findViewById(R.id.nombre);

				int nombre = 0;
				if (DatabaseStream.nombreCartes.indexOfKey(card.id) >= 0) {
					nombre = DatabaseStream.nombreCartes.get(card.id);
				}
				

				nomCarte.setText(card.getName());
				if (nombre ==0 ) {
					texteNombre.setText("0");
					texteNombre.setEnabled(false);
					nomCarte.setEnabled(false);
				}
				else {
					texteNombre.setText(Integer.toString(nombre));
					texteNombre.setEnabled(true);
					nomCarte.setEnabled(true);
				}
				

	            View toolbar = view.findViewById(R.id.ligne2);
	            ((RelativeLayout.LayoutParams) toolbar.getLayoutParams()).bottomMargin = -70;
	            toolbar.setVisibility(View.GONE);

				

				//cv.resizePictures(75, 75);
				return view;
			}
		}
	}
}
