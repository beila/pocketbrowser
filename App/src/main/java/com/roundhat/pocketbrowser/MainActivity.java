package com.roundhat.pocketbrowser;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;

import java.util.List;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        final Uri data = getIntent().getData();
        if (null == data) {finish(); return;}
        String uriString = data.toString();

        final Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.ideashower.readitlater.pro",
                "com.ideashower.readitlater.activity.ReaderActivity"));
        intent.putExtra("com.pocket.reader.extra.internal.startSource", uriString);
        intent.putExtra("com.pocket.reader.extra.internal.itemUrl", uriString);
        intent.putExtra("com.pocket.reader.external.extra.url", uriString);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        if (isPocketAvailable(intent)) startActivity(intent);
        else finish();
    }

    private boolean isPocketAvailable(Intent intent) {
        PackageManager packageManager = getPackageManager();
        if (packageManager == null) return false;

        List<ResolveInfo>  activities = packageManager.queryIntentActivities(intent, 0);
        boolean isIntentSafe = activities.size() > 0;

        if (!isIntentSafe) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id="+"com.ideashower.readitlater.pro"))
                    .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            );
        }
        return isIntentSafe;
    }

}
