package com.dreadMyst.proxy.opcode.client;

import com.dreadMyst.proxy.enums.OpcodeEnum;
import com.dreadMyst.proxy.opcode.Opcode;

public class C_SelectNpcOption extends Opcode {

    private int optionId;
    private final int OPTION_ID_INDEX = 6;


    public C_SelectNpcOption(int optionId) {
        super(OpcodeEnum.C_SELECT_NPC_OPTION);
        this.optionId = optionId;

        getOpcodeBuffer().putInt(optionId);
        getOpcodeBuffer().flip();
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
        getOpcodeBuffer().putInt(OPTION_ID_INDEX, optionId);
    }
}
