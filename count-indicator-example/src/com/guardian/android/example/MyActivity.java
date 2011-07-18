package com.guardian.android.example;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.guardian.android.ui.CountIndicatorView;

public class MyActivity extends Activity
{
    private CountIndicatorView indicator;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        indicator = (CountIndicatorView) findViewById(R.id.indicator);
    }
    public void click(View view){
        //indicator.setNumberOfItems(indicator.getNumberOfItems() + 1);
        //indicator.setNumberSelected(3);
        //indicator.setSelectedColour(android.R.color.black);
        //indicator.setUnSelectedColour(android.R.color.black);
        //indicator.setRadius(20);
        indicator.setItemSpacing(15);
    }
}
