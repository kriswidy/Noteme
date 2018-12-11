package com.example.krisandroid.noteme;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import com.example.krisandroid.noteme.Models.ResponseDelete;
import com.example.krisandroid.noteme.Rest.ApiClient;
import com.example.krisandroid.noteme.Rest.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UpdateActivity extends AppCompatActivity {
    String judul;
    EditText edTitle, edNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        Toolbar toolbar = (Toolbar) findViewById(R.id.btnBackUpdate);
        setSupportActionBar(toolbar);

        ActionBar menu = getSupportActionBar();
//        menu.setDisplayShowHomeEnabled(true);
//        menu.setDisplayHomeAsUpEnabled(true);
        edTitle = (EditText) findViewById(R.id.editTextTitle);
        edNote = (EditText) findViewById(R.id.edNoteUpdate);
        Intent i = getIntent();
        judul = i.getStringExtra("judul");
        edNote.setText(i.getStringExtra("note"));
        edTitle.setText(judul);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.updatenote_bar, menu);
        return super.onCreateOptionsMenu(menu); }
    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        Intent mIntent;
        if (item.getItemId()==R.id.btnUpdate){
            updateNote();
            return true;
        }else if (item.getItemId()==R.id.btnDelete){
            deleteNote();
            return true;
        }
        return  super.onOptionsItemSelected(item);

    }

    public void deleteNote(){
        ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseDelete> deleteNote = mApiInterface.deleteNote(judul);
        deleteNote.enqueue(new Callback<ResponseDelete>() {
            @Override
            public void onResponse(Call<ResponseDelete> call, Response<ResponseDelete> response) {
                String status = response.body().getStatus();
                if (status.equals("success")){
                    Toast.makeText(getApplicationContext(),"Delete berhasil",Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(),"Delete gagal",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseDelete> call, Throwable t) {

            }
        });
    }

    public void updateNote(){
        ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<ResponseDelete> updateNote = mApiInterface.updateNote(judul,edNote.getText().toString());
        updateNote.enqueue(new Callback<ResponseDelete>() {
            @Override
            public void onResponse(Call<ResponseDelete> call, Response<ResponseDelete> response) {
                String status = response.body().getStatus();
                if (status.equals("sukses")){
                    Toast.makeText(getApplicationContext(),"Update berhasil",Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(getApplicationContext(),"Update gagal",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseDelete> call, Throwable t) {

            }
        });

    }


}
