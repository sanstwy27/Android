package com.sanstwy777.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = "MyBroadcastReceiver";
    // action 1
    private static final String action1 = "com.sanstwy777";
    // action 2
    private static final String action2 = "sanstwy777";

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        Toast.makeText(context, "Intent Detected.", Toast.LENGTH_LONG).show();

        if (intent.getAction().equals(action1)) {
            Toast.makeText(context, "MyReceiver recv broadcast message from [com.sanstwy777]", Toast.LENGTH_SHORT).show();
        } else if (intent.getAction().equals(action2)) {
            Toast.makeText(context, "MyReceiver recv broadcast message from [sanstwy777]", Toast.LENGTH_SHORT).show();
        }
    }
}