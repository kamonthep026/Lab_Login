package com.example.lablogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        final String pass = etPass.getText().toString();
        if (!isValidPassword(pass)) {
            etPass.setError("Invalid Password");
        }else (v == btnLogin){
            Toast.makeText(MainActivity.this,"รหัสผ่านผิดพลาด",Toast.LENGTH_SHORT).show();
        }
    }
    // validating password with retype password
    private boolean isValidPassword(String pass) {
        String PASS_PATERN =
                "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[\\p{Punct}]).{6,})";
        Pattern pattern = Pattern.compile(PASS_PATERN);
        Matcher matcher=pattern.matcher(pass);
        return matcher.matches();
    }
}
