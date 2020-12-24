package com.example.aboutme;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.aboutme.databinding.ActivityContactBinding;

public class ContactActivity extends AppCompatActivity {
    private ActivityContactBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ActivityContactBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.imLinkedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent linkedingIntent = new Intent(Intent.ACTION_VIEW);

                linkedingIntent.setData(Uri.parse("https://www.linkedin.com/in/garcyvalenzuela/"));
                startActivity(linkedingIntent);

                Toast.makeText(ContactActivity.this, "", Toast.LENGTH_SHORT).show();
            }

        });

        mBinding.imFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent facebookIntent = new Intent(Intent.ACTION_VIEW);

                facebookIntent.setData(Uri.parse("https://www.facebook.com/garcyv/"));
                startActivity(facebookIntent);

                Toast.makeText(ContactActivity.this, "", Toast.LENGTH_SHORT).show();
            }

        });
    }
}