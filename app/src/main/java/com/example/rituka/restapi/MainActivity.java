package com.example.rituka.restapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button bt;
    EditText et;
    EditText pass;
    String name,password;
  //  String getname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText) findViewById(R.id.et);
        pass=(EditText)findViewById(R.id.pass);
        tv=(TextView)findViewById(R.id.tv);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                name=et.getText().toString();
                password=pass.getText().toString();

                Signin signin=APIPost.getApiPost().getSignin();
                Auth authorization=new Auth();
                authorization.getAuth().setEmail(name);
                authorization.getAuth().setPassword(password);
                signin.getToken(authorization).enqueue(new Callback<Token>() {
                    @Override
                    public void onResponse(Call<Token> call, Response<Token> response) {
                        tv.setText(response.body().getJwt());
                    }

                    @Override
                    public void onFailure(Call<Token> call, Throwable t) {
                        tv.setText("ERROR!!!");

                    }
                });

                /* UserName userName=API.getApiInstance().getUserName();
                userName.getName(name).enqueue(new Callback<Name>() {
                    @Override
                    public void onResponse(Call<Name> call, Response<Name> response) {
                        tv.setText(String.valueOf(response.body().getId()));
                    }

                    @Override
                    public void onFailure(Call<Name> call, Throwable t) {
                        tv.setText("ERROR!!!");
                    }
                });*/
            }
        });




    }
}
