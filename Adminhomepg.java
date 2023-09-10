package com.example.android.logindemo.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.android.logindemo.DeleteUserpg;
import com.example.android.logindemo.R;
import com.example.android.logindemo.activity.Adminpg;
import com.example.android.logindemo.activity.ItemsActivity;
import com.example.android.logindemo.activity.MainActivity;

public class Adminhomepg extends AppCompatActivity {

    private Button useritem;

    private Button deleteusr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhomepg);
        useritem=findViewById(R.id.itemviewbtn);

        useritem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Adminhomepg.this, ItemsActivity.class));
            }
        });

        deleteusr=findViewById(R.id.deleteuserbtn);

        deleteusr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Adminhomepg.this, DeleteUserpg.class));
            }
        });
    }
}