package com.example.user;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.user.wakukaya.R;

public class second extends AppCompatActivity {
    private TextView fname, sname, gname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String jinaLaMwanzo = intent.getStringExtra("fName");
        String jinaLaUkoo = intent.getStringExtra("sName");
        String jinsia = intent.getStringExtra("genderName");
        fname = (TextView) findViewById(R.id.n1);
        sname = (TextView) findViewById(R.id.n2);
        gname = (TextView) findViewById(R.id.n4);
        fname.setText(jinaLaMwanzo);
        sname.setText(jinaLaUkoo);
        gname.setText(jinsia);
    }
}
