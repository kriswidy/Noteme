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

//    private static final String TAG = "LoginActivity";
//    private static final int REQUEST_SIGNUP = 0;
//
//    @BindView(R.id.input_email) EditText _emailText;
//    @BindView(R.id.input_password) EditText _passwordText;
//    @BindView(R.id.btn_login) Button _loginButton;
//    @BindView(R.id.link_signup) TextView _signupLink;
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



//        ButterKnife.bind(this);
//        _loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), AddMainActivity.class);
//                startActivity(intent);
//            }
//        });


//        ButterKnife.bind(this);

  //      _loginButton.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                login();
//            }
//        });
//
//        _signupLink.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                // Start the Signup activity
//                Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
//                startActivityForResult(intent, REQUEST_SIGNUP);
//            }
//        });
    }

//    public void login() {
//        Log.d(TAG, "Login");
//
//        if (!validate()) {
//            onLoginFailed();
//            return;
//        }
//
//        _loginButton.setEnabled(false);
//
//        final ProgressDialog progressDialog = new ProgressDialog(Welcome_MainActivity.this, R.style.AppTheme);
//        progressDialog.setIndeterminate(true);
//        progressDialog.setMessage("Authenticating...");
//        progressDialog.show();
//
//        String email = _emailText.getText().toString();
//        String password = _passwordText.getText().toString();
//
//        // TODO: Implement your own authentication logic here.
//
//        new android.os.Handler().postDelayed(
//                new Runnable() {
//                    public void run() {
//                        // On complete call either onLoginSuccess or onLoginFailed
//                        onLoginSuccess();
//                        // onLoginFailed();
//                        progressDialog.dismiss();
//                    }
//                }, 3000);
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        if (requestCode == REQUEST_SIGNUP) {
//            if (resultCode == RESULT_OK) {
//
//                // TODO: Implement successful signup logic here
//                // By default we just finish the Activity and log them in automatically
//                this.finish();
//            }
//        }
//    }
//
//    @Override
//    public void onBackPressed() {
//        // disable going back to the MainActivity
////        moveTaskToBack(true);
//    }
//
//    public void onLoginSuccess() {
////        _loginButton.setEnabled(true);
////        finish();
//    }
//
//    public void onLoginFailed() {
////        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
////
////        _loginButton.setEnabled(true);
//    }

//    public boolean validate() {
//        boolean valid = true;
//
//        String email = _emailText.getText().toString();
//        String password = _passwordText.getText().toString();
//
//        if (email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
//            _emailText.setError("enter a valid email address");
//            valid = false;
//        } else {
//            _emailText.setError(null);
//        }
//
//        if (password.isEmpty() || password.length() < 4 || password.length() > 10) {
//            _passwordText.setError("between 4 and 10 alphanumeric characters");
//            valid = false;
//        } else {
//            _passwordText.setError(null);
//        }
//
//        return valid;
//    }
}
