package com.example.covid_19info;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.example.covid_19info.Fragment.AwareFrag;
import com.example.covid_19info.Fragment.CountryFrag;
import com.example.covid_19info.Fragment.HelplineFrag;
import com.example.covid_19info.Fragment.HomeFrag;
import com.example.covid_19info.Fragment.IndiaFrag;
import com.example.covid_19info.Fragment.SymptomsFrag;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;


public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    TextView t1,t2,t3;
    Toolbar toolbar;
    ChipNavigationBar bottomNavigationView;
    CollapsingToolbarLayout collapsingToolbarLayout;

    DrawerLayout drawerLayout;
    NavigationView navigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        setContentView(R.layout.activity_main);


        viewINinit();

        toolbarSetup();

        if(savedInstanceState==null){

            bottomNavigationView.setItemSelected(R.id.home,true);
            Fragment homeFrag = new HomeFrag();
            FragmentManager fragmentManager=getSupportFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.replace(R.id.container,homeFrag).commit();
            t1.setText("Worldwide");
            t2.setText("Dashboard");
            t3.setText("COVID-19 Live Update");
            collapsingToolbarLayout.setTitle("Covid-19");

        }

        bottomSetup();



    }





    @Override
    public void onBackPressed() {

        if(backPressedTime + 1000 > System.currentTimeMillis()){

            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else{
            backToast = Toast.makeText(getBaseContext(), "Double Tap to exit",Toast.LENGTH_SHORT);
            backToast.show();
        }

        backPressedTime = System.currentTimeMillis();
    }

    private void bottomSetup() {




        bottomNavigationView.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
            @Override
            public void onItemSelected(int i) {

                switch(i){

                    case R.id.home:

                        Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                        Fragment homeFrag=new HomeFrag();
                        FragmentManager fragmentManager=getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fragmentTransaction.replace(R.id.container,homeFrag).commit();
                        t1.setText("Worldwide");
                        t2.setText("Dashboard");
                        t3.setText("COVID-19 Live Update");
                        collapsingToolbarLayout.setTitle("Covid-19");
                        break;

                    case R.id.india:

                        Toast.makeText(getApplicationContext(), "India", Toast.LENGTH_SHORT).show();
                        Fragment indiaFrag = new IndiaFrag();
                        FragmentManager fragmentManager1=getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction1=fragmentManager1.beginTransaction();
                        fragmentTransaction1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fragmentTransaction1.replace(R.id.container,indiaFrag).commit();
                        t1.setText("Indian");
                        t2.setText("Dashboard");
                        t3.setText("COVID-19 Live Update");
                        collapsingToolbarLayout.setTitle("#IndiaFightsCorona");

                        break;


                    case R.id.allCountry:

                        Toast.makeText(getApplicationContext(), "All Countries", Toast.LENGTH_SHORT).show();
                        Fragment countryFrag = new CountryFrag();
                        FragmentManager fragmentManager2=getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction2=fragmentManager2.beginTransaction();
                        fragmentTransaction2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fragmentTransaction2.replace(R.id.container,countryFrag).commit();
                        t1.setText("All Countries");
                        t2.setText("Dashboard");
                        t3.setText("COVID-19 Live Update");
                        collapsingToolbarLayout.setTitle("Country");
                        break;

                    case R.id.symptoms:

                        Toast.makeText(getApplicationContext(), "Symptoms", Toast.LENGTH_SHORT).show();
                        Fragment symptomsFrag = new SymptomsFrag();
                        FragmentManager fragmentManager3=getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction3=fragmentManager3.beginTransaction();
                        fragmentTransaction3.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fragmentTransaction3.replace(R.id.container,symptomsFrag).commit();
                        t1.setText("COVID-19");
                        t2.setText("Symptoms");
                        t3.setText("Indication of COVID-19");
                        collapsingToolbarLayout.setTitle("Symptoms");
                        break;
                }

            }
        });

    }

    private void toolbarSetup() {

        setSupportActionBar(toolbar);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Menu Button clicked", Toast.LENGTH_SHORT).show();

                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });

        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()){

                    case R.id.home:

                        bottomNavigationView.setItemSelected(R.id.home,true);
                        Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                        Fragment homeFrag=new HomeFrag();
                        FragmentManager fragmentManager=getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
                        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fragmentTransaction.replace(R.id.container,homeFrag).commit();
                        t1.setText("Worldwide");
                        t2.setText("Dashboard");
                        t3.setText("COVID-19 Live Update");
                        collapsingToolbarLayout.setTitle("Covid-19");
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        break;

                    case R.id.india:

                        bottomNavigationView.setItemSelected(R.id.india,true);
                        Toast.makeText(getApplicationContext(), "India", Toast.LENGTH_SHORT).show();
                        Fragment indiaFrag = new IndiaFrag();
                        FragmentManager fragmentManager1=getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction1=fragmentManager1.beginTransaction();
                        fragmentTransaction1.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fragmentTransaction1.replace(R.id.container,indiaFrag).commit();
                        t1.setText("Indian");
                        t2.setText("Dashboard");
                        t3.setText("COVID-19 Live Update");
                        collapsingToolbarLayout.setTitle("#IndiaFightsCorona");
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        break;

                    case R.id.allCountry:

                        bottomNavigationView.setItemSelected(R.id.allCountry,true);
                        Toast.makeText(getApplicationContext(), "All Countries", Toast.LENGTH_SHORT).show();
                        Fragment countryFrag = new CountryFrag();
                        FragmentManager fragmentManager2=getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction2=fragmentManager2.beginTransaction();
                        fragmentTransaction2.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fragmentTransaction2.replace(R.id.container,countryFrag).commit();
                        t1.setText("All Countries");
                        t2.setText("Dashboard");
                        t3.setText("COVID-19 Live Update");
                        collapsingToolbarLayout.setTitle("Country");
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.symptoms:

                        bottomNavigationView.setItemSelected(R.id.symptoms,true);
                        Toast.makeText(getApplicationContext(), "Symptoms", Toast.LENGTH_SHORT).show();
                        Fragment symptomsFrag = new SymptomsFrag();
                        FragmentManager fragmentManager3=getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction3=fragmentManager3.beginTransaction();
                        fragmentTransaction3.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fragmentTransaction3.replace(R.id.container,symptomsFrag).commit();
                        t1.setText("COVID-19");
                        t2.setText("Symptoms");
                        t3.setText("Indication of COVID-19");
                        collapsingToolbarLayout.setTitle("Symptoms");
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        break;

                    case R.id.covidAware:

                        Toast.makeText(getApplicationContext(), "AWARENESS", Toast.LENGTH_SHORT).show();
                        Fragment awareFrag=new AwareFrag();
                        FragmentManager fragmentManager5=getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction5=fragmentManager5.beginTransaction();
                        fragmentTransaction5.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fragmentTransaction5.replace(R.id.container,awareFrag).commit();
                        t1.setText("COVID-19");
                        t2.setText("Awareness");
                        t3.setText("#IndiaFightsCorona");
                        collapsingToolbarLayout.setTitle("awareness");
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        break;

                    case R.id.helpline:

                        Toast.makeText(getApplicationContext(), "Helpline", Toast.LENGTH_SHORT).show();
                        Fragment helpFrag=new HelplineFrag();
                        FragmentManager fragmentManager6=getSupportFragmentManager();
                        FragmentTransaction fragmentTransaction6=fragmentManager6.beginTransaction();
                        fragmentTransaction6.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        fragmentTransaction6.replace(R.id.container,helpFrag).commit();
                        t1.setText("COVID-19");
                        t2.setText("Helpline");
                        t3.setText("Helpline numbers in COVID-19");
                        collapsingToolbarLayout.setTitle("helpline");
                        drawerLayout.closeDrawer(Gravity.LEFT);
                        break;

                    case R.id.about:

                        Toast.makeText(getApplicationContext(), "About", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,AboutActivity.class);
                        startActivity(intent);
                        break;

                }

                return false;
            }
        });

    }

    private  void viewINinit(){

        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        t3 = findViewById(R.id.t3);



        toolbar=findViewById(R.id.toolbar);
        bottomNavigationView=findViewById(R.id.bottom_Menu);
        collapsingToolbarLayout=findViewById(R.id.collLayout);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navBar);

    }

}