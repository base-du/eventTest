package com.nexgo.eventtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.android.BasicLogcatConfigurator;
import de.greenrobot.event.EventBus;

public class MainActivity extends AppCompatActivity {
    static {
        BasicLogcatConfigurator.configureDefaultContext();
    }

    private Logger log;
    private NormalMsgReceiver normalMsgReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        log = LoggerFactory.getLogger(this.getClass().getSimpleName());
        SingletonMsgReceiver.getInstance();
    }

    @Override
    protected void onStop() {
        log.debug("onStop");
        EventBus.getDefault().unregister(this);
        EventBus.getDefault().unregister(normalMsgReceiver);
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
        normalMsgReceiver = new NormalMsgReceiver();
        EventBus.getDefault().register(normalMsgReceiver);
        log.debug("onStart");
    }

    @Override
    protected void onPause() {
        log.debug("onPause");
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        log.debug("onResume");
    }

    public void onEvent(MsgRequest event) {
        log.debug("onEvent Got MsgRequest: {}.", event.getData());
    }

    public void onEventMainThread(MsgRequest event) {
        log.debug("onEventMainThread Got MsgRequest: {}.", event.getData());
    }

    public void onEventBackgroundThread(MsgRequest event) {
        log.debug("onEventBackgroundThread Got MsgRequest: {}.", event.getData());
    }

    public void onEventAsync(MsgRequest event) {
        log.debug("onEventAsync Got MsgRequest: {}.", event.getData());
    }

    //Test in self Activity
    public void OnRequest(View view) {
        EventBus.getDefault().post(new MsgRequest("ping?"));
        EventBus.getDefault().post(new MsgRequest("pang!"));
    }

    public void OnSingleton(View view) {
        EventBus.getDefault().post(new MsgRequestSingleton("ping?"));
        EventBus.getDefault().post(new MsgRequestSingleton("pang?"));
    }

    public void OnNormal(View view) {
        EventBus.getDefault().post(new MsgRequestNormal("ping?"));
        EventBus.getDefault().post(new MsgRequestNormal("pang?"));
    }

    public void OnNextScreen(View view) {
        Intent intent = new Intent(this, NextActivity.class);
        startActivity(intent);
    }
}
