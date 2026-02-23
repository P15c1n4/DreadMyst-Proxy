package com.dreadMyst.proxy.opcode.client;

import com.dreadMyst.proxy.enums.OpcodeEnum;
import com.dreadMyst.proxy.opcode.Opcode;

public class C_SelectTarget extends Opcode {
    private int playerId;
    private final int PLAYER_ID_INDEX = 6;

    public C_SelectTarget(int playerId) {
        super( OpcodeEnum.C_SELECT_TARGET);
        this.playerId = playerId;

        getOpcodeBuffer().putInt(playerId);
        getOpcodeBuffer().flip();
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
        getOpcodeBuffer().putInt(PLAYER_ID_INDEX , playerId);
    }
}
