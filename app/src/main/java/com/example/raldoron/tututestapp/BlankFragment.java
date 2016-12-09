package com.example.raldoron.tututestapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BlankFragment extends Fragment {

    public BlankFragment() {
    }

    public static BlankFragment getInstance() {
        BlankFragment fragment = new BlankFragment();
        fragment.setArguments(new Bundle());
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blank, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView stationFrom = (TextView) getView().findViewById(R.id.citiesFrom);
        stationFrom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), StationSearchActivity.class);
                String from = getResources().getString(R.string.From);
                intent.putExtra("MESSAGE", from);
                startActivity(intent);
            }
        });

        TextView stationTo = (TextView) getView().findViewById(R.id.citiesTo);
        stationTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), StationSearchActivity.class);
                String to = getResources().getString(R.string.To);
                intent.putExtra("MESSAGE", to);
                startActivity(intent);
            }
        });

    }
}
