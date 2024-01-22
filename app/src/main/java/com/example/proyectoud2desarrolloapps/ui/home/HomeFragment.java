package com.example.proyectoud2desarrolloapps.ui.home;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.proyectoud2desarrolloapps.Incidencia;
import com.example.proyectoud2desarrolloapps.R;
import com.example.proyectoud2desarrolloapps.SharedViewModel;
import com.example.proyectoud2desarrolloapps.databinding.FragmentHomeBinding;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeFragment extends Fragment {
    private FragmentHomeBinding binding;
    private FirebaseUser authUser;
    private MediaPlayer mediaPlayer;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        SharedViewModel sharedViewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        SharedViewModel.getCurrentAddress().observe(getViewLifecycleOwner(), address -> {
            binding.txtDireccio.setText(String.format(
                    "Direcció: %1$s \n Hora: %2$tr",
                    address, System.currentTimeMillis())
            );
        });

        sharedViewModel.getCurrentLatLng().observe(getViewLifecycleOwner(), latlng -> {
            binding.txtLatitud.setText(String.valueOf(latlng.latitude));
            binding.txtLongitud.setText(String.valueOf(latlng.longitude));
        });

        sharedViewModel.getProgressBar().observe(getViewLifecycleOwner(), visible -> {
            if (visible)
                binding.loading.setVisibility(ProgressBar.VISIBLE);
            else
                binding.loading.setVisibility(ProgressBar.INVISIBLE);
        });

        sharedViewModel.switchTrackingLocation();

        sharedViewModel.getUser().observe(getViewLifecycleOwner(), user -> {
            authUser = user;
        });

        Spinner concesionarios = root.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(), R.array.concesionarios, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        concesionarios.setAdapter(adapter);
        mediaPlayer = MediaPlayer.create(requireContext(), R.raw.boton1);
        binding.buttonNotificar.setOnClickListener(button -> {
            Incidencia incidencia = new Incidencia();
            incidencia.setDireccio(binding.txtDireccio.getText().toString());
            incidencia.setLatitud(binding.txtLatitud.getText().toString());
            incidencia.setLongitud(binding.txtLongitud.getText().toString());
            incidencia.setProblema(binding.txtDescripcio.getText().toString());
            incidencia.setConcesionario(binding.spinner.getSelectedItem().toString());

            DatabaseReference base = FirebaseDatabase.getInstance(
            ).getReference();

            DatabaseReference users = base.child("users");
            DatabaseReference uid = users.child(authUser.getUid());
            DatabaseReference incidencies = uid.child("incidencies");

            DatabaseReference reference = incidencies.push();
            reference.setValue(incidencia);

            if (mediaPlayer != null) {
                mediaPlayer.start();
            }

            Toast.makeText(requireContext(), "Opinion enviada", Toast.LENGTH_SHORT).show();

        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }

        binding = null;
    }
}