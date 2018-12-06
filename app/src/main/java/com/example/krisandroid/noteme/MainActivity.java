package com.example.krisandroid.noteme;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> mTitle = new ArrayList<>();
    private ArrayList<String> mDate = new ArrayList<>();
    private ArrayList<NoteContent_Model> mNote = new ArrayList<>();

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutmanager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setContent_Note();
        initRecyclerview_Note();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private void setContent_Note(){
        NoteContent_Model nt = new NoteContent_Model("Cintaku","12/03/2018");
        mNote.add(nt);
        nt = new NoteContent_Model("Cintaku","12/03/2018");
        mNote.add(nt);
        nt = new NoteContent_Model("Cintaku","12/03/2018");
        mNote.add(nt);
        nt = new NoteContent_Model("Cintaku","12/03/2018");
        mNote.add(nt);
        nt = new NoteContent_Model("Cintaku","12/03/2018");
        mNote.add(nt);
        nt = new NoteContent_Model("Cintaku","12/03/2018");
        mNote.add(nt);
        nt = new NoteContent_Model("Cintaku","12/03/2018");
        mNote.add(nt);

    }

    private void  initRecyclerview_Note(){
        RecyclerView recyclerViewMain = findViewById(R.id.recyclerviewNote);
        recyclerViewMain.setHasFixedSize(true);

        layoutmanager = new LinearLayoutManager(this);
        recyclerViewMain.setLayoutManager(layoutmanager);

        NoteContent_Adapter mAdapter = new NoteContent_Adapter(this, mNote);
        recyclerViewMain.setAdapter(mAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.navigation, menu);
        return super.onCreateOptionsMenu(menu); }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent mIntent;
        switch (item.getItemId()) {
            case R.id.action_add:
                mIntent = new Intent(this, AddMainActivity.class);
                startActivity(mIntent);
                return true;
            case R.id.action_about:
                mIntent = new Intent(this, AboutActivity.class);
                startActivity(mIntent);
                return true;
//            case R.id.action_logout:
//                mIntent = new Intent(this, Welcome_MainActivity.class);
//                startActivity(mIntent);
//                return true;

            //hanya cek update,, yang bener noh di atas
            case R.id.action_logout:
                mIntent = new Intent(this, UpdateActivity.class);
                startActivity(mIntent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
