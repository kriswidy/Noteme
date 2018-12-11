package com.example.krisandroid.noteme;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
<<<<<<< HEAD
import android.widget.EditText;

public class AddMainActivity extends AppCompatActivity {
    EditText edJudul, edNote;

    String id_user;
=======

public class AddMainActivity extends AppCompatActivity {

>>>>>>> 60f1a7d2c8e0dbe4ac359ab9b2ad87ce1b8a5493
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_main);
<<<<<<< HEAD
=======

>>>>>>> 60f1a7d2c8e0dbe4ac359ab9b2ad87ce1b8a5493
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
<<<<<<< HEAD
        getMenuInflater().inflate(R.menu.updatenote_bar, menu);
=======
        getMenuInflater().inflate(R.menu.allnote_bar, menu);
>>>>>>> 60f1a7d2c8e0dbe4ac359ab9b2ad87ce1b8a5493
        return super.onCreateOptionsMenu(menu); }
    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent mIntent;
        switch (item.getItemId()) {
<<<<<<< HEAD
            case R.id.btnSave:
=======
            case R.id.openAllnote:
>>>>>>> 60f1a7d2c8e0dbe4ac359ab9b2ad87ce1b8a5493
                mIntent = new Intent(this, MainActivity.class);
                startActivity(mIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
