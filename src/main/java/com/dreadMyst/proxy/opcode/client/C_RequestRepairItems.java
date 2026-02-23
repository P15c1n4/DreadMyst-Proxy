package com.dreadMyst.proxy.opcode.client;

import com.dreadMyst.proxy.enums.OpcodeEnum;
import com.dreadMyst.proxy.opcode.Opcode;

public class C_RequestRepairItems extends Opcode {
    private byte repair;
    private final int  REPAIR_INDEX = 6;

    public C_RequestRepairItems(byte repair) {
        super(OpcodeEnum.C_REQUEST_REPAIR_ITEMS);
        this.repair = repair;

        //[(repair) 00 - Just Request Repair (maybe check?)]
        //[(repair) 01 - Repair]

        getOpcodeBuffer().put(repair);
        getOpcodeBuffer().flip();
    }

    public byte getRepair() {
        return repair;
    }

    public void setRepair(byte repair) {
        this.repair = repair;
        getOpcodeBuffer().put(REPAIR_INDEX, repair);
    }
}
