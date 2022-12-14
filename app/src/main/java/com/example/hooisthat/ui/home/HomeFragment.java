package com.example.hooisthat.ui.home;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.hooisthat.R;
import com.example.hooisthat.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;
    private AnimationDrawable loadingWheel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Handler handler = new Handler();
        Runnable runner = new Runnable() {
            @Override
            public void run() {
                NavHostFragment.findNavController(HomeFragment.this)
                        .navigate(R.id.action_HomePage_to_Results);
            }
        };

        binding.micButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Removes previous calls to the runner
                handler.removeCallbacks(runner);

                ImageView rainbowWheel = binding.listeningRing;
                rainbowWheel.setBackgroundResource(R.drawable.rainbow_ring);

                loadingWheel = (AnimationDrawable) rainbowWheel.getBackground();

                // Starts the animation
                loadingWheel.start();

                // Switches to the results page after a 3 second delay
                handler.postDelayed(runner, 3000);
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}