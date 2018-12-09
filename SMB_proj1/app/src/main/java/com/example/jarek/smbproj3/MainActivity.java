package com.example.jarek.smbproj3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jarek.smbproj3.list.ProductsListActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void goToProductList(View view) {
        Intent intent = new Intent(MainActivity.this, ProductsListActivity.class);
        startActivity(intent);
    }

    public void goToOptions(View view) {
        Intent intent = new Intent(MainActivity.this, OptionsActivity.class);
        startActivity(intent);
    }
}

/*
    aby przejsc z ekranu glownego do listy produktow nalezy:
    - stworzyc nowy activity (ProductListActivity)
    - w pliku xml ekranu glownego dodac onClick listener (w tym przypadku dodalem "goToProductList")
    - zdefiniowac w klasie MainActivity.java metode goToProductList(view)

*/
