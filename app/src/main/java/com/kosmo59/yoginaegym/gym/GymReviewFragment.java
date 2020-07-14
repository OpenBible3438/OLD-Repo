package com.kosmo59.yoginaegym.gym;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kosmo59.yoginaegym.R;

public class GymReviewFragment extends Fragment {

    public GymReviewFragment() {
        // Required empty public constructor
    }
    Context gymProfileActivity = null;
    public GymReviewFragment(Context gymProfileActivity) {
        this.gymProfileActivity = gymProfileActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gym_review, container, false);
    }
}
