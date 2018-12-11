package com.example.krisandroid.noteme;

import android.app.ProgressDialog;
<<<<<<< HEAD
import android.content.Intent;
=======
>>>>>>> 60f1a7d2c8e0dbe4ac359ab9b2ad87ce1b8a5493
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

<<<<<<< HEAD
import com.example.krisandroid.noteme.Models.RegistrasiUser;
import com.example.krisandroid.noteme.Rest.ApiClient;
import com.example.krisandroid.noteme.Rest.ApiInterface;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
=======
import butterknife.BindView;
import butterknife.ButterKnife;
>>>>>>> 60f1a7d2c8e0dbe4ac359ab9b2ad87ce1b8a5493

public class SignUpActivity extends AppCompatActivity {
//    private static final String TAG = "SignupActivity";
//
//    @BindView(R.id.input_name) EditText _nameText;
//    @BindView(R.id.input_email) EditText _emailText;
//    @BindView(R.id.input_password) EditText _passwordText;
//    @BindView(R.id.btn_signup) Button _signupButton;
//    @BindView(R.id.link_login) TextView _loginLink;
<<<<<<< HEAD
    EditText edUsername,edPassword,edEmail;
    Button btRegister;
    TextView btnLinklogin;
=======

>>>>>>> 60f1a7d2c8e0dbe4ac359ab9b2ad87ce1b8a5493
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

<<<<<<< HEAD
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

=======
//        ButterKnife.bind(this);
//
//        _signupButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                signup();
//            }
//        });
//
//        _loginLink.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // Finish the registration screen and return to the Login activity
//                finish();
//            }
//        });
    }
//    public void signup() {
//        Log.d(TAG, "Signup");
//
//        if (!validate()) {
//            onSignupFailed();
//            return;
//        }
//
//        _signupButton.setEnabled(false);
//
//        final ProgressDialog progressDialog = new ProgressDialog(SignUpActivity.this, R.style.AppTheme);
//        progressDialog.setIndeterminate(true);
//        progressDialog.setMessage("Creating Account...");
//        progressDialog.show();
//
//        String name = _nameText.getText().toString();
//        String email = _emailText.getText().toString();
//        String password = _passwordText.getText().toString();
//
//        // TODO: Implement your own signup logic here.
//
//        new android.os.Handler().postDelayed(
//                new Runnable() {
//                    public void run() {
//                        // On complete call either onSignupSuccess or onSignupFailed
//                        // depending on success
//                        onSignupSuccess();
//                        // onSignupFailed();
//                        progressDialog.dismiss();
//                    }
//                }, 3000);
//    }
//
//
//    public void onSignupSuccess() {
//        _signupButton.setEnabled(true);
//        setResult(RESULT_OK, null);
//        finish();
//    }
//
//    public void onSignupFailed() {
//        Toast.makeText(getBaseContext(), "Login failed", Toast.LENGTH_LONG).show();
//
//        _signupButton.setEnabled(true);
//    }
//
//    public boolean validate() {
//        boolean valid = true;
//
//        String name = _nameText.getText().toString();
//        String email = _emailText.getText().toString();
//        String password = _passwordText.getText().toString();
//
//        if (name.isEmpty() || name.length() < 3) {
//            _nameText.setError("at least 3 characters");
//            valid = false;
//        } else {
//            _nameText.setError(null);
//        }
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
>>>>>>> 60f1a7d2c8e0dbe4ac359ab9b2ad87ce1b8a5493
}
