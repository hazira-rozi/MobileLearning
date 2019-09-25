package com.hazira.mobilelearning;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.fragment.app.Fragment;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.app.AlertDialog;


public class M1Activity extends AppCompatActivity {

    public static final String FRAGMENT_PDF_RENDERER_BASIC = "pdf_renderer_basic";

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m1);

        Toolbar toolbar = findViewById(R.id.toolbar_m1);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomHomeNav = findViewById(R.id.bottom_m1);
        bottomHomeNav.setOnNavigationItemSelectedListener(botNavListener_m1);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_m1,
                    new M1Fragment()).commit();


        }


    }

    private BottomNavigationView.OnNavigationItemSelectedListener botNavListener_m1 =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    int title = R.string.titleMateri1;
                    switch (item.getItemId()) {
                        case R.id.nav_materi_1:
                            selectedFragment = new M1Fragment();
                            title = R.string.titleMateri1;
                            break;
                        case R.id.langkah_1:
                            selectedFragment = new M1LangkahFragment();
                            title = R.string.titleMateriLangkah;
                            break;
                        case R.id.latihan_1:
                            selectedFragment = new M1LatihanFragment();
                            title = R.string.titleMateriLatihan;
                            break;
                        case R.id.evaluasi_1:
                            selectedFragment = new M1EvaluasiFragment();
                            title = R.string.titleMateriEvaluas;
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_m1,
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
    public void ev1(View viewQuiz) {
        switch (viewQuiz.getId()) {
            case R.id.button_evaluasi_1_1:
                Intent quizIntent_q1_1 = new Intent(this, Quiz1Activity.class);
                startActivity(quizIntent_q1_1);
                break;
        }
    }

    public void openMateri1(View view){
        Intent intentMateri_1 = new Intent(this, M1Content.class);
        startActivity(intentMateri_1);
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