package com.example.rasmus.test_uppdrag_firebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoggedInActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        mAuth = FirebaseAuth.getInstance();

        if(mAuth.getCurrentUser() != null)
            setText();
        else
            finish();

        FirebaseNotification fcm = new FirebaseNotification();
        fcm.onTokenRefresh();

    }

    private void setText(){
        TextView userText = findViewById(R.id.loggedInText);
        FirebaseUser user = mAuth.getCurrentUser();
        String username = user.getDisplayName();
        String email = user.getEmail();
        String text = "Currently logged in as " + username +"\n" + "Your email: " + email;
        userText.setText(text);
    }

    public void signOut(View view){
        mAuth.signOut();
        finish();
    }


}
