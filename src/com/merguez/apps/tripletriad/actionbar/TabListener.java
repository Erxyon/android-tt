package com.merguez.apps.tripletriad.actionbar;

import android.os.Debug;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

import com.actionbarsherlock.app.ActionBar;
import com.actionbarsherlock.app.ActionBar.Tab;
import com.merguez.apps.tripletriad.CardsActivity;
import com.merguez.apps.tripletriad.Jouer;
import com.merguez.apps.tripletriad.MesCartes;

public class TabListener implements ActionBar.TabListener
{
	private Fragment mFragment;
	private int num;
	
	public TabListener(int num) {
		this.num = num;
	}
	
	@Override
	public void onTabSelected(Tab tab, FragmentTransaction ft) {

		Log.d("ActionBar", num+" onTabSelected : "+tab.getPosition());
		String tag = "merguez";
		// Check if the fragment is already initialized
		if (mFragment == null) {
			Log.d("ActionBar", num+" onTabSelected : fragment null");
			// If not, instantiate and add it to the activity
			switch(tab.getPosition()) {
			case 0:
				mFragment = (Fragment) new Jouer();
				tag = "jouer";
				break;
			case 1:
				mFragment = (Fragment) new MesCartes();
				tag = "mesCartes";
				break;
			}

			if (mFragment != null) {
				Log.d("ActionBar", num+" onTabSelected : fragment replace");
				ft.replace(android.R.id.content, mFragment, tag); 
			}

		} else {
			Log.d("ActionBar", num+" onTabSelected : fragment existe");
			// If it exists, simply attach it in order to show it
			if (mFragment.isDetached()) {
				Log.d("ActionBar", num+" onTabSelected : fragment attach");
				ft.attach(mFragment);
			}
			
		}
	}
	@Override
	public void onTabUnselected(Tab tab, FragmentTransaction ft) {
		Log.d("ActionBar", num+" onTabUnselected : "+tab.getPosition());
		if (mFragment != null) {
			Log.d("ActionBar", num+" onTabUnselected : detach fragment");
			// Detach the fragment, because another one is being attached
			ft.detach(mFragment);
		}
	}
	@Override
	public void onTabReselected(Tab tab, FragmentTransaction ft) {
		Log.d("ActionBar", num+" onTabReselected : "+tab.getPosition());
		// User selected the already selected tab. Usually do nothing.
	}
}
