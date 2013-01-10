package com.merguez.apps.tripletriad;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.Toast;

import com.merguez.apps.tripletriad.cards.Card;
import com.merguez.apps.tripletriad.cards.CompleteCardView;
import com.merguez.apps.tripletriad.cards.MinimalistCardView;
import com.merguez.apps.tripletriad.R;

public class Cards extends Activity
{
    private static int NUM_VIEWS = 10; // One for each card's level
    
	private ViewPager myCards;
	private Typeface typeface;
	private GridView gridview;
	private Context context;
	private CardAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.cards);

	    gridview = (GridView) findViewById(R.id.grid_cards);
	    adapter = new CardAdapter(this);
	    gridview.setAdapter(adapter);

	    gridview.setOnItemClickListener(new OnItemClickListener() {
	        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	            Toast.makeText(Cards.this, "Nom : " + adapter.mThumbIds.get(position).getName(), Toast.LENGTH_SHORT).show();
	        }
	    });

        context = this;
		
		
		
        //getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		
	}
	
	
	class CardAdapter extends BaseAdapter
	{	
	    private ArrayList<Card> mThumbIds;
	    private Context context;

	    public CardAdapter(Context context) 
	    {
	    	this.context = context;
	    	ListeCartes.listeDesCartes(context);
	    	mThumbIds = ListeCartes.defaut;
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
