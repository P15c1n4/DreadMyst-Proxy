package com.dreadMyst.proxy.opcode.client;

import com.dreadMyst.proxy.enums.OpcodeEnum;
import com.dreadMyst.proxy.opcode.Opcode;

import java.nio.charset.StandardCharsets;

public class C_SendParty extends Opcode {

    private String playerName;
    private final int PLAYER_INDEX = 6;

    public C_SendParty(String playerName) {
        super(OpcodeEnum.C_SEND_PARTY);
        this.playerName = playerName;

        getOpcodeBuffer().put(playerName.getBytes(StandardCharsets.US_ASCII));
        getOpcodeBuffer().put((byte) 0);
        getOpcodeBuffer().flip();
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
        changeString(PLAYER_INDEX, playerName);
    }
}
