package com.merguez.apps.tripletriad.cards;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

import com.merguez.apps.tripletriad.Engine;

/*  Copyright (C) <2011-2012>  <Sylvain "Viish" Berfini>

    This program is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    This program is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
@SuppressLint("ViewConstructor")
public class CompleteCardView extends ImageView
{	
	private static final int PAINT_SIZE = 15;
	private static final int PAINT_COLOR = 0xff000000;
	private static final int SHADOW_COLOR = 0xffffffff;
	private static final float SHADOW_RADIUS = 1.0f;
    private static final int SHADOW_OFFSET = 1;
	
	private int taillePinceau;
	private int posx = 0, posy = 0;
	private Paint paint;
	private Card card;
	
	public CompleteCardView(Context context, Card card)
	{
		super(context);
		
		this.card = card;
		setClickable(false); 
		
		paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		//Typeface typeface = Typeface.createFromAsset(context.getAssets(), "font.ttf");
		//paint.setTypeface(typeface); 
		paint.setColor(PAINT_COLOR);
		paint.setTextAlign(Align.LEFT);
		taillePinceau = PAINT_SIZE;
		paint.setTextSize(taillePinceau);
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
			return card.getBlueFace(); 
		} else if (card.getColor() == Engine.RED) { 
			return card.getRedFace(); 
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
		return card.getBlueFace().getWidth();
	}
	
	public int getRealHeight()
	{
		return card.getBlueFace().getHeight();
	}
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		if (card.isFaceUp())
		{
			if (card.getColor() == Engine.BLUE) {
				canvas.drawBitmap(card.getBlueFace(), posx, posy, null);
			}
			else if (card.getColor() == Engine.RED) {
				canvas.drawBitmap(card.getRedFace(), posx, posy, null);
			}
			
			paint.setShadowLayer(SHADOW_RADIUS, SHADOW_OFFSET, SHADOW_OFFSET, SHADOW_COLOR);
			canvas.drawText(card.top, posx + (3 * taillePinceau / 2 + 2) / 2, posy + taillePinceau, paint);
			paint.setShadowLayer(SHADOW_RADIUS, SHADOW_OFFSET, -SHADOW_OFFSET, SHADOW_COLOR);
			canvas.drawText(card.top, posx + (3 * taillePinceau / 2 + 2) / 2, posy + taillePinceau, paint);
			paint.setShadowLayer(SHADOW_RADIUS, -SHADOW_OFFSET, SHADOW_OFFSET, SHADOW_COLOR);
			canvas.drawText(card.top, posx + (3 * taillePinceau / 2 + 2) / 2, posy + taillePinceau, paint);
			paint.setShadowLayer(SHADOW_RADIUS, -SHADOW_OFFSET, -SHADOW_OFFSET, SHADOW_COLOR);
			canvas.drawText(card.top, posx + (3 * taillePinceau / 2 + 2) / 2, posy + taillePinceau, paint);
			
			paint.setShadowLayer(SHADOW_RADIUS, SHADOW_OFFSET, SHADOW_OFFSET, SHADOW_COLOR);
			canvas.drawText(card.left, posx + 3, posy + 3 * taillePinceau / 2, paint);
			paint.setShadowLayer(SHADOW_RADIUS, SHADOW_OFFSET, -SHADOW_OFFSET, SHADOW_COLOR);
			canvas.drawText(card.left, posx + 3, posy + 3 * taillePinceau / 2, paint);
			paint.setShadowLayer(SHADOW_RADIUS, -SHADOW_OFFSET, SHADOW_OFFSET, SHADOW_COLOR);
			canvas.drawText(card.left, posx + 3, posy + 3 * taillePinceau / 2, paint);
			paint.setShadowLayer(SHADOW_RADIUS, -SHADOW_OFFSET, -SHADOW_OFFSET, SHADOW_COLOR);
			canvas.drawText(card.left, posx + 3, posy + 3 * taillePinceau / 2, paint);
			
			paint.setShadowLayer(SHADOW_RADIUS, SHADOW_OFFSET, SHADOW_OFFSET, SHADOW_COLOR);
			canvas.drawText(card.bottom, posx + (3 * taillePinceau / 2 + 2) / 2, posy + 2 * taillePinceau, paint);
			paint.setShadowLayer(SHADOW_RADIUS, SHADOW_OFFSET, -SHADOW_OFFSET, SHADOW_COLOR);
			canvas.drawText(card.bottom, posx + (3 * taillePinceau / 2 + 2) / 2, posy + 2 * taillePinceau, paint);
			paint.setShadowLayer(SHADOW_RADIUS, -SHADOW_OFFSET, SHADOW_OFFSET, SHADOW_COLOR);
			canvas.drawText(card.bottom, posx + (3 * taillePinceau / 2 + 2) / 2, posy + 2 * taillePinceau, paint);
			paint.setShadowLayer(SHADOW_RADIUS, -SHADOW_OFFSET, -SHADOW_OFFSET, SHADOW_COLOR);
			canvas.drawText(card.bottom, posx + (3 * taillePinceau / 2 + 2) / 2, posy + 2 * taillePinceau, paint);
			
			paint.setShadowLayer(SHADOW_RADIUS, SHADOW_OFFSET, SHADOW_OFFSET, SHADOW_COLOR);
			canvas.drawText(card.right, posx + (3 * taillePinceau / 2) - 2, posy + 3 * taillePinceau / 2, paint);
			paint.setShadowLayer(SHADOW_RADIUS, SHADOW_OFFSET, -SHADOW_OFFSET, SHADOW_COLOR);
			canvas.drawText(card.right, posx + (3 * taillePinceau / 2) - 2, posy + 3 * taillePinceau / 2, paint);
			paint.setShadowLayer(SHADOW_RADIUS, -SHADOW_OFFSET, SHADOW_OFFSET, SHADOW_COLOR);
			canvas.drawText(card.right, posx + (3 * taillePinceau / 2) - 2, posy + 3 * taillePinceau / 2, paint);
			paint.setShadowLayer(SHADOW_RADIUS, -SHADOW_OFFSET, -SHADOW_OFFSET, SHADOW_COLOR);
			canvas.drawText(card.right, posx + (3 * taillePinceau / 2) - 2, posy + 3 * taillePinceau / 2, paint);
		}
		else
		{
			canvas.drawBitmap(card.getBackFace(), posx, posy, null);
		}
	}
	
	public void resizePictures(int x, int y)
	{
		card.setBlueFace(resize(card.getBlueFace(), x, y));
		card.setRedFace(resize(card.getRedFace(), x, y));
		card.setBackFace(resize(card.getBackFace(), x, y));
		
		taillePinceau = y / 5;
		paint.setTextSize(taillePinceau);
	}
	
	private Bitmap resize(Bitmap bm, int x, int y)
	{
		int width = bm.getWidth();
		int height = bm.getHeight();
		int newWidth = x;
		int newHeight = y;
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		
		Matrix matrix = new Matrix();
		matrix.postScale(scaleWidth, scaleHeight);
		Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);

		return resizedBitmap;
	}
	
	private void applyRotation(float start, float end) 
	{		
		final float centerX = posx + (card.getBlueFace().getWidth() / 2.0f);
		final float centerY = posy + (card.getBlueFace().getHeight() / 2.0f);

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
