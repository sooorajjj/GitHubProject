package com.rockstart.githubproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private RelativeLayout mRoot;
    private TextInputLayout mInputLayout, mPasswordLayout;
    private EditText mInputText, mPasswordText;
    private Button login;
    private TextView registerLink;
    boolean isEmptyEmail;
    boolean isEmptyPassword;

    private View.OnClickListener mSnackBarClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        assert getSupportActionBar() != null;
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setTitle("Klok Innovations");
        getSupportActionBar().setLogo(R.drawable.collection_report);
        getSupportActionBar().setDisplayUseLogoEnabled(true);

        Initialize();
        listener();
    }

    private void Initialize() {
        registerLink = (TextView) findViewById(R.id.tvRegister);
        mRoot = (RelativeLayout) findViewById(R.id.root_activity_second);
        mInputLayout = (TextInputLayout) findViewById(R.id.input_layout);
        mPasswordLayout = (TextInputLayout) findViewById(R.id.password_layout);
        mInputText = (EditText) findViewById(R.id.edtInput);
        mPasswordText = (EditText) findViewById(R.id.edtPassword);
        login = (Button) findViewById(R.id.btnLogin);
    }

    private boolean isEmptyEmail() {
        return mInputText.getText() == null
                || mInputText.getText().toString() == null
                || mInputText.getText().toString().isEmpty();
    }

    private boolean isEmptyPassword() {
        return mPasswordText.getText() == null
                || mPasswordText.getText().toString() == null
                || mPasswordText.getText().toString().isEmpty();
    }

    private void listener() {
        registerLink.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btnLogin){

            isEmptyEmail = isEmptyEmail();
            isEmptyPassword = isEmptyPassword();

            if (isEmptyEmail && isEmptyPassword) {
                Snackbar.make(mRoot, "one or more Field are blank", Snackbar.LENGTH_SHORT).setAction(getString(R.string.txt_dismiss), mSnackBarClickListener).show();
            } else if (isEmptyEmail && !isEmptyPassword) {
                mInputLayout.setError("Email cannot be empty");
                mPasswordLayout.setError(null);
            } else if (!isEmptyEmail && isEmptyPassword) {
                mInputLayout.setError(null);
                mPasswordLayout.setError("Password cannot be empty");
            } else if (!isEmptyEmail && !isEmptyPassword) {
                mInputLayout.setError(null);
                mPasswordLayout.setError(null);
            } else if (mInputText.getText().toString().equals("admin") && mPasswordText.getText().toString().equals("admin")) {
                Intent loginIntent = new Intent(LoginActivity.this, AdminAreaActivity.class);
                LoginActivity.this.startActivity(loginIntent);
            } else if(mInputText.getText().toString().equals("manager") && mPasswordText.getText().toString().equals("manager")) {
                Intent loginIntent = new Intent(LoginActivity.this, ManagerAreaActivity.class);
                LoginActivity.this.startActivity(loginIntent);
            }else if(mInputText.getText().toString().equals("user") && mPasswordText.getText().toString().equals("user")) {
                Intent loginIntent = new Intent(LoginActivity.this, UserAreaActivity.class);
                LoginActivity.this.startActivity(loginIntent);
            }else {
                //wrong password
                Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_SHORT).show();
            }
        }

        if(v.getId() == R.id.tvRegister){
            Intent registerIntent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(registerIntent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.testmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        super.onOptionsItemSelected(item);
        switch (item.getItemId()){
            case R.id.action_about:
                aboutMenuItem();
                break;
            }
        return true;
    }

    private void aboutMenuItem(){
        new AlertDialog.Builder(this)
                .setTitle("About")
                .setMessage("Klok Innovations"+" Copyright 2015 ©. All rights reserved")
                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                }).show();
    }
}