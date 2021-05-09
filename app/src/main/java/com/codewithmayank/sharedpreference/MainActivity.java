package com.codewithmayank.sharedpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String PERSON_DETAIL_ID = "person_prefs";
    private EditText name;
    private EditText phoneNumber;
    private EditText address;
    private Button submit;
    private TextView name_text;
    private TextView phonenumber_text;
    private TextView address_text;
    private SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name= findViewById(R.id.editTextText_name);
        phoneNumber= findViewById(R.id.editTextText_phone_number);
        address=findViewById(R.id.editTextText_address);
        name_text=findViewById(R.id.textView_name);
        phonenumber_text=findViewById(R.id.textView_phone_number);
        address_text=findViewById(R.id.textView_address);
        submit=findViewById(R.id.button);


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedPreferences = getSharedPreferences(PERSON_DETAIL_ID,MODE_PRIVATE);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("name",name.getText().toString());
                editor.putString("phone_number",phoneNumber.getText().toString());
                editor.putString("address",address.getText().toString());
                editor.apply();
            }
        });

        SharedPreferences getShareData = getSharedPreferences(PERSON_DETAIL_ID,MODE_PRIVATE);
        name_text.setText(getShareData.getString("name","Nothing yet"));
        phonenumber_text.setText(getShareData.getString("phone_number","Nothing yet"));
        address_text.setText(getShareData.getString("address","Nothing yet"));

    }
}