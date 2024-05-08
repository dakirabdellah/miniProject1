package com.test.miniproject1;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class UsersActivity extends AppCompatActivity implements View.OnClickListener {
    Button btnUsersActLoadUsers, btnUsersActQuit;
    RadioButton isMale,isFamele;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);

        btnUsersActLoadUsers = findViewById(R.id.btnUsersActLoadUsers);
        btnUsersActQuit = findViewById(R.id.btnUsersActQuit);

        btnUsersActLoadUsers.setOnClickListener(this);
        btnUsersActQuit.setOnClickListener(this);
        isFamele=findViewById(R.id.isFamele);
        isMale=findViewById(R.id.isMale);
        isMale.setChecked(true);


    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnUsersActLoadUsers) {
            try {
                InputStream inputStream = getAssets().open("users.json");
                int code;
                StringBuilder stringBuilder = new StringBuilder();
                String jsonString;

                code = inputStream.read();
                while (code != -1) {
                    stringBuilder.append((char) code);

                    code = inputStream.read();
                }
                jsonString = stringBuilder.toString();

                JSONObject jsonObject = new JSONObject(jsonString);
//                JSONArray jsonArray = (JSONArray) jsonObject.get("users");
                JSONArray jsonArray = jsonObject.getJSONArray("users");
                StringBuilder stringBuilderFullNames = new StringBuilder();
                String title="";
                for (int i = 0; i < jsonArray.length(); i++) {
                    JSONObject user = jsonArray.getJSONObject(i);
                    JSONObject userName = user.getJSONObject("name");
                    String fullName = String.format("%s %s\n", userName.get("first"), userName.get("last"));
                    if (isMale.isChecked() && user.getString("gender").equals("male")) {
                        stringBuilderFullNames.append(fullName);
                        title="Male user";
                    } else if (isFamele.isChecked() && user.getString("gender").equals("female")) {
                        stringBuilderFullNames.append(fullName);
                        title="Famele user";

                    }
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle(title);
                builder.setMessage(stringBuilderFullNames.toString());
                AlertDialog dialog = builder.create();
                dialog.show();

            } catch (IOException | JSONException e) {
                e.printStackTrace();
            }
        } else if (v.getId() == R.id.btnUsersActQuit) {
            finish();
        }
    }


}