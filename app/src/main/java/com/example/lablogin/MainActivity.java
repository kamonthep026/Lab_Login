package com.example.lablogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnLogin;
    EditText etIdEmail;
    EditText etPass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initInstances();

    }
    private void initInstances() {
        btnLogin = (Button) findViewById(R.id.btnLogin);
        etIdEmail = (EditText) findViewById(R.id.etIdEmail);
        etPass = (EditText) findViewById(R.id.etPass);
        btnLogin.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        final String email = etIdEmail.getText().toString();
        final String pass = etPass.getText().toString();
        if (!isValidIdEmail(email)){
            etIdEmail.setError("ไอดีผิดพลาด");
        }
        if(!isValidPassword(pass)) {
            etPass.setError("รหัสผ่านผิดพลาด");
        }
    }

    private boolean isValidIdEmail(String email) {
        String EMAIL_PATERN =
                "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\p{Punct}]).{9,})";
        Pattern pattern = Pattern.compile(EMAIL_PATERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
    // validating password with retype password
    private boolean isValidPassword(String pass) {
        String PASS_PATERN =
                "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\p{Punct}]).{6,})";
        Pattern pattern = Pattern.compile(PASS_PATERN);
        Matcher matcher = pattern.matcher(pass);
        return matcher.matches();
    }

}
