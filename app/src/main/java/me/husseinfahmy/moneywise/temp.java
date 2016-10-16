package me.husseinfahmy.moneywise;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;


public class temp extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {


        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},2
                );

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        }


        super.onCreate(savedInstanceState);
        ArrayList<Category> categoryList = new ArrayList<>();

        //shopping
        //eatOut
        //entertainment
        //groceries

        ArrayList<String> transactions = new ArrayList<>();
        for (int j =0; j<20; j++)
        {
            transactions.add("TimHortans eatOut " + (3.0+j/10));
        }
        for (int j =7; j<10; j++)
        {
            transactions.add("NoFrills groceries " + (10+j) );
        }
        for (int j =3; j<6; j++)
        {
            transactions.add("Walmart shopping " + (25+j) );
        }
        for (int j =3; j<4; j++)
        {
            transactions.add("Movies entertainment "  + (12+j) );
        }

        ArrayList<Transaction> transactionsList = new ArrayList<>();


        Collections.shuffle(transactions);

        SimpleDateFormat format = new SimpleDateFormat("DD/MM/yyyy");

        int i = 1;
        for (String str : transactions)
        {
            String[] strA = str.split(" ");
            Transaction temp = new Transaction(strA[0], strA[1], strA[2]);
            try {
                temp.setDate(format.parse((i +"/10/2016")));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            transactionsList.add(temp);
            if (i<15)
            {
                i++;
            }
        }

        System.out.println(transactionsList);
        ArrayList<Category> categoryArray = new ArrayList<Category>();

        Category cat = new Category("eatOut");
        categoryArray.add(cat);
        Category cat2 = new Category("groceries");
        categoryArray.add(cat2);
        Category cat3 = new Category("shopping");
        categoryArray.add(cat3);
        Category cat4 = new Category("entertainment");
        categoryArray.add(cat4);

        for (Transaction trans : transactionsList)
        {
            for (Category category : categoryArray)
            {
                if (category.getName().equals(trans.getCategory()))
                {
                    System.out.println("hshshhshs");
                    category.getTransactions().add(trans);
                }
            }
        }

        for (Category category : categoryArray)
        {
            System.out.println(category.toString());
        }

        String fileName = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) +"/"+ "categoryList.bin";

        MainActivity.serialize(categoryList,(fileName));


    }

}
