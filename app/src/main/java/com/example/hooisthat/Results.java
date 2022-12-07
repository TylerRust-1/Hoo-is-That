package com.example.hooisthat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.hooisthat.Results;
import com.example.hooisthat.databinding.ResultsBinding;

/*
This is the results page which shows the user all of the potential
identifications with an accuracy percentage. The user can tap each animal
to read more.
*/

public class Results extends Fragment {

    private ResultsBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = ResultsBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}