package com.example.jarek.smbproj3.list;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.jarek.smbproj3.DatabaseHandler;
import com.example.jarek.smbproj3.R;

public class AddProductActivity extends AppCompatActivity {

    private DatabaseHandler db;

    private EditText productName;
    private EditText price;
    private EditText quantity;
    private TextView emptyField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        db = new DatabaseHandler(this);

        productName = (EditText) findViewById(R.id.et_productName);
        price = (EditText) findViewById(R.id.et_price);
        quantity = (EditText) findViewById(R.id.et_quantity);
        emptyField = (TextView) findViewById(R.id.tv_empty_field);

    }

    public void addProduct(View view) {
        Intent intent = new Intent(AddProductActivity.this, ProductsListActivity.class);
        startActivity(intent);

        if (productName != null || price != null || quantity != null) {
            db.insertData(productName.getText().toString(), Float.valueOf(price.getText().toString()), Integer.valueOf(quantity.getText().toString()), false);
        } else {
            emptyField.setText("Nie wszystkie pola zostaly uzupelnione");
        }
    }

    public void goBack(View view) {
        Intent intent = new Intent(AddProductActivity.this, ProductsListActivity.class);
        startActivity(intent);
    }

}
