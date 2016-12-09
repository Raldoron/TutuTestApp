package com.example.raldoron.tututestapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        recyclerView = (RecyclerView) findViewById(R.id.left_drawer);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        if (savedInstanceState != null) return;
        final Fragment fragmentSchedule = BlankFragment.getInstance();
        final Fragment fragmentAbout = AboutFragment.getInstance();
        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.content, fragmentSchedule);
        transaction.commitAllowingStateLoss();


        adapter = new NavigationAdapter(getResources().getStringArray(R.array.drawer),
                new NavigationOnClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        drawerLayout.closeDrawer(recyclerView);

                        if (position == 0){
                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.content, fragmentSchedule);
                            transaction.commitAllowingStateLoss();
                        }
                        else if (position == 1){
                            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                            transaction.replace(R.id.content, fragmentAbout);
                            transaction.commitAllowingStateLoss();
                        }

                    }
                });
        recyclerView.setAdapter(adapter);


    }

}
