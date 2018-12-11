package com.example.krisandroid.noteme;

<<<<<<< HEAD
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
=======
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
>>>>>>> 60f1a7d2c8e0dbe4ac359ab9b2ad87ce1b8a5493
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
<<<<<<< HEAD
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.krisandroid.noteme.Adapter.NotemeAdapter;
import com.example.krisandroid.noteme.Models.Note;
import com.example.krisandroid.noteme.Models.NoteResponse;
import com.example.krisandroid.noteme.Rest.ApiClient;
import com.example.krisandroid.noteme.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
//
//    private ArrayList<String> mTitle = new ArrayList<>();
//    private ArrayList<String> mDate = new ArrayList<>();
//    private ArrayList<NoteContent_Model> mNote = new ArrayList<>();

    private RecyclerView mRecycleView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutmanager;
    Context mContext;
    private List<Note> mNote = new ArrayList<>();
    private String id_user;
=======
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
>>>>>>> 60f1a7d2c8e0dbe4ac359ab9b2ad87ce1b8a5493

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        Intent i = getIntent();
        id_user = i.getStringExtra("id_user");
        mContext = getApplicationContext();
        mRecycleView = (RecyclerView) findViewById(R.id.recyclerviewNote);
        layoutmanager = new LinearLayoutManager(mContext);
        mRecycleView.setLayoutManager(layoutmanager);
        //setContent_Note();
        initRecyclerview_Note();
        loadData();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void loadData(){
        ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<NoteResponse> noteAmbil = mApiInterface.tampilNote(id_user);
        noteAmbil.enqueue(new Callback<NoteResponse>() {
            @Override
            public void onResponse(Call<NoteResponse> call, Response<NoteResponse> response) {
                List<Note> listNote = response.body().getListNote();
                mAdapter = new NotemeAdapter(listNote);
                mRecycleView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<NoteResponse> call, Throwable t) {
                Log.d("Get Note", t.getMessage());
            }
        });
=======

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

>>>>>>> 60f1a7d2c8e0dbe4ac359ab9b2ad87ce1b8a5493
    }

    private void  initRecyclerview_Note(){
        RecyclerView recyclerViewMain = findViewById(R.id.recyclerviewNote);
        recyclerViewMain.setHasFixedSize(true);

        layoutmanager = new LinearLayoutManager(this);
        recyclerViewMain.setLayoutManager(layoutmanager);
<<<<<<< HEAD
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent mIntent;
        if (item.getItemId()==R.id.newNote){
            mIntent = new Intent(this, AddMainActivity.class);
            mIntent.putExtra("id_user", id_user);
            startActivity(mIntent);
            return true;
        }else if (item.getItemId()==R.id.actionAbout){
            mIntent = new Intent(this, AboutActivity.class);
            startActivity(mIntent);
            return true;
        }else if (item.getItemId()==R.id.actionLogout){
            Toast.makeText(MainActivity.this, "On Build!", Toast.LENGTH_LONG).show();
        }
            return  super.onOptionsItemSelected(item);

//        switch (item.getItemId()) {
//            case R.id.newNote:
//                mIntent = new Intent(this, AddMainActivity.class);
//                mIntent.putExtra("id_user",id_user);
//                startActivity(mIntent);
//                return true;
//            case R.id.actionAbout:
//                mIntent = new Intent(this, AboutActivity.class);
//                startActivity(mIntent);
//                return true;
//            case R.id.actionLogout:
//                mIntent = new Intent(this, Welcome_MainActivity.class);
//                startActivity(mIntent);
//                return true;
////            //hanya cek update,, yang bener noh di atas
////            case R.id.action_logout:
////                mIntent = new Intent(this, UpdateActivity.class);
////                startActivity(mIntent);
////                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }
=======

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
>>>>>>> 60f1a7d2c8e0dbe4ac359ab9b2ad87ce1b8a5493
    }

}
