package com.thanar.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.security.PrivateKey;

public class ShowInfo extends AppCompatActivity {

    private TextView tvName;
    private TextView tvSurname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_info);

        tvName = findViewById(R.id.showName);
        tvSurname = findViewById(R.id.showSurname);

        Bundle data = getIntent().getExtras();
        People people = (People) data.getParcelable("People");

        tvName.setText("ชื่อ: "+people.getName());
        tvSurname.setText("นามสกุล: "+people.getSurname());

    }
}
