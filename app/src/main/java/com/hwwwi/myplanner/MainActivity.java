package com.hwwwi.myplanner;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    public static final String VIEWPAGER_FRAGMENT= "viewpager_fragment";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPagerFragment savedFragment = (ViewPagerFragment) getFragmentManager().
                findFragmentByTag(VIEWPAGER_FRAGMENT);

        if(savedFragment == null)
        {
            ViewPagerFragment fragment = new ViewPagerFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.placeHolder, fragment, VIEWPAGER_FRAGMENT);
            fragmentTransaction.commit();
        }
    }
}
