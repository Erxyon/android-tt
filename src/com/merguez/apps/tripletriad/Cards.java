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
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;

import com.merguez.apps.tripletriad.cards.Card;
import com.merguez.apps.tripletriad.cards.CompleteCardView;
import com.merguez.apps.tripletriad.cards.MinimalistCardView;
import com.merguez.apps.tripletriad.R;

public class Cards extends Activity
{
    private static int NUM_VIEWS = 10; // One for each card's level
    
	private ViewPager myCards;
	private Typeface typeface;
	private LinearLayout mainLayout;
	private Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		ListeCartes.listeDesCartes(this);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.cards);
        context = this;
		
        
        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        MyCardsAdapter myCardsAdapter = new MyCardsAdapter();
        myCards = (ViewPager) findViewById(R.id.cards);
        myCards.setAdapter(myCardsAdapter);
        myCards.setOnPageChangeListener(myCardsLevelChangePageListener);
	}
	
	private OnPageChangeListener myCardsLevelChangePageListener = new OnPageChangeListener() {
		
		@Override
		public void onPageSelected(int position) {
			//levelMyCards.setText(getString(R.string.cards_level) + " " + String.valueOf(10 - position));
		}
		
		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			
		}
		
		@Override
		public void onPageScrollStateChanged(int arg0) {
			
		}
	};
	
	

	class MyCardsAdapter extends PagerAdapter {
		@Override
		public int getCount() {
			return NUM_VIEWS;
		}
	
		@Override
		public boolean isViewFromObject(View view, Object object) {
			return view == ((GridView) object);
		}      
		  
		@Override  
		public Object instantiateItem(View collection, int position) {  
			View v = getLayoutInflater().inflate(R.layout.grid, null);
			GridView grid = (GridView) v.findViewById(R.id.grid);

			grid.setAdapter(new CardAdapter(ListeCartes.defaut));
			
			((ViewPager) collection).addView(grid,0);
			return grid;
		}  
		  
		@Override  
		public void destroyItem(View collection, int position, Object view){  
			((ViewPager) collection).removeView((GridView) view);
		} 
	}
	
	class CardAdapter extends BaseAdapter
	{	
	    private ArrayList<Card> mThumbIds;

	    public CardAdapter(ArrayList<Card> cards) 
	    {
	        mThumbIds = cards;
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
	        View v;
	        CompleteCardView cv;
	        
	        if(convertView == null)
	        {
                LayoutInflater li = ((Activity) context).getLayoutInflater();
                v = li.inflate(R.layout.icon, null); 
	        }
	        else
	        {
                v = convertView;
	        }
	        v.setPadding(5, 5, 5, 5);	   
	        
	        Card card = mThumbIds.get(position);
	        cv = (CompleteCardView) v.findViewById(R.id.icon_image);
	        cv.setCard(card);
//	        cv.setOnClickListener((OnClickListener) context);
	        cv.resizePictures(mainLayout.getWidth() / 8, mainLayout.getHeight() / 4);
	        v.requestLayout();
	        return v;
	    }
	}
}
