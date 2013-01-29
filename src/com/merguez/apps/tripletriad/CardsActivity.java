package com.merguez.apps.tripletriad;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

public class CardsActivity extends FragmentActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.cards_activity);

        if (getSupportFragmentManager().findFragmentById(R.id.fragment1) == null) {
            Cards list = new Cards();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment1, list).commit();
        }
    }
}