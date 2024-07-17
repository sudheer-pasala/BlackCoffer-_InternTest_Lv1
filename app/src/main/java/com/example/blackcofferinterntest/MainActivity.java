package com.example.blackcofferinterntest;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

TabLayout layout ;
ViewPager vp;
ImageView icon1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        icon1 = findViewById(R.id.refine);
        icon1.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Refine.class);
            startActivity(intent);
        });


        layout= findViewById(R.id.tabLayout);
                vp =findViewById(R.id.viewPager);

                ViewPagerAdapter VpAdapter = new ViewPagerAdapter(getSupportFragmentManager());
                vp.setAdapter(VpAdapter);

                layout.setupWithViewPager(vp);



    }
}