package com.example.testandroid;

import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import java.util.zip.Inflater;

public class FisicaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fisica);

        //declaració del toolbar
        Toolbar toolbar = findViewById(R.id.toolbarFisica);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.fisica));

        //declaració del tablayout
        final TabLayout tabLayout = findViewById(R.id.tabLayoutFisica);
        final ViewPager viewPager = findViewById(R.id.viewPagerFisica);
        final ViewPageAdapter adapter = new ViewPageAdapter(getSupportFragmentManager());

        //afegir les tabs per anar als diferents fragments
        adapter.addFragment(new FragmentCaidaLibre(), getString(R.string.freeFall));
        adapter.addFragment(new FragmentMru(), getString(R.string.mru));
        adapter.addFragment(new FragmentMcu(), getString(R.string.mcu));
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //creació del botó per tornar al homepage
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.ic_arrow_back_black_24dp));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.info_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.info_menu) {
            String url = "https://github.com/jafeth12/TreballdeRecerca";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
            return true;
        } else
            return super.onOptionsItemSelected(item);
        }

}


