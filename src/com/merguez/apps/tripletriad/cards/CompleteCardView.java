package com.merguez.apps.tripletriad.cards;

import java.io.IOException;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

import com.merguez.apps.tripletriad.Engine;
import com.merguez.apps.tripletriad.cards.Card.Element;


public class CompleteCardView extends ImageView
{	
	
	private int posx = 0, posy = 0;
	private Card card;
	private Context context;
	private Bitmap redFace, blueFace, backFace; // A deplacer dans la view

	public CompleteCardView(Context context)
	{
		super(context);
		this.context = context;
		
		setClickable(false);
	}
	

	public CompleteCardView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		// TODO Auto-generated constructor stub
		setClickable(false);
	}
	
	public CompleteCardView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		this.context = context;
		// TODO Auto-generated constructor stub
		setClickable(false);
	}
	
	public void initFaces() {
		String name = card.getName();
		name = name.toLowerCase();
		
		name = name.replaceAll("[!#$Ä%&',:/@ ]", "_");
		name = name.replaceAll("[‡‚‰ƒ¿¬]", "a");
		name = name.replaceAll("[ÈËÍÎ» À]", "e");
		name = name.replaceAll("[ÏÓÔÃœŒ]", "i");
		name = name.replaceAll("[ÚˆÙ“÷‘]", "o");
		name = name.replaceAll("[˘¸˚Ÿ‹€]", "u");
		name = name.replace("Á", "c");
		try 
		{
			blueFace = BitmapFactory.decodeStream(context.getResources().getAssets().open(name + "_bleue.jpg"));
			redFace = BitmapFactory.decodeStream(context.getResources().getAssets().open(name + "_rouge.jpg"));
		
			backFace = BitmapFactory.decodeStream(context.getResources().getAssets().open("back.png"));	
		
		} 
		catch (IOException e) 
		{
			Log.d("MERGUEZ", "plantage"+name);
			e.printStackTrace();
		}
		this.setImageBitmap(blueFace);
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
