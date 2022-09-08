package com.mickey.demorobomaster;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.mickey.demorobomaster.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private AppBarConfiguration appBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        com.mickey.demorobomaster.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);


        Button bt_demos = (Button) findViewById(R.id.bt_demos);

        bt_demos.setOnClickListener(view -> navController.navigate(R.id.action_FirstFragment_to_secondFragment));

        Button bt_doc = (Button) findViewById(R.id.bt_doc);

        bt_doc.setOnClickListener(view -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://robomaster-dev.readthedocs.io/en/latest/index.html"));
            startActivity(browserIntent);
            navController.navigate(R.id.action_FirstFragment_to_documentation);
        });

        Button bt_desc = (Button) findViewById(R.id.bt_desc);

        bt_desc.setOnClickListener(view -> navController.navigate(R.id.action_FirstFragment_to_description));


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        super.recreate();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.recreate();
        super.onBackPressed();
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }

}