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
	private boolean locked = false, selected = false, hasMalus = false, hasBonus = false;
	private Bitmap redFace, blueFace, backFace; // A deplacer dans la view
	private CompleteCardView cardView;
	private int color, rewardDirectColor;
	private boolean visible;
	
	public static enum Element {NONE, THUNDER, WATER, WIND, ICE, FIRE, POISON, EARTH, HOLY, DARKNESS};
	public Element element;
	
	public int top, left, bottom, right;
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
	
	public void resetBonusMalusIfNeeded() {
		resetBonusMalusIfNeeded(false);
	}
	public void resetBonusMalusIfNeeded(boolean simulating) {
		if (hasBonus) {
			malusElementaire(simulating);
			hasMalus = hasBonus = false;
		} else if (hasMalus) {
			bonusElementaire(simulating);
			hasMalus = hasBonus = false;
		}
		
		if (cardView != null && !simulating) {
			cardView.invalidate();
		}
	}
	
	public void bonusElementaire() {
		bonusElementaire(false);
	}
	public void bonusElementaire(boolean simulating)
	{
		hasBonus = true;
		
		if (!top.equals("A"))
		{
			int temp = Integer.parseInt(top);
			temp += 1;
			if (temp == 10) { top = "A"; }
			else { top = String.valueOf(temp); }
		}
		
		if (!left.equals("A"))
		{
			int temp = Integer.parseInt(left);
			temp += 1;
			if (temp == 10) { left = "A"; }
			else { left = String.valueOf(temp); }
		}
		
		if (!bottom.equals("A"))
		{
			int temp = Integer.parseInt(bottom);
			temp += 1;
			if (temp == 10) { bottom = "A"; }
			else { bottom = String.valueOf(temp); }
		}
		
		if (!right.equals("A"))
		{
			int temp = Integer.parseInt(right);
			temp += 1;
			if (temp == 10) { right = "A"; }
			else { right = String.valueOf(temp); }
		}
		
		if (cardView != null && !simulating) {
			cardView.invalidate();
		}
	}

	public void malusElementaire() {
		malusElementaire(false);
	}
	public void malusElementaire(boolean simulating)
	{
		hasMalus = true;
		
		if (!top.equals("A"))
		{
			int temp = Integer.parseInt(top);
			temp -= 1;
			top = String.valueOf(temp);
		}
		else { top = "9"; }
		
		if (!left.equals("A"))
		{
			int temp = Integer.parseInt(left);
			temp -= 1;
			left = String.valueOf(temp);
		}
		else { left = "9"; }
		
		if (!bottom.equals("A"))
		{
			int temp = Integer.parseInt(bottom);
			temp -= 1;
			bottom = String.valueOf(temp);
		}
		else { bottom = "9"; }
		
		if (!right.equals("A"))
		{
			int temp = Integer.parseInt(right);
			temp -= 1;
			right = String.valueOf(temp);
		}
		else { right = "9"; }
		
		if (cardView != null && !simulating) {
			cardView.invalidate();
		}
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
	
	public String getElement()
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
