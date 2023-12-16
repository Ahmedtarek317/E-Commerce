package com.example.e_commerce.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_commerce.Database.MyDatabase;
import com.example.e_commerce.R;

public class deleteUser extends AppCompatActivity {
MyDatabase db;
EditText userId;
Button delete;
private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_user);
        userId=(EditText) findViewById(R.id.idfordel);
        delete=(Button) findViewById(R.id.deleteUser);
        db=MyDatabase.getInstance(context);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userId.getText().toString().equals("")){

                    Toast.makeText(deleteUser.this, "Enter Id to delete", Toast.LENGTH_SHORT).show();
                }
                else{
                    String id=userId.getText().toString();
                    boolean x=db.checkuserexist(id);
                   if(x==true){
                       String ss=db.daletecust(id);
                       Toast.makeText(deleteUser.this, ss, Toast.LENGTH_SHORT).show();
                   }
                   else{
                       Toast.makeText(deleteUser.this, "ID does not exist in the database", Toast.LENGTH_SHORT).show();
                   }
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.adminmenu5,menu);
        return super.onCreateOptionsMenu(menu);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.uploadproduct11:
                Intent i1 = new Intent(deleteUser.this, UploadProduct.class);
                startActivity(i1);
                return true;
            case R.id.report:
                Intent i2 = new Intent(deleteUser.this, ReportGenerated.class);
                startActivity(i2);
                return true;
            case R.id.chart:
                Intent i3 = new Intent(deleteUser.this, ChartGenerated.class);
                startActivity(i3);
                return true;
            case R.id.feedback:
                Intent i4 = new Intent(deleteUser.this, ShowRating.class);
                startActivity(i4);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}