package com.example.jarek.smbproj3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "shopping_list.db";
    public static final String TABLE_NAME = "list";
    public static final String PRODUCT_NAME = "PRODUCT_NAME";
    public static final String PRICE = "PRICE";
    public static final String QUANTITY = "QUANTITY";
    public static final String IS_CHECKED = "IS_CHECKED";

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, 3);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT, PRODUCT_NAME TEXT, PRICE NUMERIC, QUANTITY INTEGER, IS_CHECKED INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void insertData(String productName, float price, Integer quantity, boolean is_checked) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(PRODUCT_NAME, productName);
        contentValues.put(PRICE, price);
        contentValues.put(QUANTITY, quantity);
        contentValues.put(IS_CHECKED, is_checked);

        SQLiteDatabase db = this.getWritableDatabase();
        double r = db.insert(TABLE_NAME, null, contentValues);
    }


    public Cursor getAllProducts() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return cursor;
    }


    public Cursor getProductWithId(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE ID=" + id, null);
        cursor.moveToFirst();

        return cursor;
    }

    public void updateProduct(int id, String productName, float price, int quantity, boolean is_checked) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(PRODUCT_NAME, productName);
        contentValues.put(PRICE, price);
        contentValues.put(QUANTITY, quantity);
        contentValues.put(IS_CHECKED, is_checked);

        SQLiteDatabase db = this.getWritableDatabase();
        double r = db.update(TABLE_NAME, contentValues, "ID=" + id, null);
    }
}
