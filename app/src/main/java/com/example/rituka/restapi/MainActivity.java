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
    String name;
  //  String getname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et=(EditText) findViewById(R.id.et);
        tv=(TextView)findViewById(R.id.tv);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                name=et.getText().toString();
                UserName userName=API.getApiInstance().getUserName();
                userName.getName(name).enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        tv.setText(String.valueOf(response.body()));
                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        tv.setText("ERROR!!!");
                    }
                });
            }
        });




    }
}
