package com.example.e_commerce.activity;

import androidx.appcompat.app.AppCompatActivity;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.e_commerce.Database.MyDatabase;
import com.example.e_commerce.Model.CustomerModel;
import com.example.e_commerce.R;
import java.util.ArrayList;

public class Login extends AppCompatActivity {
    MyDatabase obj;
    EditText eusername,epassword;
    TextView error,forget_password,reg;
    boolean flag=true;
    Button login;

    String value=null,value2=null;
    CheckBox rememberme;

    //public static String u_name="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("Login");

        reg=(TextView)findViewById(R.id.Register);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inte=new Intent(Login.this,SignUp.class);
                startActivity(inte);

            }
        });
        obj= MyDatabase.getInstance(this);
        login=(Button)findViewById(R.id.Login);
        forget_password=(TextView) findViewById(R.id.forget_password);

        rememberme=(CheckBox)findViewById(R.id.rememberme);

        SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
        String str=preferences.getString("rememberme","");
        if(str.equals("true")){
            Intent intent=new Intent(Login.this,MainActivity.class);
            startActivity(intent);
        }
        else if(str.equals("false")){
            //Toast.makeText(Login.this,"please sign in.",Toast.LENGTH_SHORT).show();
        }


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            ArrayList<CustomerModel> arrayList=obj.Get_Data();
            //Toast.makeText(Login.this,arrayList.size()+" ",Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(Login.this,MainActivity.class);
            Intent toadmin=new Intent(Login.this,UploadProduct.class);
            eusername =(EditText)findViewById(R.id.usernameinlogin);
            epassword=(EditText)findViewById(R.id.passwordinlogin);
            error=(TextView)findViewById(R.id.error);
            eusername.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    error.setText("");
                }
            });
            epassword.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    error.setText("");
                }
            });
             if(eusername.getText().toString().equals("admin")&&epassword.getText().toString().equals("admin"))
             {
              startActivity(toadmin);
             }
             else{
            if(eusername.getText().toString().equals("")){
                error.setText("Enter User Name");
            } else {
                String username = eusername.getText().toString();
                String password = epassword.getText().toString();

                Cursor cursor = obj.user_login(username, password);
                if(cursor.getCount() > 0){
                        flag=false;
                            CustomerModel user = CustomerModel.getInstance();
                            user.setId(cursor.getInt(0));
                            user.setUsername(cursor.getString(1));
                            user.setEmail(cursor.getString(2));
                            user.setPassword(cursor.getString(3));
                            user.setBirthdate(cursor.getString(4));

                            SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
                            SharedPreferences.Editor myEdit = sharedPreferences.edit();
                            myEdit.putInt("id", cursor.getInt(0));
                            myEdit.putString("name", cursor.getString(1));
                            myEdit.putString("email", cursor.getString(2));
                            myEdit.putString("password", cursor.getString(3));
                            myEdit.putString("birthdate", cursor.getString(4));
                            myEdit.apply();

                            setResult(Activity.RESULT_OK,intent);
                            startActivity(intent);
                            finish();
                        }
                    }
                if(flag){
                    error.setText("user not exist");
                    flag=false;
                }
            }
            }
        });
        forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Login.this,Forget_password.class);
                startActivity(intent);
            }
        });



        rememberme.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            if(compoundButton.isChecked()){
                SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("rememberme","true");
                editor.apply();
                //Toast.makeText(Login.this,"Checked",Toast.LENGTH_SHORT).show();
                }
            else if(!compoundButton.isChecked()){
                SharedPreferences preferences=getSharedPreferences("checkbox",MODE_PRIVATE);
                SharedPreferences.Editor editor=preferences.edit();
                editor.putString("rememberme","false");
                editor.apply();
                //Toast.makeText(Login.this,"UnChecked",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        value = getIntent().getStringExtra("key");
        value2 = getIntent().getStringExtra("key2");
        if (value != null && value2 != null) {
            eusername =(EditText)findViewById(R.id.usernameinlogin);
            eusername.setText(value);
            epassword=(EditText)findViewById(R.id.passwordinlogin);
            epassword.setText(value2);
        }
    }
    public void onLoginClick1(View view) {
        startActivity(new Intent(this,SignUp.class));
        overridePendingTransition(R.anim.slide_in_right,R.anim.stay);
    }
}
