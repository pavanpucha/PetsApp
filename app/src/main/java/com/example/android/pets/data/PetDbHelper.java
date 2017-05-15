package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.android.pets.data.PetContract.PetEntry;
/**
 * Created by pavan on 4/25/2017.
 */

public class PetDbHelper extends SQLiteOpenHelper{
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "shelter.db";
    public static final String VAL_PAROPEN = "(";
    public static final String VAL_PARCLOSE = ")";
    public static final String SQL_CREATE_ENTRIES = "CREATE TABLE "+
            PetEntry.TABLE_NAME +" "+
            VAL_PAROPEN+
            PetEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT ,"
            + PetEntry.COLUMN_PET_NAME + " TEXT NOT NULL, "
            + PetEntry.COLUMN_PET_BREED + " TEXT, "
            + PetEntry.COLUMN_PET_GENDER + " INTEGER NOT NULL ,"
            + PetEntry.COLUMN_PET_WEIGHT + " INTEGER NOT NULL DEFAULT 0 "
    + VAL_PARCLOSE;
    public static final String SQL_DELETE_ENTRIES = "";

    public PetDbHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion){
        onUpgrade(db,oldVersion,newVersion);
    }

}
