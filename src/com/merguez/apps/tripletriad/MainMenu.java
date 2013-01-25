package com.merguez.apps.tripletriad;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;

import com.merguez.apps.tripletriad.settings.SettingsActivity;
import com.merguez.apps.tripletriad.data.DatabaseStream;

/* 
 
public class MainMenu extends Activity implements OnClickListener
{
	private Typeface typeface;
	
	public void onCreate(Bundle savedInstanceState) 
    {
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.menu);
        
        PreferenceManager.setDefaultValues(this, R.xml.network_preferences, false);
        PreferenceManager.setDefaultValues(this, R.xml.rules_preferences, false);
        
        //Typeface tempTF = Typeface.createFromAsset(getAssets(), "ff8font.ttf");
        //typeface = Typeface.create(tempTF, Typeface.BOLD);
        
        initMenuItem((TextView) findViewById(R.id.settings));
        initMenuItem((TextView) findViewById(R.id.demo));
        initMenuItem((TextView) findViewById(R.id.solo));
        initMenuItem((TextView) findViewById(R.id.cards));
        
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
    }
	
	private void initMenuItem(TextView menu) {
		menu.setOnClickListener(this);
		//menu.setTypeface(typeface);
	}

	@Override
	public void onClick(View v) {
		
		int id = v.getId();
		Intent i = new Intent(this, Game.class);
		
		switch (id) {
		case R.id.settings:
			startActivity(new Intent(this, SettingsActivity.class));
			break;
		case R.id.solo:
			i.putExtra(getString(R.string.param_bot_vs_bot), false);
			i.putExtra(getString(R.string.param_pvp), false);
			startActivity(i);
			break;
		case R.id.cards:
			Intent intent = new Intent(this, Cards.class);
			startActivity(intent);
			break;
		case R.id.demo:
			i.putExtra(getString(R.string.param_bot_vs_bot), true);
			i.putExtra(getString(R.string.param_pvp), false);
			startActivity(i);
			break;
		}
		
	}
	
}*/
