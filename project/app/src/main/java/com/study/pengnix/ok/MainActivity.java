package com.study.pengnix.ok;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.study.pengnix.ok.activity.CoordinatorLayoutDemoActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.jump2_coordinator_layout_demo).setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, CoordinatorLayoutDemoActivity.class);
            startActivity(intent);
        });
    }
}
