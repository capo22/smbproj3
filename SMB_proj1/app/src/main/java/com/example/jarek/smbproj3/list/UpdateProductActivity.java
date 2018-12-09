package com.example.jarek.smbproj3.list;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.jarek.smbproj3.DatabaseHandler;
import com.example.jarek.smbproj3.R;

public class UpdateProductActivity extends AppCompatActivity {

    private DatabaseHandler db;

    private Integer productId;

    private EditText productName;
    private EditText price;
    private EditText quantity;
    private CheckBox is_checked;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);

        productName = (EditText) findViewById(R.id.et_productName);
        price = (EditText) findViewById(R.id.et_price);
        quantity = (EditText) findViewById(R.id.et_quantity);
        is_checked = (CheckBox) findViewById(R.id.ch_isChecked);


        Intent intent = getIntent();
        productId = intent.getIntExtra("product_id", 0);

        db = new DatabaseHandler(this);
        Cursor product = db.getProductWithId(productId);

        productName.setText(product.getString(1));
        price.setText(product.getString(2));
        quantity.setText(product.getString(3));
        if (product.getString(4) == "0") {
            is_checked.setChecked(false);
        } else {
            is_checked.setChecked(true);
        }
    }

    public void updateProduct(View view) {
        Intent intent = new Intent(UpdateProductActivity.this, ProductsListActivity.class);
        startActivity(intent);

        if (productName != null || price != null || quantity != null) {
            db.updateProduct(productId, productName.getText().toString(), Float.valueOf(price.getText().toString()), Integer.valueOf(quantity.getText().toString()), is_checked.isChecked());
        }
    }

    public void goBack(View view) {
        Intent intent = new Intent(UpdateProductActivity.this, ProductsListActivity.class);
        startActivity(intent);
    }
}
