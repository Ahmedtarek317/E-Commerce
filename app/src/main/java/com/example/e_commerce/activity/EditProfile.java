package com.example.e_commerce.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_commerce.Database.MyDatabase;
import com.example.e_commerce.Model.CustomerModel;
import com.example.e_commerce.R;

public class EditProfile extends AppCompatActivity {
    EditText et_username, et_email, et_password, et_birthday;
    Button btn_edit_profile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        et_username = findViewById(R.id.edit_profile_txt_username);
        et_email = findViewById(R.id.edit_profile_txt_email);
        et_password = findViewById(R.id.edit_profile_txt_password);
        et_birthday = findViewById(R.id.edit_profile_txt_birthday);
        btn_edit_profile = findViewById(R.id.edit_product_btn_edit);

        MyDatabase db = MyDatabase.getInstance(this);
        Intent i = getIntent();
        int user_id = i.getExtras().getInt("id");
        String username = i.getExtras().getString("username");
        String email = i.getExtras().getString("email");
        String password = i.getExtras().getString("password");
        String birthdate = i.getExtras().getString("birthdate");

        et_username.setText(username);
        et_email.setText(email);
        et_password.setText(password);
        et_birthday.setText(birthdate);


        btn_edit_profile.setOnClickListener(view -> {
            String updatedUsername = et_username.getText().toString();
            String updatedEmail = et_email.getText().toString();
            String updatedPassword = et_password.getText().toString();
            String updatedBirthday = et_birthday.getText().toString();

            CustomerModel updatedUser = new CustomerModel(user_id, updatedUsername, updatedEmail, updatedPassword, updatedBirthday);
            db.updateUser(updatedUser);
            Toast.makeText(EditProfile.this, "Profile updated successfully", Toast.LENGTH_SHORT).show();
        });
    }
}