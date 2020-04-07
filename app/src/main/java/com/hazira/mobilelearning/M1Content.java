package com.hazira.mobilelearning;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.github.barteksc.pdfviewer.PDFView;

public class M1Content extends AppCompatActivity {

    public PDFView pdfViewMateri;
    public float zoomValue = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1_content);

        Toolbar toolbar = findViewById(R.id.toolbarContent);
        setSupportActionBar(toolbar);


        Intent intent = getIntent();
        String value = intent.getExtras().getString("file");
        String title = intent.getExtras().getString("headTitle");

        pdfViewMateri = (PDFView) findViewById(R.id.pdfViewContent);
        pdfViewMateri.fromAsset(value)
                .spacing(0)
                .enableSwipe(true)
                .enableDoubletap(true)
                .defaultPage(0)
                .load();

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setTitle(title);
        }


    }

    public void nextPage(View view) {

        pdfViewMateri.jumpTo(pdfViewMateri.getCurrentPage() + 1, true);
    }

    public void prevPage(View view) {

        pdfViewMateri.jumpTo(pdfViewMateri.getCurrentPage() - 1, true);
    }

    public void zoomIn(View view) {
        ++zoomValue;
        pdfViewMateri.zoomTo(zoomValue);
        pdfViewMateri.loadPages();
    }

    public void zoomOut(View view) {

        if (zoomValue != 1) {
            --zoomValue;
            pdfViewMateri.zoomTo(zoomValue);
            pdfViewMateri.loadPages();
        }

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

    //Video
    public void PlayVideo(View view) {
        Intent intents = getIntent();
        String vidLink=intents.getExtras().getString("videoLink");
        String vidTitle=intents.getExtras().getString("headTitle");
        Intent intentVideo = new Intent(this, YoutubePlayerActivity.class);
        intentVideo.putExtra("videoURI", vidLink).putExtra("videoTitle",vidTitle);
        startActivity(intentVideo);
    }
    //End of Video
}