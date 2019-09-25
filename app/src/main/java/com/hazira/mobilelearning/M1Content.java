package com.hazira.mobilelearning;


import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.github.barteksc.pdfviewer.PDFView;

public class M1Content extends AppCompatActivity {

    public PDFView pdfViewMateri1;
    public float zoomValue = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1_content);

        pdfViewMateri1 = (PDFView) findViewById(R.id.pdfView2);
        pdfViewMateri1.fromAsset("word.pdf")
                // .spacing(10)
                .enableSwipe(true) // allows to block changing pages using swipe
                .swipeHorizontal(true)
                .enableDoubletap(true)
                .defaultPage(0)
                .load();
    }

    public void nextPage(View view) {

        pdfViewMateri1.jumpTo(pdfViewMateri1.getCurrentPage() + 1, true);
    }

    public void prevPage(View view) {

        pdfViewMateri1.jumpTo(pdfViewMateri1.getCurrentPage() - 1, true);
    }

    public void zoomIn(View view) {
        ++zoomValue;
        pdfViewMateri1.zoomTo(zoomValue);
        pdfViewMateri1.loadPages();

    }

    public void zoomOut(View view) {

        if (zoomValue != 1) {
            --zoomValue;
            pdfViewMateri1.zoomTo(zoomValue);
            pdfViewMateri1.loadPages();
        }

    }
}