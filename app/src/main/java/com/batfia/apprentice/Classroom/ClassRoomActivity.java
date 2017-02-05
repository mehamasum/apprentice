package com.batfia.apprentice.classroom;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.batfia.apprentice.R;
import com.batfia.apprentice.lib_navigationtabbar.ntb.NavigationTabBar;

import java.util.ArrayList;


public class ClassRoomActivity extends AppCompatActivity {


    DiscussionFragment discussionFragment;
    ClassmateFragment classmateFragment;
    MyActivitiesFragment myActivitiesFragment;

    NavigationTabBar navigationTabBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_room);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try {
            //noinspection ConstantConditions
            getSupportActionBar().setDisplayShowTitleEnabled(false);
        } catch (Exception ignored) {
        }


        initUI();
    }


    private void initUI() {

        // ntb
        final int color = getResources().getColor(R.color.colorPrimaryLight);
        navigationTabBar = (NavigationTabBar) findViewById(R.id.ntb_road_pal_activity);
        final ArrayList<NavigationTabBar.Model> models = new ArrayList<>();
        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.apple), color)
                        .build()
        );


        NavigationTabBar.Model.Builder builder = new NavigationTabBar.Model.Builder(
                getResources().getDrawable(R.drawable.apple), color);

        NavigationTabBar.Model model = builder.build();

        int notiCount = 0; //Util.getNoti(RoadPalActivity.this);
        model.setBadgeTitle(""+notiCount);
        if(notiCount>0)
            model.showBadge();

        models.add(model);


        models.add(
                new NavigationTabBar.Model.Builder(
                        getResources().getDrawable(R.drawable.apple), color)
                        .build()
        );

        navigationTabBar.setModels(models);




        // view pager

        final ViewPager viewPager = (ViewPager) findViewById(R.id.vp_road_pal_activity);
        viewPager.setOffscreenPageLimit(3);


        discussionFragment = new DiscussionFragment();
        classmateFragment = new ClassmateFragment();
        myActivitiesFragment = new MyActivitiesFragment();


        // adapter
        class MyPagerAdapter extends FragmentPagerAdapter {

            public MyPagerAdapter(android.support.v4.app.FragmentManager fm) {
                super(fm);
            }

            @Override
            public Fragment getItem(int pos) {
                switch(pos) {
                    case 0: return discussionFragment;
                    case 1: return classmateFragment;
                    case 2: return myActivitiesFragment;
                    default: return discussionFragment;
                }
            }

            @Override
            public int getCount() {
                return 3;
            }
        }

        viewPager.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));







        // set view pager

        navigationTabBar.setViewPager(viewPager, 0);
        navigationTabBar.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int position, final float positionOffset, final int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(final int position) {
            }

            @Override
            public void onPageScrollStateChanged(final int state) {

            }
        });

    }
}

