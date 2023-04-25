package cn.wch.privacynotice;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Gravity;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;

public class PrivacyBlurDialog extends Dialog {

    private TextView notice_title,notice_message;
    private String title,message;

    public PrivacyBlurDialog(@NonNull Context context, String t, String m) {
        super(context);
        this.title = t;
        this.message = m;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.privacy_notice_layout);

        notice_title = findViewById(R.id.notice_title);
        notice_message = findViewById(R.id.notice_message);

        setView();
        notice_title.setText(title);
        notice_message.setText(message);
    }

    private void setView(){
        Window window = getWindow();
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));  //背景透明  透明才能设置圆角
        WindowManager windowManager = window.getWindowManager();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.alpha = 0.99f;   //透明度  1为不透明
        layoutParams.width = (int) (displayMetrics.widthPixels * 0.95); // 宽度设置为屏幕的0.95
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        layoutParams.gravity = Gravity.TOP;//设置位置
        layoutParams.y = 15;  //顶部偏移15
        window.setAttributes(layoutParams);
        window.setDimAmount(0.75f);
        //this is git test
    }
}
