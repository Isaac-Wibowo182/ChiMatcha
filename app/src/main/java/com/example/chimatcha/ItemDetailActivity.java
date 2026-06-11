package com.example.chimatcha;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class ItemDetailActivity
        extends AppCompatActivity {

    ImageView imgProduct;
    TextView txtName,
            txtDescription,
            txtPrice;

    Spinner spinnerIce,
            spinnerSweet;

    EditText etQuantity,
            etNotes;

    Button btnOrder;
    ImageButton btnBack;

    @Override
    protected void onCreate(
            Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(
                R.layout.activity_item_detail);

        initViews();

        String name =
                getIntent()
                        .getStringExtra("name");

        int image =
                getIntent()
                        .getIntExtra(
                                "image",0);

        imgProduct.setImageResource(image);
        txtName.setText(name);

        setupProduct(name);
        setupSpinner();

        btnBack.setOnClickListener(v ->
                finish());

        btnOrder.setOnClickListener(v -> {

            String qty =
                    etQuantity
                            .getText()
                            .toString()
                            .trim();

            // validation
            if(qty.isEmpty()
                    || qty.equals("0")){

                new MaterialAlertDialogBuilder(this)
                        .setTitle("Error")
                        .setMessage(
                                "Quantity must be filled and cannot be 0")
                        .setPositiveButton(
                                "OK",null)
                        .show();

                return;
            }

            // success
            new MaterialAlertDialogBuilder(this)
                    .setTitle("Order Success")
                    .setMessage(
                            "Confirmation email has been sent.")
                    .setPositiveButton(
                            "OK",
                            (dialog, which) -> {

                                Intent intent =
                                        new Intent(
                                                this,
                                                ItemActivity.class);

                                startActivity(intent);
                                finish();
                            })
                    .show();
        });
    }

    private void initViews(){

        imgProduct =
                findViewById(R.id.imgProduct);

        txtName =
                findViewById(R.id.txtName);

        txtDescription =
                findViewById(R.id.txtDescription);

        txtPrice =
                findViewById(R.id.txtPrice);

        spinnerIce =
                findViewById(R.id.spinnerIce);

        spinnerSweet =
                findViewById(R.id.spinnerSweet);

        btnOrder =
                findViewById(R.id.btnOrder);

        btnBack =
                findViewById(R.id.btnBack);
    }

    private void setupSpinner(){

        String[] levels = {
                "Normal",
                "Less",
                "More"
        };

        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(
                        this,
                        android.R.layout
                                .simple_spinner_dropdown_item,
                        levels);

        spinnerIce.setAdapter(adapter);
        spinnerSweet.setAdapter(adapter);
    }

    private void setupProduct(
            String name){

        switch(name){

            case "Matcha Cake":
                txtDescription.setText(
                        "Soft and creamy matcha cake layered with premium Japanese matcha flavor.");

                txtPrice.setText(
                        "Rp 32.000");
                break;

            case "Pure Matcha":
                txtDescription.setText(
                        "Authentic pure matcha drink with rich earthy taste.");

                txtPrice.setText(
                        "Rp 28.000");
                break;

            case "Matcha Sundae":
                txtDescription.setText(
                        "Creamy sundae blended with refreshing matcha flavor.");

                txtPrice.setText(
                        "Rp 25.000");
                break;

            default:
                txtDescription.setText(
                        "Premium matcha latte crafted with smooth creamy milk and rich matcha.");

                txtPrice.setText(
                        "Rp 35.000");
        }
    }
}