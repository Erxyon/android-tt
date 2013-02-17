package com.merguez.apps.tripletriad.cards;

import java.io.IOException;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

import com.merguez.apps.tripletriad.R;
import com.merguez.apps.tripletriad.cards.Card.Element;
import com.merguez.apps.tripletriad.combat.Engine;


public class CompleteCardView extends ImageView
{	
	
	private static Bitmap back = null;
	private int posx = 0, posy = 0;
	private Card card;
	private Context context;
	private String name; // nom du fichier
	private Bitmap redFace, blueFace, backFace; // A deplacer dans la view

	public CompleteCardView(Context context)
	{
		super(context);
		this.context = context;
		init();
	}
	

	public CompleteCardView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		init();
	}
	
	public CompleteCardView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
		init();
	}
	
	public void init() {
		setClickable(false);
		if (back == null) {
			back = BitmapFactory.decodeResource(context.getResources(), R.drawable.back);
		}
		this.setImageBitmap(back);
		
	}
	
	public void initFaces() {
		this.name = card.getName();
		name = name.toLowerCase();
		
		name = name.replaceAll("[!#$Ä%&',:/@ ]", "_");
		name = name.replaceAll("[‡‚‰ƒ¿¬]", "a");
		name = name.replaceAll("[ÈËÍÎ» À]", "e");
		name = name.replaceAll("[ÏÓÔÃœŒ]", "i");
		name = name.replaceAll("[ÚˆÙ“÷‘]", "o");
		name = name.replaceAll("[˘¸˚Ÿ‹€]", "u");
		name = name.replace("Á", "c");
		
		new AsyncTask<CompleteCardView, Void, Bitmap>() {
		    private CompleteCardView v;

		    @Override
		    protected Bitmap doInBackground(CompleteCardView... params) {
		        v = params[0];
		        try {
					return BitmapFactory.decodeStream(v.context.getResources().getAssets().open(v.name + "_bleue.jpg"));
				} catch (IOException e) {
					return null;
				}
		    }

		    @Override
		    protected void onPostExecute(Bitmap result) {
		        super.onPostExecute(result);
		        v.blueFace = result;
		        v.setImageBitmap(result);
		    }
		}.execute(this);
		
	}
	
	
	public void setCard(Card c)
	{
		card = c;
		initFaces();
		invalidate();
	}
	
	public void swapColor()
	{
		if (card.getColor() == Engine.RED) {
			applyRotation(0, 90);
		} else {
			applyRotation(0, -90);
		}
	}
	
	public void move(int x, int y)
	{
		posx = x;
		posy = y;
			
		invalidate();
	}
	
	public Bitmap getBitmap()
	{
		if (card.getColor() == Engine.BLUE) { 
			return blueFace; 
		} else if (card.getColor() == Engine.RED) { 
			return redFace;
		}
		
		return null;
	}
	
	public int getPositionX()
	{
		return posx;
	}
	
	public int getPositionY()
	{
		return posy;
	}
	
	public int getRealWidth()
	{
		return blueFace.getWidth();
	}
	
	public int getRealHeight()
	{
		return blueFace.getHeight();
	}
	
	
	private void applyRotation(float start, float end) 
	{		
		final float centerX = posx + (blueFace.getWidth() / 2.0f);
		final float centerY = posy + (blueFace.getHeight() / 2.0f);

		final FlipCardAnimation rotation = new FlipCardAnimation(start, end, centerX, centerY);
		rotation.setDuration(300);
		rotation.setFillAfter(true);
		rotation.setInterpolator(new AccelerateInterpolator());
		rotation.setRepeatMode(Animation.REVERSE);
		rotation.setRepeatCount(1);
		rotation.setAnimationListener(new AnimationListener() 
		{
			public void onAnimationStart(Animation animation) 
			{
				
			}
			public void onAnimationRepeat(Animation animation) 
			{
				card.setAnimTempColorAsReal();
				invalidate();
			}
			public void onAnimationEnd(Animation animation)
			{
				
			}
		});
		
		startAnimation(rotation);
	}
}
