package org.microg.gms.ui;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

<<<<<<< HEAD:play-services-core/src/main/java/org/microg/gms/ui/SettingsActivity.java
import com.google.android.material.color.DynamicColors;
import com.mgoogle.android.gms.R;
=======
import com.google.android.gms.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import org.microg.gms.ui.settings.SettingsProvider;
>>>>>>> 566215bd (UI: Port more to Material 3):play-services-core/src/main/java/org/microg/gms/ui/MainSettingsActivity.java

import java.util.Objects;

public class SettingsActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;

    private NavController getNavController() {
        return ((NavHostFragment) Objects.requireNonNull(getSupportFragmentManager().findFragmentById(R.id.navhost))).getNavController();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_root_activity);
<<<<<<< HEAD:play-services-core/src/main/java/org/microg/gms/ui/SettingsActivity.java
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
            DynamicColors.applyToActivityIfAvailable(this);
=======

        Toolbar toolbar = findViewById(R.id.toolbar);
        CollapsingToolbarLayout toolbarLayout = findViewById(R.id.collapsing_toolbar);
        setSupportActionBar(toolbar);

        for (SettingsProvider settingsProvider : getAllSettingsProviders(this)) {
            settingsProvider.extendNavigation(getNavController());
>>>>>>> 566215bd (UI: Port more to Material 3):play-services-core/src/main/java/org/microg/gms/ui/MainSettingsActivity.java
        }
        appBarConfiguration = new AppBarConfiguration.Builder(getNavController().getGraph()).build();
        NavigationUI.setupWithNavController(toolbarLayout, toolbar, getNavController(), appBarConfiguration);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(getNavController(), appBarConfiguration) || super.onSupportNavigateUp();
    }
}
