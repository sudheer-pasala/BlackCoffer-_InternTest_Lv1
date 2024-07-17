package com.example.blackcofferinterntest;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toolbar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.MaterialToolbar;

import java.util.ArrayList;

public class Refine extends AppCompatActivity {
Spinner sp1;
EditText editext;
MaterialToolbar backIcon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
        EdgeToEdge.enable(this);
        setContentView(R.layout.refine);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ArrayList<String> spArr1= new ArrayList<>();
        sp1= findViewById(R.id.AvailabilitySpinner);
        spArr1.add("Available | Hey Let Us Connect");
        spArr1.add("Away | Stay Discrete And Watch");
        spArr1.add("Busy | Do Not Disturb | Will Catch Up Later");
        spArr1.add("SOS | Emergency! Need Assistance! HELP");

        ArrayAdapter<String> Spinner= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, spArr1);
        sp1.setAdapter(Spinner);

        EditText editText = (EditText) findViewById(R.id.statusInput);
        editText.getBackground().mutate().setColorFilter(Color.TRANSPARENT, PorterDuff.Mode.SRC_IN);

        Button btn =findViewById(R.id.btnsaveandExplore);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(Refine.this, MainActivity.class );
                startActivity(intent);
            }
        });

backIcon = findViewById(R.id.backIcon);
backIcon.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent =new Intent(Refine.this, MainActivity.class);
        startActivity(intent);
    }
});


    }
}