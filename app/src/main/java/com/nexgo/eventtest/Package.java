package com.nexgo.eventtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author 新国都技术股份有限公司 duxd
 * @since 1.0.0
 */
public class Package {
    private String data;
    private Logger log;

    public Package(final String data) {
        this.data = data;
        log = LoggerFactory.getLogger(this.getClass().getSimpleName());
        log.debug("New Msg: {}.", data);
    }

    public String getData() {
        return data;
    }

    public void onEvent(Package event) {
        log.debug("onEvent Got MsgRequest: {}.", event.getData());
    }

    public void onEventMainThread(Package event) {
        log.debug("onEventMainThread Got MsgRequest: {}.", event.getData());
    }

    public void onEventBackgroundThread(Package event) {
        log.debug("onEventBackgroundThread Got MsgRequest: {}.", event.getData());
    }

    public void onEventAsync(Package event) {
        log.debug("onEventAsync Got MsgRequest: {}.", event.getData());
    }
}
