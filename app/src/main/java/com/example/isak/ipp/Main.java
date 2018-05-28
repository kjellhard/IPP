package com.example.isak.ipp;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import static android.app.PendingIntent.getActivity;

public class Main extends AppCompatActivity {
    Switch allSwitch;
    Button btn1;
    boolean next = false;
    boolean back = true;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.all);
        mDrawerLayout = findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        allSwitch = findViewById(R.id.aSwitch);
        NavigationView navView = findViewById(R.id.navbar);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                if (item.getItemId()==R.id.add) {
                    Toast.makeText(Main.this, "This is my Toast message!",
                            Toast.LENGTH_LONG).show();
                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        allSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    next = true;
                }
                else
                {
                    next = false;
                }
            }
        });

        btn1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                //startActivityForResult(new Intent(getApplicationContext(), body.class), 999);
                Intent b = new Intent (Main.this, body.class);
                b.putExtra("switch", next);
                startActivity(b);
            }
        });
    }
    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == 999 && resultCode == Activity.RESULT_OK)
        {
            back = data.getBooleanExtra("save", false);
        }
    }*/
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
