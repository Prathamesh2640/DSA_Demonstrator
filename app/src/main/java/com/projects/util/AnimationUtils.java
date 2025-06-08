package com.projects.util;

import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.Button;
import androidx.core.view.ViewCompat;

public class AnimationUtils {
    public static void applyFadeAnimation(View view) {
        AlphaAnimation fade = new AlphaAnimation(0.0f, 1.0f);
        fade.setDuration(500);
        view.startAnimation(fade);
        ViewCompat.animate(view).alpha(1f).setDuration(500).start();
    }

    public static void applyButtonAnimation(Button button) {
        button.setOnTouchListener((v, event) -> {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    v.setScaleX(0.95f);
                    v.setScaleY(0.95f);

                    break;
                case MotionEvent.ACTION_UP:
                case MotionEvent.ACTION_CANCEL:
                    v.setScaleX(1.0f);
                    v.setScaleY(1.0f);
                    break;
            }
            return false;
        });
    }
}