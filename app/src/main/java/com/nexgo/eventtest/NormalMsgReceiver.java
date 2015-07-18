package com.nexgo.eventtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 新国都技术股份有限公司 duxd
 * @since 1.0.0
 */
public class NormalMsgReceiver {
    private Logger log;

    public NormalMsgReceiver() {
        log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    }

    public void onEvent(MsgRequestNormal event) {
        log.debug("onEvent Got MsgRequest: {}.", event.getData());
    }

    public void onEventMainThread(MsgRequestNormal event) {
        log.debug("onEventMainThread Got MsgRequest: {}.", event.getData());
    }

    public void onEventBackgroundThread(MsgRequestNormal event) {
        log.debug("onEventBackgroundThread Got MsgRequest: {}.", event.getData());
    }

    public void onEventAsync(MsgRequestNormal event) {
        log.debug("onEventAsync Got MsgRequest: {}.", event.getData());
    }

}
