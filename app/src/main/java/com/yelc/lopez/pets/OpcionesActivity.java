package com.yelc.lopez.pets;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.transition.Explode;
import android.view.Menu;
import android.view.MenuItem;

import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.Toast;

import com.yelc.lopez.pets.ActivitysDB.ClienteActivity;
import com.yelc.lopez.pets.ActivitysDB.NewClienteMascotaActivity;
import com.yelc.lopez.pets.fragments.ProductoFragment;
import com.yelc.lopez.pets.fragments.ReservacionFragment;
import com.yelc.lopez.pets.fragments.ServicesFragment;

public class OpcionesActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);
        this.setTitle("Veterinaria ");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabAt(1).select();
        //tabLayout.setSelectedTabIndicatorColor(Color.BLACK);
        tabLayout.setTabTextColors(getResources().getColor(R.color.colorAccent),Color.WHITE);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.newServicio) {
            nextActivity(NewClienteMascotaActivity.class,null);
            return true;
        }
        else if (id == R.id.newCliente) {
            nextActivity(ClienteActivity.class,null);
            return true;
        }
        else if (id == R.id.newProducto) {
            Toast.makeText(this,"Producto",Toast.LENGTH_SHORT).show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new ReservacionFragment();
                case 1:
                    return new ServicesFragment();
                case 2:
                    return new ProductoFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getString(R.string.tab1);
                case 1:
                    return getResources().getString(R.string.tab2);
                case 2:
                    return getResources().getString(R.string.tab3);
            }
            return null;
        }
    }

    public void nextActivity(Class activity, View view){
        Intent intent = new Intent(this,activity);

        if  (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            Explode explode = new Explode();
            explode.setDuration(1000);
            explode.setInterpolator(new DecelerateInterpolator());
            getWindow().setExitTransition(explode);
            this.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation(this).toBundle());
        }else{
            this.startActivity(intent);
        }
    }

}
