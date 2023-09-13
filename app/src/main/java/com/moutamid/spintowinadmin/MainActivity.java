package com.moutamid.spintowinadmin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onReqBtn(View view)
    {
        Intent intent = new Intent(MainActivity.this, RequestActivity.class);
        startActivity(intent);
    }

    public void onEditBtn(View view)
    {
        Intent intent = new Intent(MainActivity.this, EditActivity.class);
        startActivity(intent);
    }
}