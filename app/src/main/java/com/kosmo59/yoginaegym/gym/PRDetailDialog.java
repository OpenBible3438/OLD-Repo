package com.kosmo59.yoginaegym.gym;

import android.app.Dialog;
import android.view.View;
import android.widget.Button;

public class PRDetailDialog extends Dialog {
    public PRDetailDialog(PRImageFragment prImageFragment, View.OnClickListener positiveListener, View.OnClickListener negativeListener) {
    }
    private Button mPositiveButton;
    private Button mNegativeButton;

    private View.OnClickListener mPositiveListener;
    private View.OnClickListener mNegativeListener;


    public void show() {
    }
}
