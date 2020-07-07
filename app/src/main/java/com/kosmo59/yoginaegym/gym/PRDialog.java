package com.kosmo59.yoginaegym.gym;

import com.kosmo59.yoginaegym.R;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.TextView;

public class PRDialog {
    //1이면 눌려있을 때, 0이면 안 눌려있을 때
    private int check_num = 0;
    //이미지 버튼
    private ImageButton ib_prHeart;

    //하트 수
    private TextView tv_prHeartNum;
    private int prHeartNum=0;

    private Context context;

    public PRDialog(Context context) {
        this.context = context;
    }

    // 호출할 다이얼로그 함수를 정의한다.
    public void callFunction() {
        // 커스텀 다이얼로그를 정의하기위해 Dialog클래스를 생성한다.
        final Dialog dlg = new Dialog(context);

        // 액티비티의 타이틀바를 숨긴다.
        dlg.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 커스텀 다이얼로그의 레이아웃을 설정한다.
        dlg.setContentView(R.layout.fragment_p_r);

        //전체화면
        //dlg.setStyle( PRDialog.STYLE_NO_TITLE, android.R.style.Theme_NoTitleBar_Fullscreen );

        // 커스텀 다이얼로그를 노출한다.
        dlg.show();

        tv_prHeartNum = dlg.findViewById(R.id.tv_prHeartNum);
        tv_prHeartNum.setText(Integer.toString(prHeartNum));

        ib_prHeart = dlg.findViewById(R.id.ib_prHeart);
        ib_prHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(check_num == 0){
                    //눌려있지 않은 상태에서 눌렸으면 1로 바꾸어주기 => 눌린상태
                    check_num = 1;
                    ib_prHeart.setSelected(true); //이미지버튼이 선택된 상태니까 true
                    ib_prHeart.setImageResource(R.drawable.cont_heart); //눌렸으니까 색칠되어있는 하트 이미지로 변경
                    prHeartNum += 1;
                    tv_prHeartNum.setText(Integer.toString(prHeartNum));
                }
                else{  //이미지 버튼이 눌려있을 때 (check_num == 1)인 상태
                    check_num = 0; //눌려있을 때 다시 누르면 안 눌린 상태로 돌려야되니까 check_num=0으로
                    ib_prHeart.setSelected(false); //이미지 버튼이 선택 안 되어있으니까 상태 false
                    ib_prHeart.setImageResource(R.drawable.cont_heart_empty); //다시 눌리지 않은 상태니까 이미지를 빈 하트 이미지로 변경
                    prHeartNum -= 1;
                    tv_prHeartNum.setText(Integer.toString(prHeartNum));
                }
            }
        });


    }

}
