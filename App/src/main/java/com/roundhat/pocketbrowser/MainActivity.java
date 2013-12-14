package com.roundhat.pocketbrowser;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by hojin.ghim on 13. 12. 14.
 */
public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.ideashower.readitlater.pro",
                "com.ideashower.readitlater.activity.ReaderActivity"));
//        intent.setData(Uri.parse("http://google.com/calendar"));
        intent.putExtra("com.pocket.reader.extra.internal.startSource", "http://google.com/calendar");
        intent.putExtra("com.pocket.reader.extra.internal.itemUrl", "http://google.com/calendar");
        intent.putExtra("com.pocket.reader.external.extra.url", "http://google.com/calendar");
        startActivity(intent);
    }

}
