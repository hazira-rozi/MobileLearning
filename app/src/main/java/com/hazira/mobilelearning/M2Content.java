package com.hazira.mobilelearning;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class M2Content extends AppCompatActivity {

    public PDFView pdfViewMateri2;
    public float zoomValue = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m2_content);
        Intent intent = getIntent();
        String value = intent.getExtras().getString("file");

        pdfViewMateri2 = (PDFView) findViewById(R.id.pdfViewExcel);
        pdfViewMateri2.fromAsset(value)
                // .spacing(10)
                .enableSwipe(true) // allows to block changing pages using swipe
//                .swipeHorizontal(true)
                .enableDoubletap(true)
                .defaultPage(0)
                .load();
    }

    public void nextPage(View view) {

        pdfViewMateri2.jumpTo(pdfViewMateri2.getCurrentPage() + 1, true);
    }

    public void prevPage(View view) {

        pdfViewMateri2.jumpTo(pdfViewMateri2.getCurrentPage() - 1, true);
    }

    public void zoomIn(View view) {
        ++zoomValue;
        pdfViewMateri2.zoomTo(zoomValue);
        pdfViewMateri2.loadPages();

    }

    public void zoomOut(View view) {

        if (zoomValue != 1) {
            --zoomValue;
            pdfViewMateri2.zoomTo(zoomValue);
            pdfViewMateri2.loadPages();
        }

    }
}