package com.merguez.apps.tripletriad.actionbar;

import java.util.List;
import java.util.Vector;

import com.merguez.apps.tripletriad.Jouer;
import com.merguez.apps.tripletriad.MesCartes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.Activity;
import android.app.FragmentTransaction;

import com.merguez.apps.tripletriad.R;

public class MainActivity extends FragmentActivity {
	
	private ViewPager mViewPager;
	private CustomPagerAdapter pagerAdapter;
	private ActionBar actionBar;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.main_activity);
		
		List<Fragment> fragments = new Vector<Fragment>();
		fragments.add(Fragment.instantiate(this, Jouer.class.getName()));
		fragments.add(Fragment.instantiate(this, MesCartes.class.getName()));
		
		pagerAdapter = new CustomPagerAdapter(getSupportFragmentManager(), fragments);
		mViewPager = (ViewPager) findViewById(R.id.viewPager);
		mViewPager.setAdapter(pagerAdapter);

		// Affichage de l'action bar
		actionBar = getActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		actionBar.setDisplayShowTitleEnabled(true); // ?

		CustomTabListener tabListener = new CustomTabListener();
		ActionBar.Tab tab1 = actionBar.newTab();
		tab1.setText("Jouer");
		tab1.setTabListener(tabListener);
		actionBar.addTab(tab1);

		ActionBar.Tab tab2 = actionBar.newTab();
		tab2.setText("Mes Cartes");
		tab2.setTabListener(tabListener);
		actionBar.addTab(tab2);
		
		mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
			@Override
			public void onPageSelected(int position) {
				actionBar.setSelectedNavigationItem(position);
			}
		});

		// Charge l'onglet sélectionné
		if (savedInstanceState != null) {
			actionBar.setSelectedNavigationItem(
					savedInstanceState.getInt("tabActif", 0));
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
	public boolean onCreateOptionsMenu(Menu menu) {
	    // Inflate the menu items for use in the action bar
	    MenuInflater inflater = getMenuInflater();
	    //inflater.inflate(R.menu.menu_action_bar, menu);
	    return super.onCreateOptionsMenu(menu);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle presses on the action bar items
	    switch (item.getItemId()) {
	        case R.id.menu_settings:
	            // ???
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// Sauvegarde l'onglet sélectionné
		outState.putInt("tabActif",
				getActionBar().getSelectedNavigationIndex());
		super.onSaveInstanceState(outState);
	}
	
	class CustomPagerAdapter extends FragmentPagerAdapter {

		private List<Fragment> fragments;
		
		public CustomPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
			super(fm);
			this.fragments = fragments;
		}
		
		@Override
		public int getCount() {
			return this.fragments.size();
		}
		
		@Override
		public Fragment getItem(int i) {
			return this.fragments.get(i);
		}
		
	}
	
	class CustomTabListener implements ActionBar.TabListener {

		@Override
		public void onTabReselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTabSelected(Tab tab, FragmentTransaction ft) {
			mViewPager.setCurrentItem(tab.getPosition());
		}

		@Override
		public void onTabUnselected(Tab tab, FragmentTransaction ft) {
			// TODO Auto-generated method stub
			
		}
		
	}

}