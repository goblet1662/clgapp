package com.example.smith.welcome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.view.View.*;
import static android.widget.Toast.*;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button Login = (Button) findViewById(R.id.bt);

        Login.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText uid = (EditText) findViewById(R.id.userid);
                EditText pass1 = (EditText) findViewById(R.id.password);
                EditText Code=(EditText)findViewById(R.id.icode);

                String type="Login";
                String username=uid.getText().toString();
                String pass;
                pass = pass1.getText().toString();
                String code=Code.getText().toString();
                if (uid.getText().length() == 0)
                    makeText(Login.this, "Please Enter Your Email", LENGTH_SHORT).show();

                else if(Code.getText().length() == 0){
                    makeText( Login.this,"Plese Enter Your Password", LENGTH_SHORT).show();
                }else {
                    Loginresponse loginresponse = new Loginresponse(Login.this);
                    loginresponse.execute(type, username, pass, code);
                }

            }});
    }
}
