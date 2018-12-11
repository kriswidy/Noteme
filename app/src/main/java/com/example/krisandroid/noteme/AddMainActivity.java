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

import com.example.krisandroid.noteme.Models.AddNote;
import com.example.krisandroid.noteme.Models.AddNoteResponse;
import com.example.krisandroid.noteme.Models.RegistrasiUser;
import com.example.krisandroid.noteme.Rest.ApiClient;
import com.example.krisandroid.noteme.Rest.ApiInterface;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddMainActivity extends AppCompatActivity {
    EditText medJudul, medNote;
    String formatTanggal;
    String id_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.btnBackAdd);
        setSupportActionBar(toolbar);
        ActionBar menu = getSupportActionBar();
//        menu.setDisplayShowHomeEnabled(true);
//        menu.setDisplayHomeAsUpEnabled(true);
        medJudul = (EditText) findViewById(R.id.edJudul);
        medNote = (EditText) findViewById(R.id.edNote);
        Intent i = getIntent();
        id_user = i.getStringExtra("id_user");
        Date c = Calendar.getInstance().getTime();
        System.out.println("Current time => " + c);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        formatTanggal = df.format(c);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.allnote_bar, menu);
        return super.onCreateOptionsMenu(menu); }
    @Override

    public boolean onOptionsItemSelected(MenuItem item) {
        Intent mIntent;
        switch (item.getItemId()) {
            case R.id.btnSave:
                tambahData();
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void tambahData(){
        ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<AddNoteResponse> tbUser = mApiInterface.tambahNote(id_user,medJudul.getText().toString(),medNote.getText().toString(),formatTanggal);
        tbUser.enqueue(new Callback<AddNoteResponse>() {
            @Override
            public void onResponse(Call<AddNoteResponse> call, Response<AddNoteResponse> response) {
                if (response.body().getStatus().equals("fail")){
                    Toast.makeText(getApplicationContext(),response.body().getStatus(),Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),response.body().getStatus(),Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<AddNoteResponse> call, Throwable t) {

            }
        });
    }
}
