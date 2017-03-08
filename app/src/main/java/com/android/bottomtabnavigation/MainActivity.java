package com.android.bottomtabnavigation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton mFirstTab, mSecondTab, mThirdTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirstTab = (ImageButton) findViewById(R.id.first_tab);

        mSecondTab = (ImageButton) findViewById(R.id.second_tab);

        mThirdTab = (ImageButton) findViewById(R.id.third_tab);

        mFirstTab.setOnClickListener(this);
        mSecondTab.setOnClickListener(this);
        mThirdTab.setOnClickListener(this);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.container, new FirstTabFragment()).commit();
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first_tab:
                getFragmentManager().beginTransaction().replace(R.id.container, new FirstTabFragment()).commit();
                break;
            case R.id.second_tab:
                getFragmentManager().beginTransaction().replace(R.id.container, new SecondTabFragment()).commit();
                break;
            case R.id.third_tab:
                getFragmentManager().beginTransaction().replace(R.id.container, new ThirdTabFragment()).commit();
                break;
        }
    }
}
