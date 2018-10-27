
package com.migue.simple_note_taking_app;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    SQLiteDatabase db = null;
    private static DBHelper dbhelper = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbhelper = new DBHelper(this);
//        long id = dbhelper.insertNote(db, "MY CLASSMATE", "Jarell Vhan Vequizo");
//        Log.d(TAG, id+" is Inserted!");
//        db.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_save_note){
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
        }
        return true;
    }
}
