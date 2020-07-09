package com.kosmo59.yoginaegym.gym;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;

import com.kosmo59.yoginaegym.R;

public class ClassDetailDialog {
    private Context context;
    private ImageButton icon_close;

    public ClassDetailDialog(Context context) {
        this.context = context;
    }

    public void openClassDetailDialog() {
        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        final Dialog dlg = new Dialog(context);

        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.dialog_class_detail);

        // 커스텀 다이얼로그를 노출한다.
        dlg.show();

        icon_close = dlg.findViewById(R.id.icon_close);
        icon_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlg.hide();
            }
        });
    }
}
