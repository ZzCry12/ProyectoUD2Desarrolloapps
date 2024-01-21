package com.example.proyectoud2desarrolloapps;

import android.os.Bundle;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.proyectoud2desarrolloapps.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);

        // Oculta el BottomNavigationView al iniciar la aplicación
        navView.setVisibility(View.GONE);

        navController.addOnDestinationChangedListener((controller, destination, arguments) -> {
            // Verifica si el fragmento actual es el que debe mostrar el BottomNavigationView
            if (destination.getId() == R.id.navigation_home)  {
                navView.setVisibility(View.VISIBLE);
            } else if (destination.getId() == R.id.navigation_dashboard) {
                navView.setVisibility(View.VISIBLE);
            } else if (destination.getId() == R.id.navigation_notifications) {
                    navView.setVisibility(View.VISIBLE);
            }
        });
    }
}