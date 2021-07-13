package com.example.madcamp_week2;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Bundle;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Base64;
import android.util.Log;

import com.example.madcamp_week2.ui.main.SectionsPagerAdapter;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MainActivity extends AppCompatActivity {
    CustomViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTheme(R.style.NoBarTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);

        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


    }

    public void switchToRestPage(String id) {
        Intent intent = new Intent(this, RestaurantActivity.class);
        intent.putExtra("restId", id);
        startActivity(intent);
    }

    public void switchToPostPage(String postId) {
        Intent intent = new Intent(this, DetailPostActivity.class);
        intent.putExtra("postId", postId);
        startActivity(intent);
    }

}