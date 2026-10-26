package io.freemytv;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class AdzanReceiver extends BroadcastReceiver {
    private static final String TAG = "AdzanReceiver";

    @Override public void onReceive(Context context, Intent intent) {
        String prayerName = intent.getStringExtra("prayer_name");
        Log.i(TAG, "AdzanReceiver onReceive: " + prayerName);
        AdzanAlert.triggerAdzan(context.getApplicationContext(), prayerName, true);
    }
}
