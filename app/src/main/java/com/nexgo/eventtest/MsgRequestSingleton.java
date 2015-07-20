package com.nexgo.eventtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @author 新国都技术股份有限公司 duxd
 * @since 1.0.0
 */
public class MsgRequestSingleton {
    private String data;

    public MsgRequestSingleton(final String data) {
        this.data = data;
        Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
        log.debug("New Msg: {}.", data);
    }

    public String getData() {
        return data;
    }
}
