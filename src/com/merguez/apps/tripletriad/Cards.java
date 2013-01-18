package com.merguez.apps.tripletriad;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Context;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.merguez.apps.tripletriad.cards.Card;
import com.merguez.apps.tripletriad.cards.CompleteCardView;
import com.merguez.apps.tripletriad.R;

public class Cards extends ListActivity
{
    
	private Context context;
	private EfficientAdapter adapter;
	
	private SparseArray<ArrayList<Card>> listeCartes;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.cards);

        context = this;
        
        listeCartes = new SparseArray<ArrayList<Card>>();

        ArrayList<Integer> niveaux = new ArrayList<Integer>();

        DatabaseStream dbs = new DatabaseStream(context);
        for (int i=1; i<=10; i++) {
            ArrayList<Card> cartes = dbs.getMyCards(i);
        	
            if (cartes.size() > 0) {
            	niveaux.add(i);
            	listeCartes.put(i, cartes);
            	
            }
        }
	   
	    adapter = new EfficientAdapter(this, niveaux); // ne marchera pas pour l'instant. ^^x) courage :)
	    setListAdapter(adapter);
        //getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		
	}
	
	public class ViewHolder {

		public TextView text;
		public GridView gridview;
		
	}
	public class EfficientAdapter extends BaseAdapter {

        LayoutInflater inflater;
        Context context;
        private ArrayList<Integer> items;
    	private CardAdapter adapter;

        public EfficientAdapter(Context context, ArrayList<Integer> niveaux) {
            inflater = LayoutInflater.from(context);
            this.context = context;
            this.items = niveaux;
        }


        public int getCount() {
            return items.size();
        }


        public Object getItem(int position) {
            return items.get(position);
        }


        public long getItemId(int position) {
            return 0;
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
            	adapter = new CardAdapter(context, items.get(position)); 
        	    holder.gridview.setAdapter(adapter);

        	    holder.gridview.setOnItemClickListener(new OnItemClickListener() {
        	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
        	            Toast.makeText(Cards.this, "Nom : " + adapter.mThumbIds.get(position).getName(), Toast.LENGTH_SHORT).show();
        	        }
        	    });
        	    
        	    holder.text.setText("NIVEAU "+items.get(position));
        	    

          
            return convertView;
        }


    }

	
	class CardAdapter extends BaseAdapter
	{	
	    private ArrayList<Card> mThumbIds;
	    private Context context;

	    public CardAdapter(Context context, int niveau) 
	    {
	    	this.context = context;
	    	
	    	mThumbIds = listeCartes.get(niveau);
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

		public View getView(int position, View convertView, ViewGroup parent) 
	    {
	        CompleteCardView cv;
	        
	        if(convertView == null)
	        {
	        	cv = new CompleteCardView(context);
	        	cv.setLayoutParams(new GridView.LayoutParams(85, 85));
	            cv.setScaleType(ImageView.ScaleType.CENTER_CROP);
	            cv.setPadding(2, 2, 2, 2);
	            
	        }
	        else
	        {
                cv = (CompleteCardView) convertView;
	        }	   
	        
	        Card card = mThumbIds.get(position);
	        cv.setCard(card);
	        cv.resizePictures(75, 75);
	        return cv;
	    }
	}
}
