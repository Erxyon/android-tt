package com.merguez.apps.tripletriad.data;

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
import android.util.SparseArray;
import android.util.SparseIntArray;

import com.merguez.apps.tripletriad.cards.Card;
import com.merguez.apps.tripletriad.cards.Card.Element;

public class DatabaseStream 
{
	
	private SQLiteConnector connector;
	private SQLiteDatabase stream;
	private Context context;
	
	
	public DatabaseStream(Context c)
	{
		context = c;
		ListeCartes.listeDesCartes(c);

		connector = new SQLiteConnector(context, "TripleTriad", 14);

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
		
		int id = cursor.getInt(cursor.getColumnIndex("Identifiant"));
		Card carte = ListeCartes.defaut.get(id);
		carte.id = id;
		return carte;
	}
	
	public static SparseIntArray nombreCartes = new SparseIntArray();
	// idCarte => nombre
	
	public void load(){
		
		nombreCartes.clear();
		
		Cursor result = stream.query("Cartes", null, "Nombre > 0", null, null, null, "Niveau ASC, Identifiant ASC");
		
		if (result != null)
		{
			if (result.moveToFirst()) { // deplace a 1e ligne
				do {

					int id = result.getInt(result.getColumnIndex("Identifiant"));
					int nombrecartes = result.getInt(result.getColumnIndex("Nombre"));
					DatabaseStream.nombreCartes.put(id, nombrecartes);
					
				}//traitement ce que ya de dans
				
				while (result.moveToNext()); // tant que ya une ligne après on refait le do
			}
				
			
		}
		
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
	
	
*/
	public ArrayList<Card> getAllCards() {
		return getAllCards(-1);
	}
	
	public ArrayList<Card> getAllCards(int filterByLevel) 
	{
		ArrayList<Card> cards = new ArrayList<Card>();
		
		String argNiveau;
		if (filterByLevel > 0) {
			argNiveau = Integer.toString(filterByLevel);
		} else {
			argNiveau = "%";
		}
		String arguments[] = { argNiveau };
		Cursor result = stream.query("Cartes", null, "Niveau LIKE ?", arguments, null, null, "Niveau ASC, Identifiant ASC");
		
		if (result != null)
		{
			if (result.moveToFirst()) { // deplace a 1e ligne
				do {
					
					cards.add(getCard(result)); //transforme ligne SQL en Card.
				}//traitement ce que ya de dans
				
				while (result.moveToNext()); // tant que ya une ligne après on refait le do
			}
				
			
		}
		
		return cards;
	}
/*
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

class SQLiteConnector extends SQLiteOpenHelper 
{
	public SQLiteConnector(Context context, String databaseName, int databaseVersion)
	{
		super(context, databaseName, null, databaseVersion);
	}
	
	public void onCreate(SQLiteDatabase db) 
	{
		db.execSQL("CREATE TABLE Cartes (Identifiant INTEGER NOT NULL, Nombre INTEGER NOT NULL, Niveau INTEGER NOT NULL, Element VARCHAR(10) NOT NULL, PRIMARY KEY (Identifiant) )");
		
		
		int key = 0;
		for(int i = 0; i < ListeCartes.defaut.size(); i++) {
			ContentValues cv = new ContentValues();
			
			
			key = ListeCartes.defaut.keyAt(i);
			// get the object by the key.
			Card card = ListeCartes.defaut.get(key);
			
			//put elements
			cv.put("Identifiant", key);
			cv.put("Nombre", 0);
			cv.put("Niveau", card.getLevel());
			cv.put("Element", card.element.toString());
			
			// insertion dans la database
			db.insert("Cartes", null, cv);
			ContentValues cv2 = new ContentValues();
			cv2.put("Nombre", 1);

			db.update("Cartes", cv2, "Niveau < 3", null);
			// \o/
			
		}
	}

	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
	{
		// TODO A enlever
		db.execSQL("DROP TABLE Cartes");
		onCreate(db);
		
		// En cas de changement dans la structure de la base de données, apporter les modifications ici aussi
	}
	
	public void close()
	{
		super.close();
	}
	
}}
