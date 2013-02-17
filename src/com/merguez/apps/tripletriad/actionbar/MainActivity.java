package com.merguez.apps.tripletriad.actionbar;

import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class MainActivity extends SherlockFragmentActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		// Affichage de l'action bar
		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		actionBar.setDisplayShowTitleEnabled(true);

		ActionBar.Tab tab1 = actionBar.newTab();
		tab1.setText("Jouer");
		tab1.setTabListener(new TabListener(0));
		actionBar.addTab(tab1);

		ActionBar.Tab tab2 = actionBar.newTab();
		tab2.setText("Mes Cartes");
		tab2.setTabListener(new TabListener(1));
		actionBar.addTab(tab2);

		// Charge l'onglet sélectionné
		if( savedInstanceState != null ) {
			getSupportActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt("tabActif"));
		}
		
		// Initialisation des préférences (1ere ouverture de l'appli)
		/*
        PreferenceManager.setDefaultValues(this, R.xml.network_preferences, false);
        PreferenceManager.setDefaultValues(this, R.xml.rules_preferences, false);
        
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		if (prefs.getBoolean(getString(R.string.pref_first_launch), true))
		{
	        DatabaseStream dbs = new DatabaseStream(this);        
			dbs.initCards();
			//dbs.getGils();
	        dbs.close();
	        
	        SharedPreferences.Editor editor = prefs.edit();
	        editor.putBoolean(getString(R.string.pref_first_launch), false);
	        editor.commit();
		}
		 */
	}


	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// Sauvegarde l'onglet sélectionné
		outState.putInt("tabActif",
				getSupportActionBar().getSelectedNavigationIndex());
		super.onSaveInstanceState(outState);
	}

}