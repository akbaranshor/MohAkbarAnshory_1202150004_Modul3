package com.example.android.mohakbaranshory_1202150004_modul3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /**
     * Membuat perkondisian, dimana jika username dan password tidak sesuai nilai yang dinginkan
     * maka, akan muncul toast gagal login. Dan akan muncul toast berhasil lalu pindah ke layout
     * list merk air, jika username dan pass sesuai.
     *
     * @param view
     */
    public void login(View view) {
        EditText username = findViewById(R.id.username_edit);
        EditText password = findViewById(R.id.password_edit);
        String message;
        if (username.getText().toString().equals("EAD") && password.getText().toString().equals("MOBILE")) {
            message = "Berhasil login";
            startActivity(new Intent(this, MainActivity.class));
        } else {
            message = "Gagal login";
            finish();
            startActivity(getIntent());
        }
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
