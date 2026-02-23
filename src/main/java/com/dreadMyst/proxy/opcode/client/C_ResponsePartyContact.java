package com.dreadMyst.proxy.opcode.client;

import com.dreadMyst.proxy.enums.OpcodeEnum;
import com.dreadMyst.proxy.opcode.Opcode;

public class C_ResponsePartyContact extends Opcode {
    private byte accept;
    private final int ACCEPT_INDEX = 6;


    public C_ResponsePartyContact(byte accept) {
        super(OpcodeEnum.C_RESPONSE_PARTY_CONTACT);
        this.accept = accept;

        //[(accept) 00 - Refuse]
        //[(accept) 01 - Accept]

        getOpcodeBuffer().put(accept);
        getOpcodeBuffer().flip();
    }

    public byte getAccept() {
        return accept;
    }

    public void setAccept(byte accept) {
        this.accept = accept;
        getOpcodeBuffer().put(ACCEPT_INDEX, accept);
    }
}
