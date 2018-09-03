package com.roshan_rawal.swachhagraha;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.TextSliderView;

/**
 * Created by user on 8/31/2017.
 */

public class Tab1 extends Fragment {

    private DrawerLayout nDrawerLayout;
    private ActionBarDrawerToggle nToggle;
    ViewPager viewPager;
    SliderLayout sliderShow;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1, container, false);
       // slider();
        return rootView;
    }
    /* public void slider()
    {
        sliderShow = (SliderLayout) findViewById(R.id.slider);
        TextSliderView textSliderView = new TextSliderView(this);
        textSliderView
                .description("Game of Thrones")
                .image(R.drawable.logo);
        TextSliderView textSliderView2 = new TextSliderView(this);
        textSliderView
                .description("Game of Thrones")
                .image(R.drawable.logo);
        TextSliderView textSliderView3 = new TextSliderView(this);
        textSliderView
                .description("Game of Thrones")
                .image(R.drawable.logo);

        sliderShow.addSlider(textSliderView);
        sliderShow.addSlider(textSliderView2);
        sliderShow.addSlider(textSliderView3);

    } */

    /* @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(nToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStop() {
        sliderShow.stopAutoCycle();
        super.onStop();
    } */
}
/* class MainHomeActivity extends AppCompatActivity {
    private DrawerLayout nDrawerLayout;
    private ActionBarDrawerToggle nToggle;
    ViewPager viewPager;
    SliderLayout sliderShow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tab1);
        nDrawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);
        nToggle= new ActionBarDrawerToggle(this,nDrawerLayout,R.string.open,R.string.close);
        nDrawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        /* This code for slide show of the images

        sliderShow = (SliderLayout) findViewById(R.id.slider);

        TextSliderView textSliderView = new TextSliderView(this);
        textSliderView
                .description("Game of Thrones")
                .image(R.drawable.logo);
        TextSliderView textSliderView2 = new TextSliderView(this);
        textSliderView
                .description("Game of Thrones")
                .image(R.drawable.logo);
        TextSliderView textSliderView3 = new TextSliderView(this);
        textSliderView
                .description("Game of Thrones")
                .image(R.drawable.logo);

        sliderShow.addSlider(textSliderView);
        sliderShow.addSlider(textSliderView2);
        sliderShow.addSlider(textSliderView3);




       /* viewPager = (ViewPager) findViewById(R.id.viewPager);
        ViewPagerAdapter viewPagerAdapter =  new ViewPagerAdapter (this);
        viewPager.setAdapter(viewPagerAdapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(),2000,4000);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(nToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStop() {
        sliderShow.stopAutoCycle();
        super.onStop();
    }

} */

