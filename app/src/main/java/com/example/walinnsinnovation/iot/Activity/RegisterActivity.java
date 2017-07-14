package com.example.walinnsinnovation.iot.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.walinnsinnovation.iot.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    ImageView img_back_arrow;
    Button btnsignup;
    EditText edtmail,edtPassword,edtConfirmPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        img_back_arrow=(ImageView)findViewById(R.id.img_back_arrow);
        img_back_arrow.setOnClickListener(this);
        btnsignup=(Button)findViewById(R.id.btnsignup);
        btnsignup.setOnClickListener(this);
        edtmail=(EditText)findViewById(R.id.edtmail);
        edtPassword=(EditText)findViewById(R.id.edtPassword);
        edtConfirmPass=(EditText)findViewById(R.id.edtConfirmPass);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_back_arrow:
                finish();
                break;
            case R.id.btnsignup:
                if(isValidate()) {
                    Intent intent = new Intent(RegisterActivity.this, MenuActivity.class);
                    startActivity(intent);
                }
                break;
        }
    }

    public boolean isValidate(){
        if(edtmail.getText().toString().isEmpty()){
            edtmail.setError("Enter the E-mail");
            edtmail.requestFocus();
            return false;
        }
        if(isValidEmail(edtmail.getText().toString())){
            edtmail.setError("Enter the valid E-mail");
            edtmail.requestFocus();
            return false;
        }
        if(edtPassword.getText().toString().isEmpty()){
            edtmail.setError("Enter the Password");
            edtmail.requestFocus();
            return false;
        }
        if(edtConfirmPass.getText().toString().isEmpty()){
            edtConfirmPass.setError("Enter the Password");
            edtmail.requestFocus();
            return false;
        }
        if(!edtPassword.getText().toString().equals(edtConfirmPass.getText().toString())){
            edtConfirmPass.setError("password and confirm password is mismatch");
            edtmail.requestFocus();
            return false;
        }

        return true;
    }
    public final static boolean isValidEmail(CharSequence target) {
        if (target == null)
            return false;

        return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

}
