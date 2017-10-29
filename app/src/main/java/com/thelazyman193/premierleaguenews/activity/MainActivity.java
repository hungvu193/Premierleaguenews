package com.thelazyman193.premierleaguenews.activity;


import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.thelazyman193.premierleaguenews.BaseActivity;
import com.thelazyman193.premierleaguenews.R;
import com.thelazyman193.premierleaguenews.adapter.PagerMainAdapter;
import com.thelazyman193.premierleaguenews.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {
    @BindView(R.id.bottom_navigation)
    AHBottomNavigation bottomNavigation;
    @BindView(R.id.viewpager)
    ViewPager viewPager;
    //13/05/2018 - end of premier league 2017-2017
    private String result;
    private Utils utils = Utils.getInstance();
    private String TAG = "MainActivity";
    private PagerMainAdapter mainPagerAdapter;

    // team - bxh - news - about
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViewPager();
        initBottomBar();
    }

    public void initBottomBar() {
        AHBottomNavigationItem item1 = new AHBottomNavigationItem("Chart", R.mipmap.ic_chart);
//        AHBottomNavigationItem item2 = new AHBottomNavigationItem("Team", R.mipmap.ic_team);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem("News", R.mipmap.ic_news);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem("Fixtures", R.mipmap.ic_fixture);
        AHBottomNavigationItem item5 = new AHBottomNavigationItem("More", R.mipmap.ic_more);
        bottomNavigation.setBehaviorTranslationEnabled(false);

        bottomNavigation.addItem(item1);
//        bottomNavigation.addItem(item2);
        bottomNavigation.addItem(item3);
        bottomNavigation.addItem(item4);
        bottomNavigation.addItem(item5);
        bottomNavigation.setDefaultBackgroundColor(Color.parseColor("#38003c"));
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
        bottomNavigation.setAccentColor(Color.parseColor("#FFFFFF"));
        bottomNavigation.setTranslucentNavigationEnabled(true);
        bottomNavigation.setCurrentItem(0);
        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public boolean onTabSelected(int position, boolean wasSelected) {

                viewPager.setCurrentItem(position);
                return true;
            }
        });


    }

    public void initViewPager() {
        mainPagerAdapter = new PagerMainAdapter(getSupportFragmentManager());
        viewPager.setAdapter(mainPagerAdapter);
        viewPager.setOffscreenPageLimit(5);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                bottomNavigation.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!isNetworkAvailable()) {
            Toast.makeText(this, "No connection! Please try again", Toast.LENGTH_SHORT).show();
        }
    }
}

