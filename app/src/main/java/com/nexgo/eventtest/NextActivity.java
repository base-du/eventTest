package com.nexgo.eventtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.greenrobot.event.EventBus;

public class NextActivity extends AppCompatActivity {
    private Package myPack;
    private Logger log;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    }

    @Override
    protected void onStop() {
        log.debug("onStop");
//        EventBus.getDefault().unregister(myPack);
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
//        EventBus.getDefault().register(myPack);
        log.debug("onStart");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_next, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void OnPackageInOne(View view) {
        myPack = new Package("ping!");
        EventBus.getDefault().register(myPack);
        EventBus.getDefault().post(myPack);
    }
}
