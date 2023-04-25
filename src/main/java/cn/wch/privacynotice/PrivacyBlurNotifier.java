package cn.wch.privacynotice;

import android.content.Context;

public class PrivacyBlurNotifier {

    private static Context context;
    private static PrivacyBlurNotifier privacyBlurNotifier;
    private PrivacyBlurDialog privacyBlurDialog;

    public static PrivacyBlurNotifier getInstance(Context c){
        if(privacyBlurNotifier == null){
            synchronized (PrivacyBlurNotifier.class){
                privacyBlurNotifier = new PrivacyBlurNotifier();
            }
        }
        context = c;
        return privacyBlurNotifier;
    }

    public void showPrivacyNotice(String title, String message){
        if (privacyBlurDialog != null){
            if (privacyBlurDialog.isShowing()){
                privacyBlurDialog.dismiss();
            }
            privacyBlurDialog = null;
        }
        privacyBlurDialog = new PrivacyBlurDialog(context,title,message);
        privacyBlurDialog.setCancelable(false);
        privacyBlurDialog.show();
    }

    public void closePrivacyNotice(){
        if (privacyBlurDialog == null){
            return;
        }
        privacyBlurDialog.dismiss();
        privacyBlurDialog = null;
    }
}
