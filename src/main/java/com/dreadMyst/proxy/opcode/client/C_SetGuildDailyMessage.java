package com.dreadMyst.proxy.opcode.client;

import com.dreadMyst.proxy.enums.OpcodeEnum;
import com.dreadMyst.proxy.opcode.Opcode;

import java.nio.charset.StandardCharsets;

public class C_SetGuildDailyMessage extends Opcode {
    private String message;
    private final int MESSAGE_INDEX = 6;

    public C_SetGuildDailyMessage(String message) {
        super(OpcodeEnum.C_SET_GUILD_DAILY_MESSAGE);
        this.message = message;

        getOpcodeBuffer().put(message.getBytes(StandardCharsets.US_ASCII));
        getOpcodeBuffer().put((byte) 0);
        getOpcodeBuffer().flip();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        changeString(MESSAGE_INDEX, message);
        this.message = message;
    }
}
