package com.example.krisandroid.noteme;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
    }

    private void  initRecyclerview_Note(){
        RecyclerView recyclerViewMain = findViewById(R.id.recyclerviewNote);
        recyclerViewMain.setHasFixedSize(true);

        layoutmanager = new LinearLayoutManager(this);
        recyclerViewMain.setLayoutManager(layoutmanager);
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

    }

}
