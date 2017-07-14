package com.example.walinnsinnovation.iot.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.walinnsinnovation.iot.R;
import com.flurry.android.FlurryAgent;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    TextView btnLogin,btnRegister;
    ImageView img_back_arrow;
    EditText edtmail,edtpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        btnLogin=(TextView) findViewById(R.id.btnlogin);
        btnRegister=(TextView)findViewById(R.id.btnregister);
        img_back_arrow=(ImageView)findViewById(R.id.img_back_arrow);
        img_back_arrow.setOnClickListener(this);
        btnLogin.setOnClickListener(this);
        btnRegister.setOnClickListener(this);
        edtmail=(EditText)findViewById(R.id.edtmail);
        edtpassword=(EditText)findViewById(R.id.edtpass);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnlogin:
               //  if(isValidate()){
                    Intent intent=new Intent(LoginActivity.this,MenuActivity.class);
                    startActivity(intent);

                Map<String, String> articleParams = new HashMap<String, String>();
                articleParams.put("Author",edtmail.getText().toString());
                articleParams.put("User_Status", "Logged");

//Log the timed event when the user starts reading the article
//setting the third param to true creates a timed event
                FlurryAgent.logEvent("Article_Read", articleParams, true);

//...

// End the timed event, when the user navigates away from article
                FlurryAgent.endTimedEvent("Article_Read");
                // }
                break;
            case R.id.btnregister:
                break;
            case R.id.img_back_arrow:
                finish();
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
        if(edtpassword.getText().toString().isEmpty()){
            edtmail.setError("Enter the Password");
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
