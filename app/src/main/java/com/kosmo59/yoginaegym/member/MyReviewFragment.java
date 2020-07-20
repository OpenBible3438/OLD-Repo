package com.kosmo59.yoginaegym.member;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kosmo59.yoginaegym.MainActivity;
import com.kosmo59.yoginaegym.R;
import com.kosmo59.yoginaegym.common.AppVO;
import com.kosmo59.yoginaegym.common.TomcatSend;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyReviewFragment extends Fragment {

    private Context context;
    private TextView my_review_reg;
    private ImageButton icon_close;
    private Button btn_myReviewReg_ins;
    private ListView memRevList;

    public MyReviewFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my_review, container, false);
        context = container.getContext();

        AppVO vo = (AppVO)context.getApplicationContext();
        Log.i("vo : ",vo+"");
        int memno = vo.getMem_no();
        Log.i("memno : ",memno+"");
        Map<String, Object> map = new HashMap<>();
        map.put("mem_no",memno);
        String url = "android/jsonRevMemList.gym";
        String result = null;
        try {
            TomcatSend tomcatSend = new TomcatSend();
            result = tomcatSend.execute(url, map.toString()).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<Map<String, Object>> revList = null;
        Type listType = new TypeToken<List<Map<String, Object>>>(){}.getType();
        Gson gson = new Gson();
        revList = (List<Map<String, Object>>)gson.fromJson(result, listType);
        MyReviewAdapter myReviewAdapter = new MyReviewAdapter(context, R.layout.my_review_list_item,  revList, result);
        memRevList = view.findViewById(R.id.gym_myReviewList);
        memRevList.setAdapter(myReviewAdapter);

        // Inflate the layout for this fragment
        my_review_reg = view.findViewById(R.id.my_review_reg);
        my_review_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyReviewRegDialog myReviewRegDialog = new MyReviewRegDialog(context, MyReviewFragment.this  );
                myReviewRegDialog.openMyReviewReg();
            }
        });
        return view;

    }
    public void refresh() {
        Log.e("테스트", "refresh");
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(this).attach(this).commit();
    }

}
