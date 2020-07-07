package com.kosmo59.yoginaegym.gym;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.kosmo59.yoginaegym.R;

public class PRImageFragment extends Fragment {

    private Context context;
    private GridView gv_prImage;

    public PRImageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_p_r_image, container, false);

        context = container.getContext();
        gv_prImage = view.findViewById(R.id.gv_prImage);
        gv_prImage.setAdapter(new PRImageAdapter(context));
        gv_prImage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, position+"번째 사진 클릭", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
