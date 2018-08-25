package com.example.demo;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.TextView;

import com.example.demo.fragment.OneFragment;
import com.example.demo.fragment.TwoFragment;

public class MainNewActivity extends FragmentActivity implements View.OnClickListener {
    private TextView tab1, tab2, tab3;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private OneFragment oneFragment;
    private TwoFragment twoFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainnew);
        tab1 = findViewById(R.id.tab1);
        tab2 = findViewById(R.id.tab2);
        tab3 = findViewById(R.id.tab3);
        tab1.setOnClickListener(this);
        tab2.setOnClickListener(this);
        tab3.setOnClickListener(this);
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        if (oneFragment == null) {
            oneFragment = new OneFragment();
        }
        fragmentTransaction.add(R.id.home_frame, oneFragment);
        fragmentTransaction.commit();
    }


    public void hitFragment() {
        fragmentTransaction = fragmentManager.beginTransaction();
        if (oneFragment != null && oneFragment.isAdded()) {
            fragmentTransaction.hide(oneFragment);
        }
        if (twoFragment != null && twoFragment.isAdded()) {
            fragmentTransaction.hide(twoFragment);
        }
        fragmentTransaction.commit();
    }

    public void showFragment(int i) {
        fragmentTransaction = fragmentManager.beginTransaction();
        switch (i) {
            case 1:
                if (oneFragment == null) {
                    oneFragment = new OneFragment();
                    fragmentTransaction.add(R.id.home_frame, oneFragment);
                } else {
                    fragmentTransaction.show(oneFragment);
                }

                break;
            case 2:
                if (twoFragment == null) {
                    twoFragment = new TwoFragment();
                    fragmentTransaction.add(R.id.home_frame, twoFragment);
                } else {
                    fragmentTransaction.show(twoFragment);
                }

                break;
            case 3:
                if (twoFragment == null) {
                    twoFragment = new TwoFragment();
                    fragmentTransaction.add(R.id.home_frame, twoFragment);
                } else {
                    fragmentTransaction.show(twoFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onClick(View v) {
        hitFragment();
        switch (v.getId()) {
            case R.id.tab1:
                showFragment(1);
                break;
            case R.id.tab2:
                showFragment(2);
                break;
            case R.id.tab3:
                showFragment(3);
                break;
        }

    }
}
