package com.example.android.footballcounter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME="Football.db";
    public static final String TABLE_NAME="Score_card";
    public static final String COL_1="MATCH_NO";
    public static final String COL_2="Team_A";
    public static final String COL_3="SCORE_A";
    public static final String COL_4="TEAM_B";
    public static final String COL_5="SCORE_B";
    public static final String COL_6="STATUS";
    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table " +TABLE_NAME +"(MATCH_NO INTEGER PRIMARY KEY AUTOINCREMENT,TEAM_A TEXT,SCORE_A INTENGER,TEAM_B TEXT,SCORE_B INTEGER,STATUS TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    onCreate(db);
    }
    public boolean insertdata(String team_a,int score_a,String team_b,int score_b, String status)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,team_a);
        contentValues.put(COL_3,score_a);
        contentValues.put(COL_4,team_b);
        contentValues.put(COL_5,score_b);
        contentValues.put(COL_6,status);
       long result= db.insert(TABLE_NAME,null,contentValues);
       if(result==-1)
       {
           return false;
       }
       else
           return true;
    }
    public Cursor getAllData()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+ TABLE_NAME,null);
        return res;
    }
//    public boolean UpdateData(String id, String name, String surname, String Marks){
//        SQLiteDatabase db=this.getWritableDatabase();
//        ContentValues contentValues=new ContentValues();
//        contentValues.put(COL_1,id);
//        contentValues.put(COL_2,name);
//        contentValues.put(COL_3,surname);
//        contentValues.put(COL_4,Marks);
//        db.update(TABLE_NAME,contentValues,"ID = ?",new String[] {id});
//        return true;
//    }
//    public int DeleteData(String id)
//    {
//        SQLiteDatabase db=this.getWritableDatabase();
//        return db.delete(TABLE_NAME,"ID=?",new String[] {id});
//
//    }
}
