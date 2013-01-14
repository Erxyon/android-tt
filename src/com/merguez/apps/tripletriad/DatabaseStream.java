package com.merguez.apps.tripletriad;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.merguez.apps.tripletriad.cards.Card;
import com.merguez.apps.tripletriad.cards.Card.Element;
// ULTRA GIGA COMMENTAIRE
/*
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * HASHMAP PUTAIN DE SA RACE BOULBA DE SA MAMAN LA CHIENNE
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 */
/*  Copyright (C) <2011-2012>  <Florian et Guillaume>

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
public class DatabaseStream 
{
	
	private SQLiteConnector connector;
	private SQLiteDatabase stream;
	private Context context;
	
	public DatabaseStream(Context c)
	{
		context = c;
		connector = new SQLiteConnector(context, "TripleTriad", 10);
		stream = connector.getWritableDatabase();
	}
	/*
	// si on est mauvais et qu'on a perdu toutes nos cartes dès le début.
	public void reinitCards()
	{
		stream.delete("MyCards", null, null);
		initCards();
	}
	*/	
	public Card getCard(Cursor cursor) {
		
		String name = cursor.getString(cursor.getColumnIndex("Name"));
		int level = cursor.getInt(cursor.getColumnIndex("Level"));
		int top = cursor.getInt(cursor.getColumnIndex("TopValue"));
		int left = cursor.getInt(cursor.getColumnIndex("LeftValue"));
		int bot = cursor.getInt(cursor.getColumnIndex("BotValue"));
		int right = cursor.getInt(cursor.getColumnIndex("RightValue"));
		String element = cursor.getString(cursor.getColumnIndex("Element"));
		
		Card card = new Card(context, name, level, top, left, bot, right, Element.valueOf(element));
		return card;
	}
	
	
	public void close()
	{
		connector.close();
		stream.close();
	}

	/*public void nouvelleCarte(String cardFullName) 
	{
		Cursor result = stream.query("MyCards", null, "CardName LIKE \"" + cardFullName + "\"", null, null, null, "CardName ASC");
		
		if (result != null && result.move(1)) // Si on en a deja un exemplaire, on augmente de 1 la valeur Number
		{
			int number = 0;
			int numberColumn = result.getColumnIndex("Number");
			number = result.getInt(numberColumn); // Valeur anterieure
			number += 1; // Nouvelle valeur
			
			ContentValues cv = new ContentValues();
			cv.put("CardName", cardFullName);
			cv.put("Number", number);
			
			stream.update("MyCards", cv, "CardName LIKE \"" + cardFullName + "\"", null); // Mise a jour de la table
			
			result.close();
			
		}
		else // Premier exemplaire, on l'ajoute dans MyCards
		{
			ContentValues cv = new ContentValues();
			cv.put("CardName", cardFullName);
			cv.put("Number", 1);
			stream.insert("MyCards", null, cv);
			
			if (result != null)
			{
				result.close();
			}
		}
	}
	
	public Card getRandomCard(int level)
	{
		Card card = null;
		Cursor result = stream.query("Cards", null, "Level LIKE " + level, null, null, null, "Name ASC");
		int randomInt = new Random().nextInt(result.getCount());
		if (result != null && result.move(randomInt)) {
			card = getCard(result);
		}
		result.close();
		
	    return card;
	}

	public ArrayList<Card> getXRandomCards(String cond, int howMuch)
	{
		ArrayList<Card> cards = new ArrayList<Card>();
		
		Cursor result = stream.query("Cards", null, cond, null, null, null, "Name ASC");
		if (result != null)
		{
			int[] randoms = new int[howMuch];
	    	Random random = new Random();
	    	for (int i = 0; i < howMuch; i++)
	    	{
	    		boolean existeDeja = false;
	    		int rand = random.nextInt(result.getCount() - 1) + 1;
	    		
	    		for (int j = 0; j < i; j++)
	    		{
	    			if (randoms[j] == rand) existeDeja = true;
	    		}
	    		
	    		if (existeDeja) i -= 1;
	    		else randoms[i] = rand;
	    	}
	    	Arrays.sort(randoms);
    		
    		for (int i = 0; i < howMuch; i++)
    		{
    			result.move(randoms[i]);
    			Card card = getCard(result);
				cards.add(card);
    			result.moveToFirst();
    		}
    		
    		result.close();
		}
		
		return cards;
	}
	
	public ArrayList<Card> getXRandomMyCards(int howMuch)
	{
		ArrayList<Card> cards = new ArrayList<Card>();
		
		Cursor result = stream.query("MyCards", null, null, null, null, null, "Name ASC");
		if (result != null)
		{
			int[] randoms = new int[howMuch];
	    	Random random = new Random();
	    	for (int i = 0; i < howMuch; i++)
	    	{
	    		boolean existeDeja = false;
	    		int rand = random.nextInt(result.getCount() - 1) + 1;
	    		
	    		for (int j = 0; j < i; j++)
	    		{
	    			if (randoms[j] == rand) existeDeja = true;
	    		}
	    		
	    		if (existeDeja) i -= 1;
	    		else randoms[i] = rand;
	    	}
	    	Arrays.sort(randoms);
    		
    		for (int i = 0; i < howMuch; i++)
    		{
    			result.move(randoms[i]);
    			Card card = getCard(result);
				cards.add(card);
    			result.moveToFirst();
    		}
    		
    		result.close();
		}
		
		return cards;
	}
	
	public ArrayList<Card> getAllCards(int filterByLevel)
	{
		ArrayList<Card> cards = new ArrayList<Card>();
		
		String selection = null;
		if (filterByLevel > -1) {
			selection = "Level LIKE " + filterByLevel;
		}
		
		Cursor result = stream.query("Cards", null, selection, null, null, null, "Level ASC");
		if (result != null)
		{
			while (result.move(1))
			{
				Card card = getCard(result);
				cards.add(card);
			}
		}
		result.close();
		
		return cards;
	}
	
	public ArrayList<Card> getAllCards()
	{
		return getAllCards(-1);
	}

	public ArrayList<Card> getMyCards() {
		return getMyCards(-1);
	}
	
	public ArrayList<Card> getMyCards(int filterByLevel) 
	{
		ArrayList<Card> cards = new ArrayList<Card>();
		
		Cursor result = stream.query("MyCards", null, null, null, null, null, "CardName DESC");
		if (result != null && result.move(1))
		{
			do
			{
				int cardNameColumn = result.getColumnIndex("CardName");
				int howMuchColumn = result.getColumnIndex("Number");
				
				String fullName = result.getString(cardNameColumn);
				int howMuch = result.getInt(howMuchColumn);
				String cardName = fullName.split("/")[1];
				int episode = Integer.parseInt(fullName.split("/")[0].split("ff")[1]);
				
				String selection = "";
				if (filterByLevel > -1) {
					selection = " AND Level LIKE " + filterByLevel;
				}
				
				Cursor result2 = stream.query("Cards", null, "Name LIKE \"" + cardName + "\" AND Episode LIKE " + episode + selection, null, null, null, "Name ASC");
				if (result2 != null && result2.move(1))
				{
					Card card = getCard(result2);
					card.setNumber(howMuch);
	    			cards.add(card);	    
	    			result2.close();	    			
				}
				if (result2 != null)
				{
	    			result2.close();
				}
			}
			while (result.move(1));
		}
		if (result != null)
		{
			result.close();
		}
		
		return cards;
	}

	public void supprimerCarte(String cardFullName) 
	{
		Cursor result = stream.query("MyCards", null, "CardName LIKE \"" + cardFullName + "\"", null, null, null, "CardName ASC");
		
		if (result != null && result.move(1)) // Si on en a deja un exemplaire, on diminue de 1 la valeur Number, si Number tombe a zero, on supprime toute l'entree
		{
			int number = 0;
			int numberColumn = result.getColumnIndex("Number");
			number = result.getInt(numberColumn); // Valeur anterieure
			number -= 1; // Nouvelle valeur
			
			if (number > 0)
			{
				ContentValues cv = new ContentValues();
				cv.put("CardName", cardFullName);
				cv.put("Number", number);
				
				stream.update("MyCards", cv, "CardName LIKE \"" + cardFullName + "\"", null); // Mise a jour de la table
				
				result.close();
			}
			else
			{
				stream.delete("MyCards", "CardName LIKE \"" + cardFullName + "\"", null); // Suppresion de la ligne
				
				result.close();
			}
		}
	}
	
	
	// Distribue les cartes au début
	public void initCards() 
	{
		// i = niveau
		for (int i = 1; i <= 10; i++)
		{
			int howMuch = 0;
			if (i >= 7 && i <= 10) howMuch = 1;
			else if (i >= 5 && i <= 6) howMuch = 2;
			else if (i >= 2 && i<= 4) howMuch = 3;
			else howMuch = 4;
			
			ArrayList<Card> cards = new ArrayList<Card>();
			cards = getXRandomCards("Level LIKE " + i + "", howMuch);
			
			for (Card c : cards)
			{
				nouvelleCarte(c.getFullName());
			}
		}
		
		SharedPreferences lastSettings = context.getSharedPreferences("TripleTriad", Context.MODE_PRIVATE);
		SharedPreferences.Editor editor = lastSettings.edit();
		editor.putBoolean("FirstTime", false);
		editor.commit();
	}

	
}
*/
	
/*
 * v1
 * 
 * Cartes
 * 		Identifiant int
 * 		Nom			text
 * 		Nombre		int
 * TODO	Niveau		int ???
 */
class SQLiteConnector extends SQLiteOpenHelper 
{
	public SQLiteConnector(Context context, String databaseName, int databaseVersion)
	{
		super(context, databaseName, null, databaseVersion);
	}
	
	public void onCreate(SQLiteDatabase db) 
	{
		db.execSQL("CREATE TABLE Cartes (Identifiant INTEGER NOT NULL, Nom TEXT NOT NULL, Nombre INTEGER NOT NULL, PRIMARY KEY (Identifiant) )");
		
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		db.execSQL("TRUNCATE TABLE my_pages");
		// En cas de changement dans la structure de la base de données, apporter les modifications ici aussi
	}
	
	public void close()
	{
		super.close();
	}
	
}}
