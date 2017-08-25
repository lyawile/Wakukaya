package com.example.user.wakukaya;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.user.second;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    public EditText text1, text2, text4;
    public Spinner text3;
    public TextView tFirstName;
    public TextView tSurname;
    String url = "http://duma.co.tz/api/connection.php?fname=Khadija&sname=Saibu&gender=female&phone=0685090488";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
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
                text4 = (EditText) findViewById(R.id.pNumber);
                String phone = text4.getText().toString();
                Intent i = new Intent(MainActivity.this, second.class);
                i.putExtra("fName", firstName);
                i.putExtra("sName", surname);
                i.putExtra("genderName", gender);
                i.putExtra("phoneNumber", phone);

                System.out.println(phone);
               // startActivity(i);
                url="http://duma.co.tz/api/connection.php?fname=" +firstName+ "&sname=" + surname + "&gender=" + gender + "&phone=" + phone + "";
                Log.d(TAG, firstName);
                Log.d(TAG, surname);
                Log.d(TAG, gender);
                Log.d(TAG, phone);

                new registerTask().execute();
            }
        });
    }
    public class registerTask extends AsyncTask<Object, Object, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected void onPostExecute(Void s) {
            super.onPostExecute(s);
        }

        @Override
        protected Void doInBackground(Object... strings) {
            try {
                URL address;
                address = new URL(url);
                HttpURLConnection con = (HttpURLConnection) address.openConnection();
                con.setRequestMethod("GET");
                con.connect();

                BufferedReader bf = new BufferedReader(new InputStreamReader(con.getInputStream()));
                String value = bf.readLine();
                System.out.print(value);
            }
            catch (Exception e){
                Log.d(TAG, e.getMessage());
            }
            return null;
        }
    }
}