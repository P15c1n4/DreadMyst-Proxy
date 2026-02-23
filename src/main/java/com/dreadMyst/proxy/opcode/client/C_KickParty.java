package com.dreadMyst.proxy.opcode.client;

import com.dreadMyst.proxy.enums.OpcodeEnum;
import com.dreadMyst.proxy.opcode.Opcode;

public class C_KickParty extends Opcode {
    private byte leaveParty;
    private final int LEAVE_PARTY_INDEX = 6;

    private int targetId;
    private final int TARGET_ID_INDEX = 7;

    private int unk1;
    private final int UNK1_INDEX = 11;

    public C_KickParty(byte leaveParty, int targetId, int unk1) {
        super(OpcodeEnum.C_KICK_PARTY);
        this.leaveParty = leaveParty;
        this.targetId = targetId;
        this.unk1 = unk1;

        //[(leaveParty) 00 - Kick Player]
        //[(leaveParty) 01 - User Leave Party]
        //[(unk1) maybe 0 ?]

        getOpcodeBuffer().put(leaveParty);
        getOpcodeBuffer().putInt(targetId);
        getOpcodeBuffer().putInt(unk1);
        getOpcodeBuffer().flip();
    }

    public byte getLeaveParty() {
        return leaveParty;
    }

    public void setLeaveParty(byte leaveParty) {
        this.leaveParty = leaveParty;
        getOpcodeBuffer().put(LEAVE_PARTY_INDEX, leaveParty);
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
        getOpcodeBuffer().putInt(TARGET_ID_INDEX, targetId);
    }

    public int getUnk1() {
        return unk1;
    }

    public void setUnk1(int unk1) {
        this.unk1 = unk1;
        getOpcodeBuffer().putInt(UNK1_INDEX, unk1);
    }
}
