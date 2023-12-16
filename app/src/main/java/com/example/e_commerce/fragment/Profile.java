package com.example.e_commerce.fragment;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.example.e_commerce.Model.CustomerModel;
import com.example.e_commerce.R;
import com.example.e_commerce.activity.EditProfile;


/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class Profile extends Fragment {
    TextView username, email, password, birthdate;
    Button btn_edit;
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER



    public Profile() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profie, container, false);
        CustomerModel user = CustomerModel.getInstance();

        username = v.findViewById(R.id.profile_tv_username);
        email = v.findViewById(R.id.profile_tv_email);
        password = v.findViewById(R.id.profile_tv_paswword);
        birthdate = v.findViewById(R.id.profile_tv_birthdate);

        username.setText(user.getUsername());
        email.setText(user.getEmail());
        password.setText(user.getPassword());
        birthdate.setText(user.getBirthdate());



        btn_edit = v.findViewById(R.id.update);
        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user != null && getActivity() != null) {
                    Intent i = new Intent(getActivity(), EditProfile.class);
                    i.putExtra("id", user.getId());
                    i.putExtra("username", user.getUsername());
                    i.putExtra("email", user.getEmail());
                    i.putExtra("password", user.getPassword());
                    i.putExtra("birthdate", user.getBirthdate());
                    startActivity(i);
                }
                else{
                    Log.e("YourTag", "User or activity is null");
                }
            }
        });

        return v;
    }

}