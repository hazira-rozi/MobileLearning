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


public class M2Activity extends AppCompatActivity {

    public static final String FRAGMENT_PDF_RENDERER_BASIC = "pdf_renderer_basic";

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m2);

        Toolbar toolbar = findViewById(R.id.toolbar_m2);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomHomeNav = findViewById(R.id.bottom_m2);
        bottomHomeNav.setOnNavigationItemSelectedListener(botNavListener_m2);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);

        }

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_m2,
                    new M2Fragment()).commit();
        }


    }

    private BottomNavigationView.OnNavigationItemSelectedListener botNavListener_m2 =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    int title = R.string.titleMateri2;
                    switch (item.getItemId()) {
                        case R.id.nav_materi_2:
                            selectedFragment = new M2Fragment();
                            title = R.string.titleMateri2;
                            break;
//                        case R.id.langkah_2:
//                            selectedFragment = new M1LangkahFragment();
//                            title = R.string.titleMateriLangkah;
//                            break;
//                        case R.id.latihan_2:
//                            selectedFragment = new M1LatihanFragment();
//                            title = R.string.titleMateriLatihan;
//                            break;
                        case R.id.nav_evaluasi_2:
                            selectedFragment = new M2EvaluasiFragment();
                            title = R.string.titleMateriEvaluas;
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_m2,
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

    public void openMateri2(View view){
        Intent intentMateri_2 = new Intent(this, M2Content.class);
        intentMateri_2.putExtra("file","bab2.pdf");
        startActivity(intentMateri_2);
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