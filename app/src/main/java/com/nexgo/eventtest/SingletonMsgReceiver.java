package com.nexgo.eventtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.greenrobot.event.EventBus;

/**
 * @author 新国都技术股份有限公司 duxd
 * @since 1.0.0
 */
public class SingletonMsgReceiver {
    private static SingletonMsgReceiver ourInstance = new SingletonMsgReceiver();
    private Logger log;

    private SingletonMsgReceiver() {
        log = LoggerFactory.getLogger(this.getClass().getSimpleName());
        // HERE cannot work
//        log.debug(this.getClass().getSimpleName());
//        EventBus.getDefault().register(this);
    }

    public static SingletonMsgReceiver getInstance() {
        return ourInstance;
    }

    public void onEvent(MsgRequestSingleton event) {
        log.debug("onEvent Got MsgRequest: {}.", event.getData());
    }

    public void onEventMainThread(MsgRequestSingleton event) {
        log.debug("onEventMainThread Got MsgRequest: {}.", event.getData());
    }

    public void onEventBackgroundThread(MsgRequestSingleton event) {
        log.debug("onEventBackgroundThread Got MsgRequest: {}.", event.getData());
    }

    public void onEventAsync(MsgRequestSingleton event) {
        log.debug("onEventAsync Got MsgRequest: {}.", event.getData());
    }

}
