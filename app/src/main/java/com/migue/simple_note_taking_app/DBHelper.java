package com.migue.simple_note_taking_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Calendar;

public class DBHelper extends SQLiteOpenHelper {
    private static final String TAG = "DBHelper";
    private static final String DB_NAME = "app_notes.db";
    private static final int DB_VERSION = 1;

    private static final String TABLE_NOTES = "notes";
    private static final String COL_ID = "id";
    private static final String COL_TITLE = "title";
    private static final String COL_BODY = "body";
    private static final String COL_CREATED_AT = "created_at";
    private static final String COL_UPDATED_AT = "updated_at";

    public DBHelper(Context context) {

     super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {

        String createNoteTable = "CREATE TABLE " + TABLE_NOTES+ "(" +
                                 COL_ID + " INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT, " +
                                 COL_TITLE + " TEXT, " +
                                 COL_BODY + " TEXT, " +
                                 COL_CREATED_AT + " TEXT, " +
                                 COL_UPDATED_AT + " TEXT" +
                                 ")";
        db.execSQL(createNoteTable);
        Log.d(TAG, createNoteTable);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public long insertNote(SQLiteDatabase db, String title, String body){
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);

        ContentValues cv = new ContentValues();
        cv.put(COL_TITLE, title);
        cv.put(COL_BODY, body);
        cv.put(COL_CREATED_AT, year + "-" + month + "-" + day);
        cv.put(COL_UPDATED_AT, year + "-" + month + "-" + day);

        return db.insert(TABLE_NOTES, null, cv);
    }
    //retrieval hehe
//    public String retriveNote(SQLiteDatabase db, long id) {
//        String getNote = "SELECT * FROM " + TABLE_NOTES +
//                " WHERE " + COL_ID + " = " + id;
//        String output = "";
//        Cursor cur = db.rawQuery(getNote, null);
//        cur.moveToFirst();
//        output = "Title: "+cur.getString(cur.getColumnIndex(COL_TITLE)) + "\nBody: " + cur.getString(cur.getColumnIndex(COL_BODY));
//        return output;
//    }
}
