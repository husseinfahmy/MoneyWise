package me.husseinfahmy.moneywise;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;


public class temp extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {

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
        ArrayList<Category> catagoryArray = new ArrayList<Category>();

        Category cat = new Category("eatOut");
        catagoryArray.add(cat);
        Category cat2 = new Category("groceries");
        catagoryArray.add(cat2);
        Category cat3 = new Category("shopping");
        catagoryArray.add(cat3);
        Category cat4 = new Category("entertainment");
        catagoryArray.add(cat4);

        for (Transaction trans : transactionsList)
        {
            for (Category category : catagoryArray)
            {
                if (category.getName().equals(trans.getCategory()))
                {
                    category.getTransactions().add(trans);
                }
            }
        }

        for (Category category : catagoryArray)
        {
            System.out.println(category.toString());
        }

        String fileName = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) +"/"+ "categoryList.bin";

        MainActivity.serialize(categoryList,(fileName));
    }

}
