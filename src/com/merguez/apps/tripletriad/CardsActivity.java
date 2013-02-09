package com.merguez.apps.tripletriad;

import com.merguez.apps.tripletriad.data.ListeCartes;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class CardsActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
        setContentView(R.layout.cards_activity);
        
        

        /*if (getSupportFragmentManager().findFragmentById(R.id.fragment1) == null) {
            Cards list = new Cards();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment1, list).commit();
        }
        if (getSupportFragmentManager().findFragmentById(R.id.fragment2) == null) {
            DetailCarte detail = new DetailCarte();
            detail.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragment2, detail).commit();
        }*/
        /*if (savedInstanceState == null) {
            DetailCarte detail = new DetailCarte();
            detail.setArguments(getIntent().getExtras());
            getSupportFragmentManager().beginTransaction().add(R.id.fragment2, detail).commit();
        	
        }*/
    }
}