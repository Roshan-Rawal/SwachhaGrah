package com.roshan_rawal.swachhagraha;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 8/29/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    SQLiteDatabase db;
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "Content.db";
    private static final String TABLE_NAME = "CONTENT";
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_USERNAME = "USERNAME";
    private static final String COLUMN_EMAIL = "EMAIL";
    private static final String COLUMN_PASS = "PASSWORD";

    /* Constructor */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }
    /*  On Create Method where we have to create in the table */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CONTENT (ID INTEGER PRIMARY KEY AUTOINCREMENT,USERNAME TEXT NOT NULL, EMAIL TEXT NOT NULL, PASSWORD TEXT NOT NULL)");
    }

    /* OnUpgrade method where we have to drop the table and then again create it */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //String Query = "DROP TABLE IF EXISTS" + TABLE_NAME;
        db.execSQL("DROP TABLE IF EXISTS CONTENT");
        onCreate(db);
    }

    /* This method is used for the inserting the data into table
      for that we wish to make database writable by below code
       */

    public Boolean insertData(String name, String email, String password) {
        db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_USERNAME,name);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_PASS, password);
        long result = db.insert(TABLE_NAME, null, values);
        if (result==-1)
            return false;
        else
            return true;
    }

    /* This function is for the checking the mail */
    public int checkMail(String s)
    {
        int flag=1;
        db=this.getReadableDatabase();
        String query="SELECT EMAIL FROM CONTENT";
        String a="Not Found";
        Cursor data =db.rawQuery(query,null);
        if(data.moveToFirst())
        {
            do{
                a=data.getString(0);
                if(a.equals(s))
                {
                    flag=0;
                    break;
                }
            }while (data.moveToNext());
            db.close();
    }
        if(flag==0)
        {
            return flag;
        }
        return flag;
    }

    /* searchPass is used for fetching tha data from database for that we
      need to make database readable by below code */

    public int searchPass (String str, String strPass)
    {
        int flag=2;
        db=this.getReadableDatabase();
        String query="SELECT USERNAME,PASSWORD FROM CONTENT";
        String a,b="Not Found";
        Cursor data =db.rawQuery(query,null);
        if(data.moveToFirst())
        {
            do{
                a=data.getString(0);
                if(a.equals(str))
                {
                    b=data.getString(1);
                    break;
                }
            }while (data.moveToNext());
            if(b.equals("Not Found"))
            {
                 flag=0;
                return flag;
            }
        db.close();
        }
        if(strPass.equals(b))
        {
            flag=1;
            return flag;
        }
        else
        {
            return flag;
        }
    }
}
