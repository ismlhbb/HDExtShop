package com.h2project.ismlhbb.hdextshop;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void onClickPesan(View v){
        Intent i = new Intent(this,OrderActivity.class);
        startActivity(i); // Pindah Intent saat memencet CardView yang sudah diberi onClick bernama onClickPesan
    }

    public void onClickTopMenu(View v){
        Intent i = new Intent(this,TopMenuActivity.class);
        startActivity(i);  // Pindah Intent saat memencet CardView yang sudah diberi onClick bernama onClickTopMenu
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true; //Membuat fungsi menu
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Disini baru membuat menu inflatternya
        switch (item.getItemId()){
            case R.id.about: //Jika yang diklik about maka ke profil activity About
                Intent about = new Intent(this,ProfileActivity.class);
                startActivity(about);
                break;
            case R.id.order: //Jika yang diklik order maka ke profil activity order
                Intent order = new Intent(this,OrderActivity.class);
                startActivity(order);
                break;
            case R.id.topMenu:
                Intent menu = new Intent(this,TopMenuActivity.class);
                startActivity(menu);
                break;
            case R.id.quit: //apabila yg dipilih quit maka ia akan keluar dr apk
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Anda yakin ingin keluar ?"); // memunculkan pilihan
                builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog quit = builder.create();
                quit.show();

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() { //membuat fungsi klik back,maka akan keluar
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Anda yakin ingin keluar ?");
        builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog quit = builder.create();
        quit.show();
    }
}
