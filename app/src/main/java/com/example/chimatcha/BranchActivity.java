package com.example.chimatcha;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class BranchActivity
        extends AppCompatActivity {

//    RecyclerView recyclerBranch;
    ImageButton btnLogout;

    LinearLayout navHome,
            navItems;

    @Override
    protected void onCreate(
            Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(
                R.layout.activity_branch);

        btnLogout =
                findViewById(
                        R.id.btnLogout);

//        recyclerBranch =
//                findViewById(
//                        R.id.recyclerBranch);

        navHome =
                findViewById(
                        R.id.navHome);

        navItems =
                findViewById(
                        R.id.navItems);

//        recyclerBranch.setLayoutManager(
//                new LinearLayoutManager(
//                        this));

        navHome.setOnClickListener(v -> {

            startActivity(
                    new Intent(
                            this,
                            HomeActivity.class));
        });

        navItems.setOnClickListener(v -> {

            startActivity(
                    new Intent(
                            this,
                            ItemActivity.class));
        });

        btnLogout.setOnClickListener(v -> {

            startActivity(
                    new Intent(
                            this,
                            LoginActivity.class));

            finish();
        });
    }
}