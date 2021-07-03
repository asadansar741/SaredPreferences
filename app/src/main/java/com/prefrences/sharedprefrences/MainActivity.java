package com.prefrences.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

    private TextView tvOutput;
    private Button btnSaveInPref,btnGet;
    private EditText editText,edtPss;
    private Preferences preferences;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvOutput=findViewById(R.id.tvOutput);
        btnSaveInPref=findViewById(R.id.btnSaveInPref);
        btnGet=findViewById(R.id.btnGet);
        editText=findViewById(R.id.editText);
        tvOutput=findViewById(R.id.tvOutput);
        edtPss=findViewById(R.id.edtPss);
        preferences =new Preferences(this);
        sharedPreferences= preferences.getSharedPrefObj();

        btnSaveInPref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                preferences.saveStringInPrefrence(Preferences.MY_EDIT_TEXT,editText.getText().toString().trim());
//                preferences.commitPrefrence();

                User user=new User(editText.getText().toString().trim(),edtPss.getText().toString().trim());
                Gson gson=new Gson();
                String jsonStr = gson.toJson(user);
                preferences.saveStringInPrefrence(Preferences.USER_OBJ,jsonStr);
                preferences.commitPrefrence();
                Toast.makeText(MainActivity.this,"saved in preference",Toast.LENGTH_LONG).show();
            }
        });

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String value=preferences.getStringFromPrefrences(Preferences.MY_EDIT_TEXT,"N/A");
                String value= preferences.getStringFromPrefrences(Preferences.USER_OBJ,"N/A");
                Gson gson=new Gson();
                User user = gson.fromJson(value, User.class);
                tvOutput.setText(user.getUserName()+"\n"+user.getAge());
            }
        });

        sharedPreferences.registerOnSharedPreferenceChangeListener(new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
//                tvOutput.setText(sharedPreferences.getString(key,"n/a"));
            }
        });
    }
}
