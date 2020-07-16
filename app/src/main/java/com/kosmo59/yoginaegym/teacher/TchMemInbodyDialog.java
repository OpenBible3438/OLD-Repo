package com.kosmo59.yoginaegym.teacher;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.view.WindowManager;

import com.github.chrisbanes.photoview.PhotoView;
import com.kosmo59.yoginaegym.R;

public class TchMemInbodyDialog {

    private Context context;
    private PhotoView photoView;

    public TchMemInbodyDialog(Context context){
        this.context = context;
    }

    // 호출할 다이얼로그 함수를 정의한다.
    public void callFunction() {
        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        final Dialog dlg = new Dialog(context);

        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.dialog_tch_mem_inbody_detail);

        WindowManager.LayoutParams params = dlg.getWindow().getAttributes();
        params.width = WindowManager.LayoutParams.MATCH_PARENT;
        params.height = WindowManager.LayoutParams.MATCH_PARENT;
        dlg.getWindow().setAttributes((android.view.WindowManager.LayoutParams)params);

        // 커스텀 다이얼로그를 노출한다.
        dlg.show();

        //ImageView 확대 축소 기능
        photoView = dlg.findViewById(R.id.pv_tchMemInbody);
        photoView.setImageResource(R.drawable.inbody_ex1);
    }

}
