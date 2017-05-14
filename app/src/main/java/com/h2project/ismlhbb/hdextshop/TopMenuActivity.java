package com.h2project.ismlhbb.hdextshop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class TopMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_top_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) { //Bila menekan tombol back maka akan kembali ke MainActivity.xml
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }
    public void onClickPesan(View v){
        Intent order = new Intent(this,OrderActivity.class);
        startActivity(order); // Pindah Intent saat memencet CardView yang sudah diberi onClick bernama onClickPesan
    }
}
