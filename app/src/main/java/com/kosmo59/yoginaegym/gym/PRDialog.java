package com.kosmo59.yoginaegym.gym;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;

public class PRDialog {

    private Context context;

    public PRDialog(Context context) {
        this.context = context;
    }

    // 호출할 다이얼로그 함수를 정의한다.
    public void callFunction(final TextView main_label) {
        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        final Dialog dlg = new Dialog(context);

        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.fragmant_p_r);

        dlg.setStyle( PRDialog.STYLE_NO_TITLE, android.R.style.Theme_NoTitleBar_Fullscreen );

        // 커스텀 다이얼로그를 노출한다.
        dlg.show();


/*
        var dialog = TestDialogFragment.newInstance()
        dialog.setStyle( DialogFragment.STYLE_NO_TITLE, android.R.style.Theme_NoTitleBar_Fullscreen );
        dialog.show(supportFragmentManager, "tag")
*/

    }
}
