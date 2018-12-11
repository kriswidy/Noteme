package com.example.krisandroid.noteme;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.krisandroid.noteme.Models.RegistrasiUser;
import com.example.krisandroid.noteme.Rest.ApiClient;
import com.example.krisandroid.noteme.Rest.ApiInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {
//    private static final String TAG = "SignupActivity";
//
//    @BindView(R.id.input_name) EditText _nameText;
//    @BindView(R.id.input_email) EditText _emailText;
//    @BindView(R.id.input_password) EditText _passwordText;
//    @BindView(R.id.btn_signup) Button _signupButton;
//    @BindView(R.id.link_login) TextView _loginLink;
    EditText edUsername,edPassword,edEmail;
    Button btRegister;
    TextView btnLinklogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edUsername = (EditText) findViewById(R.id.input_name);
        edEmail = (EditText) findViewById(R.id.input_email);
        edPassword = (EditText) findViewById(R.id.input_password);
        btRegister = (Button) findViewById(R.id.btn_signup);

        btRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApiInterface mApiInterface = ApiClient.getClient().create(ApiInterface.class);
                Call<RegistrasiUser> userBaru = mApiInterface.regisUser(edEmail.getText().toString(),edUsername.getText().toString(),edPassword.getText().toString());

                userBaru.enqueue(new Callback<RegistrasiUser>() {
                    @Override
                    public void onResponse(Call<RegistrasiUser> call, Response<RegistrasiUser> response) {
                        Toast.makeText(getApplicationContext(),"Daftar Berhasil!",Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<RegistrasiUser> call, Throwable t) {
                        Toast.makeText(getApplicationContext(),"error" + t,Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        btnLinklogin = (TextView) findViewById(R.id.link_login);
        btnLinklogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, Welcome_MainActivity.class);
                startActivity(intent);
            }
        });

    }

}
