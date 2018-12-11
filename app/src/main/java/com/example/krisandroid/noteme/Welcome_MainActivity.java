package com.example.krisandroid.noteme;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.krisandroid.noteme.Models.User;
import com.example.krisandroid.noteme.Models.UserResponse;
import com.example.krisandroid.noteme.Rest.ApiClient;
import com.example.krisandroid.noteme.Rest.ApiInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Welcome_MainActivity extends AppCompatActivity {

    EditText edEmail,edPassword;
    TextView tvRegister;
    Button _loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome__main);
        edEmail = (EditText) findViewById(R.id.input_email);
        edPassword = (EditText) findViewById(R.id.input_password);
        tvRegister = (TextView) findViewById(R.id.link_signup);

        _loginButton = (Button)findViewById(R.id.btn_login);

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),SignUpActivity.class);
                startActivity(i);
            }
        });

        _loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiInterface mApiInterface =
                        ApiClient.getClient().create(ApiInterface.class);
                Call<UserResponse> mLogin = mApiInterface.loginRequest(edEmail.getText().toString());
                mLogin.enqueue(new Callback<UserResponse>() {
                    @Override
                    public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                        String status = response.body().getStatus();
                        if (status.equals("success")){
                            User user = response.body().getUser();
                            Intent intent = new Intent(Welcome_MainActivity.this , MainActivity.class);
                            intent.putExtra("id_user",user.getId_user().toString());
                            startActivity(intent);
                        }
                    }

                    @Override
                    public void onFailure(Call<UserResponse> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "fail login",Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
}
}
