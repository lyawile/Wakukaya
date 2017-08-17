package com.example.user.wakukaya;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.user.second;


public class MainActivity extends AppCompatActivity {
public EditText text1;
    public EditText text2;
    public Spinner text3;
    public TextView tFirstName;
    public TextView tSurname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    public void init(){
        final Button btn = (Button) findViewById(R.id.btnJisajili);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "Good, it works!", Toast.LENGTH_SHORT).show();
//                Intent toy = new Intent(MainActivity.this, second.class);
//                startActivity(toy);
                text1 = (EditText) findViewById(R.id.fName);
                String firstName = text1.getText().toString();
//                Log.i(firstName, "Check if the message displays");
//               btn.setText(firstName);
                text2 = (EditText) findViewById(R.id.sName);
                String surname = text2.getText().toString();
//                tFirstName = (TextView) findViewById(R.id.firstNameId);
//                tSurname = (TextView) findViewById(R.id.surNameId);
//                tSurname.setText(surname);
                text3 = (Spinner) findViewById(R.id.gender);
                String gender = text3.getSelectedItem().toString();
                Intent i = new Intent(MainActivity.this, second.class);
               i.putExtra("fName",firstName);
               i.putExtra("sName", surname);
                i.putExtra("genderName", gender);


                startActivity(i);

            }
        });
    }
}
