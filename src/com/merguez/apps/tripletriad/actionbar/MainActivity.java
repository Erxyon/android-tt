package com.merguez.apps.tripletriad.actionbar;

import android.os.Bundle;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.SherlockFragmentActivity;

public class MainActivity extends SherlockFragmentActivity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		actionBar.setDisplayShowTitleEnabled(true); // opt

		ActionBar.Tab tab1 = actionBar.newTab();
		tab1.setText("Jouer");
		tab1.setTabListener(new TabListener(0));
		actionBar.addTab(tab1);

		ActionBar.Tab tab2 = actionBar.newTab();
		tab2.setText("Mes Cartes");
		tab2.setTabListener(new TabListener(1));
		actionBar.addTab(tab2);

		if( savedInstanceState != null ){
			getSupportActionBar().setSelectedNavigationItem(
					savedInstanceState.getInt("tabActif"));
		}
	}


	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// save active tab
		outState.putInt("tabActif",
				getSupportActionBar().getSelectedNavigationIndex());
		super.onSaveInstanceState(outState);
	}

}