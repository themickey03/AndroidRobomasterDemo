package com.mickey.demorobomaster;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;
import com.mickey.demorobomaster.databinding.FragmentSecondBinding;


public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        if (! Python.isStarted()) {
            Python.start(new AndroidPlatform(this.requireActivity()));
        }
        Python py = Python.getInstance();
        PyObject pyobj = py.getModule("main");

        Button bt_version = (Button) requireView().findViewById(R.id.bt_version);

        bt_version.setOnClickListener(view1 -> {
            PyObject obj = pyobj.callAttr("check_version");
            AlertDialog.Builder builder1 = new AlertDialog.Builder(SecondFragment.this.getActivity());
            builder1.setMessage("Result: " + obj.toString());
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Ok",
                    (dialog, id) -> dialog.cancel());

            AlertDialog alert11 = builder1.create();
            alert11.show();
        });

        Button bt_wheel = (Button) requireView().findViewById(R.id.bt_wheel);

        bt_wheel.setOnClickListener(view13 -> {
            PyObject obj = pyobj.callAttr("test_wheel");
            AlertDialog.Builder builder1 = new AlertDialog.Builder(SecondFragment.this.getActivity());
            builder1.setMessage("Result: " + obj.toString());
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Ok",
                    (dialog, id) -> dialog.cancel());

            AlertDialog alert11 = builder1.create();
            alert11.show();
        });


        Button bt_led = (Button) requireView().findViewById(R.id.bt_led);

        bt_led.setOnClickListener(view12 -> {
            PyObject obj = pyobj.callAttr("test_led");
            AlertDialog.Builder builder1 = new AlertDialog.Builder(SecondFragment.this.getActivity());
            builder1.setMessage("Result: " + obj.toString());
            builder1.setCancelable(true);

            builder1.setPositiveButton(
                    "Ok",
                    (dialog, id) -> dialog.cancel());

            AlertDialog alert11 = builder1.create();
            alert11.show();
        });



        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}