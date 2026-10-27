package io.freemytv;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public final class AdzanOverlay {
    private static final String TAG = "AdzanOverlay";
    private static WindowManager windowManager;
    private static View overlayView;
    private static final Handler handler = new Handler(Looper.getMainLooper());
    private static final Runnable autoDismissRunnable = new Runnable() {
        @Override
        public void run() {
            dismiss();
        }
    };

    private AdzanOverlay() {}

    public static void show(Context context, String prayerName, String city) {
        handler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(context)) {
                        Log.w(TAG, "Cannot show overlay: SYSTEM_ALERT_WINDOW not granted");
                        return;
                    }
                    dismiss();

                    windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
                    if (windowManager == null) return;

                    float density = context.getResources().getDisplayMetrics().density;
                    int padH = Math.round(28 * density);
                    int padV = Math.round(18 * density);
                    int radius = Math.round(20 * density);

                    // Root card container
                    LinearLayout root = new LinearLayout(context);
                    root.setOrientation(LinearLayout.HORIZONTAL);
                    root.setGravity(Gravity.CENTER_VERTICAL);
                    root.setPadding(padH, padV, padH, padV);

                    GradientDrawable bg = new GradientDrawable();
                    bg.setColor(0xEE12151B); // Dark frosted glass aesthetic
                    bg.setCornerRadius(radius);
                    bg.setStroke(Math.max(1, Math.round(1.5f * density)), 0x33FFFFFF);
                    root.setBackground(bg);
                    if (Build.VERSION.SDK_INT >= 21) {
                        root.setElevation(16 * density);
                    }

                    // App / mosque icon
                    ImageView icon = new ImageView(context);
                    icon.setImageResource(R.drawable.icon);
                    int iconSize = Math.round(44 * density);
                    LinearLayout.LayoutParams iconLp = new LinearLayout.LayoutParams(iconSize, iconSize);
                    iconLp.rightMargin = Math.round(20 * density);
                    root.addView(icon, iconLp);

                    // Texts column
                    LinearLayout textCol = new LinearLayout(context);
                    textCol.setOrientation(LinearLayout.VERTICAL);

                    TextView title = new TextView(context);
                    title.setText("WAKTU ADZAN " + prayerName.toUpperCase() + " TELAH TIBA");
                    title.setTextColor(Color.WHITE);
                    title.setTextSize(TypedValue.COMPLEX_UNIT_SP, 17);
                    title.setTypeface(Typeface.DEFAULT_BOLD);
                    textCol.addView(title);

                    TextView sub = new TextView(context);
                    sub.setText("Wilayah " + city + " dan sekitarnya");
                    sub.setTextColor(0xB3FFFFFF);
                    sub.setTextSize(TypedValue.COMPLEX_UNIT_SP, 13);
                    textCol.addView(sub);

                    root.addView(textCol);

                    int windowType = Build.VERSION.SDK_INT >= 26
                        ? WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
                        : WindowManager.LayoutParams.TYPE_SYSTEM_ALERT;

                    WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                        WindowManager.LayoutParams.WRAP_CONTENT,
                        WindowManager.LayoutParams.WRAP_CONTENT,
                        windowType,
                        WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                            | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                            | WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN
                            | WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON,
                        PixelFormat.TRANSLUCENT
                    );
                    params.gravity = Gravity.TOP | Gravity.CENTER_HORIZONTAL;
                    params.y = Math.round(36 * density);

                    windowManager.addView(root, params);
                    overlayView = root;
                    Log.i(TAG, "Adzan overlay displayed successfully");

                    handler.removeCallbacks(autoDismissRunnable);
                    handler.postDelayed(autoDismissRunnable, 45_000L);
                } catch (Exception e) {
                    Log.e(TAG, "Failed to show overlay", e);
                }
            }
        });
    }

    public static void dismiss() {
        handler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    handler.removeCallbacks(autoDismissRunnable);
                    if (windowManager != null && overlayView != null) {
                        windowManager.removeView(overlayView);
                        overlayView = null;
                        Log.i(TAG, "Adzan overlay dismissed");
                    }
                } catch (Exception e) {
                    Log.e(TAG, "Failed to dismiss overlay", e);
                }
            }
        });
    }
}
