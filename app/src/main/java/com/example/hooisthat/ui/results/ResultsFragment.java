package com.example.hooisthat.ui.results;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.hooisthat.R;
import com.example.hooisthat.databinding.FragmentInfoBinding;
import com.example.hooisthat.databinding.FragmentResultsBinding;
import com.example.hooisthat.ui.home.HomeFragment;

/*
This is the results page which shows the user all of the potential
identifications with an accuracy percentage. The user can tap each animal
to read more.
*/

public class ResultsFragment extends Fragment {

    private FragmentResultsBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentResultsBinding.inflate(inflater, container, false);

        binding.howlerCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ResultsFragment.this)
                        .navigate(R.id.action_Results_to_Info);
            }
        });
        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}