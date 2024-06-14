package com.example.rightsquest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class homefragment extends Fragment {
    ImageButton startquiz;
    ImageButton startstory;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_homefragment, container, false);
       startquiz=v.findViewById(R.id.startquiz);
       startstory=v.findViewById(R.id.startstory);

       startstory.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent i = new Intent(getActivity(),MainActivity3.class);
               startActivity(i);
           }
       });

       startquiz.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent m = new Intent(getActivity(),MainActivity2.class);
               startActivity(m);
           }
       });


        return v;
    }
}