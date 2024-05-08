package com.test.miniproject1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;

public class UsersActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnUsersActLoadUsers, btnUsersActQuit;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        btnUsersActLoadUsers = findViewById(R.id.btnUsersActLoadUsers);
        btnUsersActQuit = findViewById(R.id.btnUsersActQuit);

        btnUsersActLoadUsers.setOnClickListener(this);
        btnUsersActQuit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnUsersActLoadUsers) {
            InputStream inputStream = getResources().openRawResource(R.raw.users);
            try {
                Toast.makeText(this, Character.toString((char) inputStream.read()), Toast.LENGTH_SHORT).show();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (v.getId() == R.id.btnUsersActQuit) {
            finish();
        }
    }
}