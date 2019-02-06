package com.example.kylo.acm_app.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

//Firebase Imports
import com.example.kylo.acm_app.R;
import com.example.kylo.acm_app.model.user.User;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private DatabaseReference mDatabaseReference;
    private List<User> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //gets a reference to the database
        mDatabaseReference = FirebaseDatabase.getInstance().getReference();
        users = new ArrayList<>();
        getUsers();
    }

    protected void getUsers() {
        Query query = mDatabaseReference.child(getString(R.string.users));

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot singleSnapshot : dataSnapshot.getChildren()) {
                    Log.d("getDataChange:","found user");
                    User user = singleSnapshot.getValue(User.class);

                    users.add(user);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                //Do Nothing
            }
        });
    }
}
