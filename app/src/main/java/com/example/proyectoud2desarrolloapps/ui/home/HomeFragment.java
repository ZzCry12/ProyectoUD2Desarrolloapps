package com.example.proyectoud2desarrolloapps.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.proyectoud2desarrolloapps.SharedViewModel;
import com.example.proyectoud2desarrolloapps.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        SharedViewModel sharedViewModel = new ViewModelProvider(getActivity()).get(SharedViewModel.class);

        SharedViewModel.getCurrentAddress().observe(getViewLifecycleOwner(), address -> {
            binding.localitzacio.setText(String.format(
                    "Direcció: %1$s \n Hora: %2$tr",
                    address, System.currentTimeMillis()));
        });
        sharedViewModel.getButtonText().observe(getViewLifecycleOwner(), s -> binding.buttonLocation.setText(s));
        sharedViewModel.getProgressBar().observe(getViewLifecycleOwner(), visible -> {
        });

        binding.buttonLocation.setOnClickListener(view -> {
            Log.d("DEBUG", "Clicked Get Location");
            sharedViewModel.switchTrackingLocation();
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}