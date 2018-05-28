package com.example.isak.ipp;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class body extends AppCompatActivity {

    Switch handSwitch;
    Switch feetSwitch;
    Button btn1, btn2;
    boolean lHand = false;
    boolean lFoot = false;
    boolean back = true;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body);
        btn1 = findViewById(R.id.all);
        btn2 = findViewById(R.id.feet);
        mDrawerLayout = findViewById(R.id.drawerLayout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        boolean onoff = getIntent().getExtras().getBoolean("switch");
        handSwitch = findViewById(R.id.aSwitch);
        feetSwitch = findViewById(R.id.fSwitch);
        handSwitch.setChecked(onoff);
        feetSwitch.setChecked(onoff);
        lHand = lFoot = onoff;
        NavigationView navView = findViewById(R.id.navbar);

        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                if (item.getItemId()==R.id.add) {
                    Toast.makeText(body.this, "This is my Toast message!",
                            Toast.LENGTH_LONG).show();
                }
                mDrawerLayout.closeDrawers();
                return true;
            }
        });

        handSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    lHand = true;
                }
                else
                {
                    lHand = false;
                }
            }
        });
        feetSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    lFoot = true;
                }
                else
                {
                    lFoot = false;
                }
            }
        });
        btn1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                //startActivityForResult(new Intent(getApplicationContext(), hands.class), 999);
                Intent h = new Intent (body.this, hands.class);
                h.putExtra("switch", lHand);
                startActivity(h);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                Intent f = new Intent (body.this, feet.class);
                f.putExtra("switch", lFoot);
                startActivity(f);
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