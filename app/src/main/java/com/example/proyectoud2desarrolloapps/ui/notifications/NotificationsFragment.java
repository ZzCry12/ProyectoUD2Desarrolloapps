package com.example.proyectoud2desarrolloapps.ui.notifications;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.proyectoud2desarrolloapps.R;
import com.example.proyectoud2desarrolloapps.databinding.FragmentNotificationsBinding;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.overlay.Marker;
import org.osmdroid.views.overlay.compass.CompassOverlay;
import org.osmdroid.views.overlay.compass.InternalCompassOrientationProvider;
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider;
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {
    private FragmentNotificationsBinding binding;
    List<Marker> markerList = new ArrayList<>();
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        Context ctx = requireActivity().getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));

        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.map.setTileSource(TileSourceFactory.MAPNIK);
        binding.map.setMultiTouchControls(true);
        IMapController mapController = binding.map.getController();
        mapController.setZoom(14.5);
        GeoPoint startPoint = new GeoPoint(39.4715612, -0.3930977);
        mapController.setCenter(startPoint);

        MyLocationNewOverlay myLocationNewOverlay = new MyLocationNewOverlay(new GpsMyLocationProvider(requireContext()), binding.map);
        myLocationNewOverlay.enableMyLocation();
        binding.map.getOverlays().add(myLocationNewOverlay);

        CompassOverlay compassOverlay = new CompassOverlay(requireContext(), new InternalCompassOrientationProvider(requireContext()), binding.map);
        compassOverlay.enableCompass();
        binding.map.getOverlays().add(compassOverlay);

        // Crear y añadir varios marcadores a la lista
        GeoPoint markerPoint1 = new GeoPoint(39.983136000786985, -0.051904064177773476);
        Marker marker1 = new Marker(binding.map);
        marker1.setPosition(markerPoint1);
        marker1.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        marker1.setTitle("Concesionario 1");
        Drawable icon1 = getResources().getDrawable(R.drawable.concesionario1);
        Bitmap bitmap1 = ((BitmapDrawable) icon1).getBitmap();
        marker1.setIcon(new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap1, 50, 50, true)));
        markerList.add(marker1);
        for (Marker marker : markerList) {
            marker.setOnMarkerClickListener((clickedMarker, mapView) -> {
                showImageDialog(getDrawableResourceIdForMarker(clickedMarker));
                return true;
            });
        }


        GeoPoint markerPoint2 = new GeoPoint(39.483860601044185, -0.35765982144150715);
        Marker marker2 = new Marker(binding.map);
        marker2.setPosition(markerPoint2);
        marker2.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        Drawable icon2 = getResources().getDrawable(R.drawable.concesionario2);
        Bitmap bitmap2 = ((BitmapDrawable) icon2).getBitmap();
        marker2.setIcon(new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap2, 50, 50, true)));
        marker2.setTitle("Concesionario 2");
        markerList.add(marker2);
        for (Marker marker : markerList) {
            marker.setOnMarkerClickListener((clickedMarker, mapView) -> {
                showImageDialog(getDrawableResourceIdForMarker(clickedMarker));
                return true;
            });
        }


        GeoPoint markerPoint3 = new GeoPoint(39.4865103282396, -0.45241690110192767);
        Marker marker3 = new Marker(binding.map);
        marker3.setPosition(markerPoint3);
        marker3.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        marker3.setTitle("Concesionario 3");
        Drawable icon3 = getResources().getDrawable(R.drawable.concesionario3);
        Bitmap bitmap3 = ((BitmapDrawable) icon3).getBitmap();
        marker3.setIcon(new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap3, 50, 50, true)));
        markerList.add(marker3);
        for (Marker marker : markerList) {
            marker.setOnMarkerClickListener((clickedMarker, mapView) -> {
                showImageDialog(getDrawableResourceIdForMarker(clickedMarker));
                return true;
            });
        }

        GeoPoint markerPoint4 = new GeoPoint(39.493399146653765, -0.3995451976310309);
        Marker marker4 = new Marker(binding.map);
        marker4.setPosition(markerPoint4);
        marker4.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        marker4.setTitle("Concesionario 4");
        Drawable icon4 = getResources().getDrawable(R.drawable.concesionario4);
        Bitmap bitmap4 = ((BitmapDrawable) icon4).getBitmap();
        marker4.setIcon(new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap4, 50, 50, true)));
        markerList.add(marker4);
        for (Marker marker : markerList) {
            marker.setOnMarkerClickListener((clickedMarker, mapView) -> {
                showImageDialog(getDrawableResourceIdForMarker(clickedMarker));
                return true;
            });
        }

        GeoPoint markerPoint5 = new GeoPoint(39.43455727246679, -0.37413931414501556);
        Marker marker5 = new Marker(binding.map);
        marker5.setPosition(markerPoint5);
        marker5.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        marker5.setTitle("Concesionario 5");
        Drawable icon5 = getResources().getDrawable(R.drawable.concesionario5);
        Bitmap bitmap5 = ((BitmapDrawable) icon5).getBitmap();
        marker5.setIcon(new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap5, 50, 50, true)));
        markerList.add(marker5);
        for (Marker marker : markerList) {
            marker.setOnMarkerClickListener((clickedMarker, mapView) -> {
                showImageDialog(getDrawableResourceIdForMarker(clickedMarker));
                return true;
            });
        }

        GeoPoint markerPoint6 = new GeoPoint(39.49498877705288, -0.39405203363405455);
        Marker marker6 = new Marker(binding.map);
        marker6.setPosition(markerPoint6);
        marker6.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        marker6.setTitle("Concesionario 6");
        Drawable icon6 = getResources().getDrawable(R.drawable.concesionario6);
        Bitmap bitmap6 = ((BitmapDrawable) icon6).getBitmap();
        marker6.setIcon(new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap6, 50, 50, true)));
        markerList.add(marker6);
        for (Marker marker : markerList) {
            marker.setOnMarkerClickListener((clickedMarker, mapView) -> {
                showImageDialog(getDrawableResourceIdForMarker(clickedMarker));
                return true;
            });
        }

        GeoPoint markerPoint7 = new GeoPoint(39.4865103282396, -0.39199209713518846);
        Marker marker7 = new Marker(binding.map);
        marker7.setPosition(markerPoint7);
        marker7.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        marker7.setTitle("Concesionario 7");
        Drawable icon7 = getResources().getDrawable(R.drawable.concesionario7);
        Bitmap bitmap7 = ((BitmapDrawable) icon7).getBitmap();
        marker7.setIcon(new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap7, 50, 50, true)));
        markerList.add(marker7);
        for (Marker marker : markerList) {
            marker.setOnMarkerClickListener((clickedMarker, mapView) -> {
                showImageDialog(getDrawableResourceIdForMarker(clickedMarker));
                return true;
            });
        }

        GeoPoint markerPoint8 = new GeoPoint(39.52359590825932, -0.4517302556023056);
        Marker marker8 = new Marker(binding.map);
        marker8.setPosition(markerPoint8);
        marker8.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        marker8.setTitle("Concesionario 8");
        Drawable icon8 = getResources().getDrawable(R.drawable.concesionario8);
        Bitmap bitmap8 = ((BitmapDrawable) icon8).getBitmap();
        marker8.setIcon(new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap8, 50, 50, true)));
        markerList.add(marker8);
        for (Marker marker : markerList) {
            marker.setOnMarkerClickListener((clickedMarker, mapView) -> {
                showImageDialog(getDrawableResourceIdForMarker(clickedMarker));
                return true;
            });
        }

        GeoPoint markerPoint9 = new GeoPoint(39.43455727246679, -0.37413931414501556);
        Marker marker9 = new Marker(binding.map);
        marker9.setPosition(markerPoint9);
        marker9.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        marker9.setTitle("Concesionario 9");
        Drawable icon9 = getResources().getDrawable(R.drawable.concesionario9);
        Bitmap bitmap9 = ((BitmapDrawable) icon9).getBitmap();
        marker9.setIcon(new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap9, 50, 50, true)));
        markerList.add(marker9);
        for (Marker marker : markerList) {
            marker.setOnMarkerClickListener((clickedMarker, mapView) -> {
                showImageDialog(getDrawableResourceIdForMarker(clickedMarker));
                return true;
            });
        }

        GeoPoint markerPoint10 = new GeoPoint(38.99919476446701, -0.1761909482249596);
        Marker marker10 = new Marker(binding.map);
        marker10.setPosition(markerPoint10);
        marker10.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
        marker10.setTitle("Concesionario 10");
        Drawable icon10 = getResources().getDrawable(R.drawable.concesionario10);
        Bitmap bitmap10 = ((BitmapDrawable) icon10).getBitmap();
        marker10.setIcon(new BitmapDrawable(getResources(), Bitmap.createScaledBitmap(bitmap10, 50, 50, true)));
        markerList.add(marker10);
        for (Marker marker : markerList) {
            marker.setOnMarkerClickListener((clickedMarker, mapView) -> {
                showImageDialog(getDrawableResourceIdForMarker(clickedMarker));
                return true;
            });
        }




        binding.map.getOverlays().addAll(markerList);




        return root;
    }



            private void showImageDialog(@DrawableRes int drawableResId) {
        // Crear un ImageView para mostrar la imagen ampliada
        ImageView imageView = new ImageView(requireContext());
        imageView.setImageResource(drawableResId);

        // Mostrar el cuadro de diálogo con la imagen ampliada
        new MaterialAlertDialogBuilder(requireContext())
                .setView(imageView)
                .setPositiveButton("Cerrar", (dialog, which) -> {
                    // Cerrar el cuadro de diálogo al hacer clic en "Cerrar"
                    dialog.dismiss();
                })
                .show();
    }


    private @DrawableRes int getDrawableResourceIdForMarker(Marker marker) {

        switch (marker.getTitle()) {
            case "Concesionario 1":
                return R.drawable.concesionario1;
            case "Concesionario 2":
                return R.drawable.concesionario2;
            case "Concesionario 3":
                return R.drawable.concesionario3;
            case "Concesionario 4":
                return R.drawable.concesionario4;
            case "Concesionario 5":
                return R.drawable.concesionario5;
            case "Concesionario 6":
                return R.drawable.concesionario6;
            case "Concesionario 7":
                return R.drawable.concesionario7;
            case "Concesionario 8":
                return R.drawable.concesionario8;
            case "Concesionario 9":
                return R.drawable.concesionario9;
            case "Concesionario 10":
                return R.drawable.concesionario10;
            default:

                return android.R.drawable.ic_dialog_alert;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        binding.map.onResume(); //needed for compass, my location overlays, v6.0.0 and up
    }

    @Override
    public void onPause() {
        super.onPause();
        //this will refresh the osmdroid configuration on resuming.
        //if you make changes to the configuration, use
        //SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        //Configuration.getInstance().save(this, prefs);
        binding.map.onPause();  //needed for compass, my location overlays, v6.0.0 and up
    }
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}