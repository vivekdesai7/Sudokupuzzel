package com.sudokupuzzel.sample.sudokupuzzel;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.sudokupuzzel.sample.sudokupuzzel.ui.GameFragment;


public class MainActivity extends AppCompatActivity {
    private FrameLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private MenuItem mCurrItem;

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        Fragment mFragment = GameFragment.newInstance("easy");
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.content, mFragment).commit();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_help) {

        }
        return super.onOptionsItemSelected(item);
    }

    @NonNull
    private Fragment getInstance(MenuItem item) {
        if (fragmentManager == null) {
            fragmentManager = getSupportFragmentManager();
        }
        Fragment fragment = fragmentManager.findFragmentByTag((String) item.getTitle());
        if (fragment == null) {
            switch (item.getItemId()) {
                case R.id.lv_easy:
                    fragment = GameFragment.newInstance("easy");
                    break;
                default:
                    throw new IllegalArgumentException("Unknown item");
            }
        }
        return fragment;
    }
}
