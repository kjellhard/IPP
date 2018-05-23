package com.example.isak.ipp;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class Main extends AppCompatActivity {
    Button btn1, btn2;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.hands);
        btn2 = findViewById(R.id.feet);
        mDrawerLayout = findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        btn1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent h = new Intent (Main.this, hands.class);
                startActivity(h);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent f = new Intent (Main.this, feet.class);
                startActivity(f);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
