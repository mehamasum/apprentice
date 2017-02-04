package com.batfia.apprentice;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.TextView;

import com.batfia.apprentice.todo.TodosMainActivity;

import com.batfia.apprentice.memento.activity.MementoMainActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        //getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, new MainFragment()).commit();




        //Set an icon for Nav Drawer Here
        // ab.setHomeAsUpIndicator(R.drawable.abc_ic_menu_selectall_mtrl_alpha);
        final android.support.v7.app.ActionBar ab = getSupportActionBar();
        ab.setDisplayHomeAsUpEnabled(true);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                drawer,
                toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    startActivity(new Intent(MainActivity.this, TestActivity.class));
                }

                else if (id == R.id.nav_note_books) {
                    startActivity(new Intent(MainActivity.this, MementoMainActivity.class));
                }

                else if (id == R.id.nav_todos) {
                    startActivity(new Intent(MainActivity.this, TodosMainActivity.class));
                }

                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;

            }
        });
        navigationView.getMenu().getItem(0).setChecked(true);
        TextView nav_profile = (TextView) navigationView.getHeaderView(0).findViewById(R.id.nav_header_profile);

        nav_profile.setText("No email");


    }
}
