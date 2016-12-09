package com.example.raldoron.tututestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class StationSearchActivity extends AppCompatActivity {

    private EditText stationName;
    private RecyclerView stationList;
    private RecyclerView.Adapter stationAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_station_search);

        Intent intent = getIntent();
        String message = intent.getStringExtra("MESSAGE");
        TextView textView = (TextView) findViewById(R.id.message);
        textView.setText(message);

        //  TODO: 08.12.16 if citiesFrom else citiesTo


        stationName = (EditText) findViewById(R.id.searchStation);
        stationList = (RecyclerView) findViewById(R.id.stationList);
        layoutManager = new LinearLayoutManager(this);
        stationList.setLayoutManager(layoutManager);

        stationAdapter = new StationAdapter();
        stationList.setAdapter(stationAdapter);

        stationName.addTextChangedListener(stationWatcher);

    }

    private final TextWatcher stationWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}
