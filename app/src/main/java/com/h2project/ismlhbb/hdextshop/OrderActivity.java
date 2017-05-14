package com.h2project.ismlhbb.hdextshop;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {

    EditText mTextNama;
    TextView mTextHarga, mTextQty;
    Button mButtonOrder, mButtonPlus, mButtonMin;
    RadioGroup mRadioGroup;
    RadioButton mItem1, mItem2;
    String item = null;
    Context mContext;
    Spinner mSpinnerMenu;
    List<String> mListMenu = new ArrayList<>(); //membuat array list
    int harga = 0;
    int qty = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mContext = getApplicationContext();
        mTextNama = (EditText) findViewById(R.id.mTextNama);
        mTextHarga = (TextView) findViewById(R.id.mTextHarga);
        mButtonOrder = (Button) findViewById(R.id.mButtonOrder);
        mTextQty = (TextView) findViewById(R.id.mTextQty);
        mButtonPlus = (Button) findViewById(R.id.mButtonPlus);
        mButtonMin = (Button) findViewById(R.id.mButtonMin);
        // radio
        mRadioGroup = (RadioGroup) findViewById(R.id.mRadioGroup);
        mItem1 = (RadioButton) findViewById(R.id.mItem1);
        mItem2 = (RadioButton) findViewById(R.id.mItem2);
        // spinner
        mSpinnerMenu = (Spinner) findViewById(R.id.mSpinnerMenu);
        mListMenu.add("WD My Passport 1TB USB 3.0 - New Model");
        mListMenu.add("WD My Passport 2TB USB 3.0 - New Model");
        mListMenu.add("WD Elements 1TB - USB 3.0");
        mListMenu.add("WD Elements 2TB - USB 3.0");
        mListMenu.add("Seagate Backup Plus SLIM Edition 1TB USB 3.0");
        mListMenu.add("Seagate Backup Plus SLIM Edition 2TB USB 3.0");
        //memasukan info ke spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, mListMenu);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinnerMenu.setAdapter(dataAdapter);}

    public void onClickOrder(View view) { //hanya memilih salah satu radiobox dan mendapatkan text untuk item
        switch (mRadioGroup.getCheckedRadioButtonId()) {
            case R.id.mItem1:
                item = mItem1.getText().toString();
                break;
            case R.id.mItem2:
                item = mItem2.getText().toString();
                break;
        }

        String to = "ismlhbb@null.net";
        String subject = mTextNama.getText().toString();
        String message =
                "Saya " +mTextNama.getText() + " pesan "
                + mSpinnerMenu.getSelectedItem()
                + " sebanyak "
                + mTextQty.getText()
                + " buah, seharga "
                + mTextHarga.getText()
                + ", dengan bonus "
                + item;

        Intent email = new Intent(Intent.ACTION_SEND); //order email
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ to});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);
        email.setType("message/rfc822");
        startActivity(Intent.createChooser(email, "Kirim email dengan"));
    }

    public void onClickPlus(View view) {
        harga = harga + 1150000; //logic tombol >
        qty = qty + 1;
        mTextQty.setText(qty + "");
        mTextHarga.setText("Rp" + harga);
    }

    public void onClickMin(View view) { //logic button <
        if (harga != 0) {
            harga = harga - 1150000;
            qty = qty - 1;
            mTextQty.setText(qty + "");
            mTextHarga.setText("Rp" + harga);
        } else {
            harga = 0;
            qty = 0;
            mTextQty.setText(qty + "");
            mTextHarga.setText("Rp" + harga);
        }
    }

    public void onClickReset(View v) {
        harga = 0; //logic reset button
        qty = 0;
        mTextNama.setText("");
        mTextHarga.setText("Rp" + harga);
        mTextQty.setText(qty + "");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

}
