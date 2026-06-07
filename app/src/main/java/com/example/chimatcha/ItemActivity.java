package com.example.chimatcha;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemActivity
        extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageButton btnLogout;

    LinearLayout navHome,
            navBranch;

    ArrayList<MatchaModel> list =
            new ArrayList<>();

    @Override
    protected void onCreate(
            Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(
                R.layout.activity_item);

        recyclerView =
                findViewById(
                        R.id.recyclerItems);

        btnLogout =
                findViewById(
                        R.id.btnLogout);

        navHome =
                findViewById(
                        R.id.navHome);

        navBranch =
                findViewById(
                        R.id.navBranch);

        // DATA
        list.add(new MatchaModel(
                "Matcha Cake",
                R.drawable.matcha_cake));

        list.add(new MatchaModel(
                "Pure Matcha",
                R.drawable.pure_matcha));

        list.add(new MatchaModel(
                "Matcha Sundae",
                R.drawable.matcha_sundae));

        list.add(new MatchaModel(
                "Matcha Latte",
                R.drawable.matcha_latte));

        ItemAdapter adapter =
                new ItemAdapter(
                        this,
                        list);

        recyclerView
                .setLayoutManager(
                        new GridLayoutManager(
                                this,
                                2));

        recyclerView
                .setAdapter(adapter);

        // NAVIGATION
        navHome.setOnClickListener(v -> {

            startActivity(
                    new Intent(
                            this,
                            HomeActivity.class));
        });

        navBranch.setOnClickListener(v -> {

            startActivity(
                    new Intent(
                            this,
                            BranchActivity.class));
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