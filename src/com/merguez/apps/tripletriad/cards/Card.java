package com.merguez.apps.tripletriad.cards;

import java.io.IOException;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

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

/*
 * Règles de calcul :
 * - Elémentaire
 * - Bataille
 */
public class Card
{
	private String name;
	private int level;
	private boolean locked = false, selected = false;
	private Bitmap redFace, blueFace, backFace; // A deplacer dans la view
	private CompleteCardView cardView;
	private int color, rewardDirectColor;
	private boolean visible;
	
	public static enum Element {NONE, THUNDER, WATER, WIND, ICE, FIRE, POISON, EARTH, HOLY, DARKNESS};
	public Element element;
	
	public int top, left, bottom, right;
	public int[] valeursBase = new int[4];
	private int animTempColor;
	
	// this.number = number;
	
	public Card(Context context, String name, int level, int top, int left, int bottom, int right, Element element)
	{
		this.name = name;
		this.level = level;
		this.top = top;
		this.left = left;
		this.bottom = bottom;
		this.right = right;
		this.element = element;

		this.valeursBase[0] = top;
		this.valeursBase[1] = left;
		this.valeursBase[2] = bottom;
		this.valeursBase[3] = right;
		
		color = rewardDirectColor = Engine.BLUE;
		visible = true;
		
		/*
		 * A deplacer dans la view
		 */
		try 
		{
			blueFace = BitmapFactory.decodeStream(context.getResources().getAssets().open(this.name + "_bleue.jpg"));
			redFace = BitmapFactory.decodeStream(context.getResources().getAssets().open(this.name + "_rouge.jpg"));
			// j'ai corrigé le .bleu/rouge en _rouge/bleu
			backFace = BitmapFactory.decodeStream(context.getResources().getAssets().open("back.png"));	
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		cardView = null;
	}
	
	/*
	 * A deplacer dans la view
	 */
	public CompleteCardView getView() {
		return cardView;
	}

	/*
	 * A deplacer dans la view
	 */
	public void setCardView(CompleteCardView cardView) {
		this.cardView = cardView;
	}

	@Override
	public Card clone()
	{
		Card clone = new Card(name, level, top, left, bottom, right, element, number, blueFace, redFace, backFace);
		clone.setColor(color);
		clone.setRewardDirectColor(rewardDirectColor);
		clone.setSelected(selected);
		
		if (locked) {
			clone.lock();
		}
		else {
			clone.unlock();
		}
		
		return clone;
	}
	
	public void setColor(int color)
	{
		this.color = color;
	}
	
	public void setRewardDirectColor(int color) {
		rewardDirectColor = color;
	}
	
	public int getRewardDirectColor() {
		return rewardDirectColor;
	}
	
	public void swapColor()
	{
		if (color == Engine.BLUE) {
			animTempColor = Engine.RED;
		} else {
			animTempColor = Engine.BLUE;
		}
		
		if (cardView != null) {
			cardView.swapColor();
		} else {
			color = animTempColor;
		}
	}
	
	public void setAnimTempColorAsReal() {
		color = animTempColor;
	}
	
	public int getColor()
	{
		return color;
	}
	
	public boolean isFaceUp()
	{
		return visible;
	}
	
	public void flipCard()
	{
		visible = !visible;
		
		if (cardView != null) {
			cardView.invalidate();
		}
	}
	
	// robot + regle
	public int getTotal()
	{
		return getTopValue() + getBottomValue() + getLeftValue() + getRightValue();
	}
	
	public void setElement(Element elem) {
		if (this.element.equals(elem)) {
			this.left = Math.min(this.left+1, 10);
			this.top = Math.min(this.top+1, 10);
			this.right = Math.min(this.right+1, 10);
			this.bottom = Math.min(this.bottom+1, 10);
		} else {
			/*
			 * Note : je ne sais pas ce qu'il se passe si une carte à 1 se prend un malus élémentaire
			 * ça fait 0 ou 1 ?
			 */
			this.left = Math.max(this.left-1, 10);
			this.top = Math.max(this.top-1, 10);
			this.right = Math.max(this.right-1, 10);
			this.bottom = Math.max(this.bottom-1, 10);
		}
		/*
		 * 
		if (cardView != null && !simulating) {
			cardView.invalidate();
		}
		 */
	}
	
	public void resetElement() {
		this.top = this.valeursBase[0];
		this.left = this.valeursBase[1];
		this.bottom = this.valeursBase[2];
		this.right = this.valeursBase[3];
	}
	
	@Override
	public String toString()
	{
		return name + " (level " +  level + ") : " + top + ", " + left + ", " + bottom + ", " + right + ", " + element; 
	}
	
	public void lock()
	{
		locked = true;
	}
	
	public void unlock()
	{
		locked = false;
	}
	
	public boolean isPlayed()
	{
		return locked;
	}
	
	public boolean isSelected()
	{
		return selected;
	}
	
	public void setSelected(boolean isSelected)
	{
		selected = isSelected;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getFullName()
	{
		return name;
	}
	
	public Element getElement()
	{
		return element;
	}
	
	public int getTopValue()
	{
		return top;
	}
	
	public int getLeftValue()
	{
		return left;
	}
	
	public int getBottomValue()
	{
		return bottom;
	}
	
	public int getRightValue()
	{
		return right;
	}
	
	public int getLevel()
	{
		return level;
	}
	
	public Bitmap getRedFace() {
		return redFace;
	}
	
	public Bitmap getBlueFace() {
		return blueFace;
	}
	
	public Bitmap getBackFace() {
		return backFace;
	}

	public void setRedFace(Bitmap redFace) {
		this.redFace = redFace;
	}

	public void setBlueFace(Bitmap blueFace) {
		this.blueFace = blueFace;
	}

	public void setBackFace(Bitmap backFace) {
		this.backFace = backFace;
	}
}
