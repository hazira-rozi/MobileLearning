package com.hazira.mobilelearning;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class M3Activity extends AppCompatActivity {

    public static final String FRAGMENT_PDF_RENDERER_BASIC = "pdf_renderer_basic";

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m3);

        Toolbar toolbar = findViewById(R.id.toolbar_m3);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomHomeNav = findViewById(R.id.bottom_m3);
        bottomHomeNav.setOnNavigationItemSelectedListener(botNavListener_m3);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_m3,
                    new M3Fragment()).commit();


        }


    }

    private BottomNavigationView.OnNavigationItemSelectedListener botNavListener_m3 =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    int title = R.string.titleMateri3;
                    switch (item.getItemId()) {
                        case R.id.nav_materi_3:
                            selectedFragment = new M3Fragment();
                            title = R.string.titleMateri3;
                            break;
//                        case R.id.langkah_2:
//                            selectedFragment = new M1LangkahFragment();
//                            title = R.string.titleMateriLangkah;
//                            break;
//                        case R.id.latihan_2:
//                            selectedFragment = new M1LatihanFragment();
//                            title = R.string.titleMateriLatihan;
//                            break;
                        case R.id.nav_evaluasi_3:
                            selectedFragment = new M3EvaluasiFragment();
                            title = R.string.titleMateriEvaluas;
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_m3,
                            selectedFragment).commit();
                    if (getSupportActionBar() != null) {
                        getSupportActionBar().setTitle(title);
                    }
                    return true;
                }
            };


    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }

    /* button evaluasi */
    public void ev2(View viewQuiz) {
        switch (viewQuiz.getId()) {
            case R.id.button_evaluasi_excel:
                Intent quizIntent_q2_1 = new Intent(this, Quiz2Activity.class);
                startActivity(quizIntent_q2_1);
                break;
        }
    }


    /*button to open lesson*/
    public void openMateri3(View view) {
        String materi = "bab3preface.pdf";
        switch (view.getId()) {
            case R.id.buttonbab3:
                materi = "bab3preface.pdf";
                break;
            case R.id.buttonWord:
                materi = "bab3word.pdf";
                break;
            case R.id.buttonExcel:
                materi = "bab3excel.pdf";
                break;
            case R.id.buttonPPt:
                materi = "bab3ppt.pdf";
                break;
        }
        Intent intentMateri_3 = new Intent(this, M3Content.class);
        intentMateri_3.putExtra("file", materi);
        startActivity(intentMateri_3);
    }

    //PDF Code

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem items) {
        switch (items.getItemId()) {
            case R.id.action_info:
                new AlertDialog.Builder(this)
                        .setMessage(R.string.intro_message)
                        .setPositiveButton(android.R.string.ok, null)
                        .show();
                return true;

            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(items);
    }
}