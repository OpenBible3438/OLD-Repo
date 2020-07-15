package com.kosmo59.yoginaegym.teacher;

import android.content.Context;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kosmo59.yoginaegym.R;

public class TchInbodyFragment extends Fragment {
    private CardView cv_tch_mem_inbody;
    private Context context;

    public TchInbodyFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tch_mem_inbody, container, false);
        context = container.getContext();

        cv_tch_mem_inbody = view.findViewById(R.id.cv_tch_mem_inbody);
        cv_tch_mem_inbody.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TchMemInbodyDialog tchMemInbodyDialog = new TchMemInbodyDialog(context);
                tchMemInbodyDialog.callFunction();
            }
        });
        return view;
    }
}
