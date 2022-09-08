package com.mickey.demorobomaster;

import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class Description extends Fragment {
    public Description() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_description, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        
        TextView tw = (TextView) requireView().findViewById(R.id.long_text_desc);
        Spanned sp = Html.fromHtml(getString(R.string.long_text_desc));
        tw.setText(sp);


        super.onViewCreated(view, savedInstanceState);
    }
}