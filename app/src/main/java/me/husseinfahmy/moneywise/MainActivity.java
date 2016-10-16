package me.husseinfahmy.moneywise;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = new Intent(MainActivity.this, RecommendationsActivity.class);
        startActivity(intent);


        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        ArrayList<Category> categoryList = deserialize(getResources().openRawResource(R.raw.category_list));
        Date today = new Date();
        long thirtyInSec = 2592000000L;
        Date thirtyDaysAgo = new Date((today.getTime() - thirtyInSec));
        int totalCount = 0;
        float totalSpent =0;
        for (Category cat : categoryList)
        {
            int categoryCount = 0;
            float categorySpent = 0;
            for (Transaction transaction : cat.getTransactions())
            {
                categoryCount++;
                totalCount++;
                categorySpent = categorySpent + transaction.getCost();
                totalSpent = totalSpent + transaction.getCost();
                if (transaction.getDate().compareTo(thirtyDaysAgo)<0)
                {
                    cat.getTransactions().remove(transaction);
                }
            }
            cat.setTotalCount(categoryCount);
            cat.setTotalSpent(categorySpent);
        }


        Profile me = new Profile(10000,0,7000,0,"dude");
        me.setTotalCount(totalCount);
        me.setTotalSpent(totalSpent);
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_food) {
            // Handle the camera action
        } else if (id == R.id.nav_entertainment) {

        } else if (id == R.id.nav_shopping) {

        } else if (id == R.id.nav_groceries) {

        } else if (id == R.id.nav_settings) {}





        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public static void serialize(ArrayList<Category> arrayList, String fileName)
    {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(new File(fileName))));
            oos.writeObject(arrayList);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static ArrayList<Category> deserialize(String fileName) {
        ArrayList<Category> result = new ArrayList<>();

        try {
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(new File(fileName))));
            result = (ArrayList<Category>) ois.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static ArrayList<Category> deserialize(InputStream in) {
        ArrayList<Category> result = new ArrayList<>();

        try {
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(in));
            result = (ArrayList<Category>) ois.readObject();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return result;
    }
}

