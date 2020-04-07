package com.hazira.mobilelearning;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.VideoView;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Toolbar toolbar = findViewById(R.id.toolbarVideo);
        setSupportActionBar(toolbar);

        VideoView vv = findViewById(R.id.videoViewMateri);
        Intent intent = getIntent();

        int vFile = intent.getExtras().getInt("videoFile");
        String vtitle = intent.getExtras().getString("videoTitle");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(vtitle);
        }


        String path = String.format("android.resource://" + getPackageName() + "/" + vFile);
        vv.setVideoURI(Uri.parse(path));

        vv.start();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem items) {
        switch (items.getItemId()) {
//            case R.id.bottom_home:
//                new AlertDialog.Builder(this)
//                        .setMessage(R.string.intro_message)
//                        .setPositiveButton(android.R.string.ok, null)
//                        .show();
//                return true;

            case android.R.id.home:
                super.onBackPressed();
                finish();
        }
        return super.onOptionsItemSelected(items);
    }
}