package com.example.jarek.smbproj3.list;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.jarek.smbproj3.DatabaseHandler;
import com.example.jarek.smbproj3.R;

import java.util.ArrayList;

public class ProductsListActivity extends AppCompatActivity {
    private DatabaseHandler db = null;

    private ListView listView;
    private TextView messagesTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products_list);

        db = new DatabaseHandler(this);

        listView = (ListView) findViewById(R.id.products_list_view);
        messagesTextView = (TextView) findViewById(R.id.messages_text_view);
//        db.getProductWithId(1);
        displayProductList();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(view.getContext(), UpdateProductActivity.class);
                intent.putExtra("product_id", position + 1);
                startActivity(intent);
            }
        });
    }

    private void displayProductList() {
        Cursor data = db.getAllProducts();
        ArrayList<String> listData = new ArrayList<>();
        while (data.moveToNext()) {
            String str = data.getString(2) + "," + data.getString(1) + "," + data.getString(3) + ","+data.getString(4);
            listData.add(str);
        }

        ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, android.R.id.text1, listData);
        listView.setAdapter(listAdapter);

    }

    public void addProduct(View view) {
        Intent intent = new Intent(ProductsListActivity.this, AddProductActivity.class);
        startActivity(intent);
    }


}
