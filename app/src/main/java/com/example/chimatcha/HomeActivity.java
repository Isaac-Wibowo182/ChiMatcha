package com.example.chimatcha;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

public class HomeActivity
        extends AppCompatActivity {

    ViewPager2 viewPager;
    Button btnPrev, btnNext;
    ImageButton btnLogout;
    TextView tvWelcome;

    int[] images = {
            R.drawable.image_carousel1,
            R.drawable.image_carousel2,
            R.drawable.image_carousel3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        viewPager =
                findViewById(R.id.viewPager);

        btnPrev =
                findViewById(R.id.btnPrev);

        btnNext =
                findViewById(R.id.btnNext);

        btnLogout =
                findViewById(R.id.btnLogout);

        tvWelcome =
                findViewById(R.id.tvWelcome);

        String username =
                getIntent()
                        .getStringExtra("username");

        tvWelcome.setText(
                "Welcome, " + username);

        ImageAdapter adapter =
                new ImageAdapter(images);

        viewPager.setAdapter(adapter);

        viewPager.setPageTransformer(
                (page, position) -> {

                    page.setAlpha(
                            0.25f +
                                    (1 - Math.abs(position)));

                    page.setScaleY(
                            0.85f +
                                    (1 - Math.abs(position))
                                            * 0.15f);
                });

        btnNext.setOnClickListener(v -> {

            int current =
                    viewPager.getCurrentItem();

            if(current < images.length - 1){
                viewPager
                        .setCurrentItem(
                                current + 1,
                                true);
            }
        });

        btnPrev.setOnClickListener(v -> {

            int current =
                    viewPager.getCurrentItem();

            if(current > 0){
                viewPager
                        .setCurrentItem(
                                current - 1,
                                true);
            }
        });

        btnLogout.setOnClickListener(v -> {

            Intent intent =
                    new Intent(
                            HomeActivity.this,
                            LoginActivity.class);

            startActivity(intent);
            finish();
        });
    }
}