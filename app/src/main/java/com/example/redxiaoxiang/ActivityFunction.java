package com.example.redxiaoxiang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ActivityFunction extends AppCompatActivity {

    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;
    List<Fragment> fragments;
    MenuItem menuItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_function);
        viewPager=findViewById( R.id.ViewPager );
        bottomNavigationView=findViewById( R.id.BottomNavigationView );

        fragments=new ArrayList<>(  );
        fragments.add( new Fragment_HomePage() );
        fragments.add( new Fragment_BookSuggest() );
        fragments.add( new Fragment_ViewMap() );
        fragments.add( new Fragment_Discussion() );

        myAdatpter adatpter=new myAdatpter( getSupportFragmentManager(),fragments );
        viewPager.setAdapter( adatpter );
        bottomNavigationView.setOnNavigationItemSelectedListener( new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.item1:
                        viewPager.setCurrentItem( 0 );
                        break;
                    case R.id.item2:
                        viewPager.setCurrentItem( 1 );
                        break;
                    case R.id.item3:
                        viewPager.setCurrentItem( 2 );
                        break;
                    case R.id.item4:
                        viewPager.setCurrentItem( 3 );
                        break;
                    default:
                        break;
                }
                return true;
            }
        } );

        viewPager.addOnPageChangeListener( new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position , float positionOffset , int positionOffsetPixels) {
                //滚动的时候
            }
            @Override
            public void onPageSelected(int position) {
                //选择的时候
                if (menuItem == null) {
                    menuItem = bottomNavigationView.getMenu().getItem( 0 );
                }

                menuItem.setChecked( false );
                menuItem = bottomNavigationView.getMenu().getItem( position );
                menuItem.setChecked( true );
            }
            @Override
            public void onPageScrollStateChanged(int state) {
                //状态改变的时候
            }
        } );
    }

    private class myAdatpter extends FragmentPagerAdapter {
        private  List<Fragment>fragments;
        public myAdatpter(FragmentManager fm, List<Fragment>fragments) {
            super( fm );
            this.fragments=fragments;
        }
        @Override
        public Fragment getItem(int position) {
            return fragments.get( position );
        }
        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}