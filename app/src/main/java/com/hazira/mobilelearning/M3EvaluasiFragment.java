package com.hazira.mobilelearning;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class M3EvaluasiFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        ((M2Activity) getActivity()).setActionBarTitle(" Materi 2 - Evaluasi");
        return inflater.inflate(R.layout.fragment_materi2_evaluasi, container, false);
    }
}
