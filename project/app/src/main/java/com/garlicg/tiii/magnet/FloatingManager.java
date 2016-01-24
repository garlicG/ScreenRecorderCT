package com.garlicg.tiii.magnet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.WindowManager;

import com.garlicg.tiii.R;

/**
 */
public class FloatingManager {

    private final Context mContext;
    private final WindowManager mWindowManager;
    private MagnetWindow mMagnetView;
    private DecorDummy mDecorDummy;


    public FloatingManager(Context context) {
        mContext = context;
        mWindowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
    }


    @SuppressLint("InflateParams")
    public void onCreate() {
        final LayoutInflater inflater = LayoutInflater.from(mContext);

        mDecorDummy = new DecorDummy(mContext);
        mWindowManager.addView(mDecorDummy, DecorDummy.createWindowParams());

        mMagnetView = (MagnetWindow) inflater.inflate(R.layout.widget_magnet_window, null, false);
        mWindowManager.addView(mMagnetView, MagnetWindow.createWindowParams());
        mMagnetView.setDecorDummy(mDecorDummy);
    }


    public void onDestroy() {
        mWindowManager.removeView(mMagnetView);
        mMagnetView = null;

        mWindowManager.removeView(mDecorDummy);
        mDecorDummy = null;
    }


}
