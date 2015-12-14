package com.byteshaft.registerlogintest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText username;
    private EditText email;
    private EditText password;
    private EditText phone;
    private EditText address;
    private EditText city;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);
        username = (EditText) findViewById(R.id.user_name_edit_text);
        email = (EditText) findViewById(R.id.email_edit_text);
        password = (EditText) findViewById(R.id.password_register);
        phone = (EditText) findViewById(R.id.user_phone);
        address = (EditText) findViewById(R.id.user_address);
        city = (EditText) findViewById(R.id.user_city);
        buttonRegister = (Button) findViewById(R.id.btn_send);
        buttonRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_send:
                if (!username.getText().toString().trim().isEmpty() &&
                        !email.getText().toString().trim().isEmpty() &&
                        !password.getText().toString().trim().isEmpty() &&
                        !phone.getText().toString().trim().isEmpty() &&
                        !address.getText().toString().trim().isEmpty() &&
                        !city.getText().toString().trim().isEmpty()) {

                }

                break;
        }
    }

}
