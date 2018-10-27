package com.migue.simple_note_taking_app;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class Main2Activity extends AppCompatActivity {

    private static final String TAG = "Main2Activity";
    EditText title, body;
    SQLiteDatabase db;
    DBHelper dbhelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        title = findViewById(R.id.et_title);
        body = findViewById(R.id.et_content);

        dbhelper = new DBHelper(this);
        db = dbhelper.getWritableDatabase();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.save_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_save_note){
            long ins = dbhelper.insertNote(db, title.getText().toString(), body.getText().toString());
            if(ins > 0){
                Log.d(TAG, ins+" is Inserted!");
                title.setText("");
                body.setText("");
//                String out = dbhelper.retriveNote(db, ins);
//                Log.d(TAG, out);
                finish();
            }
        }
        return true;
    }
}
