package com.dreadMyst.proxy.opcode.client;

import com.dreadMyst.proxy.enums.OpcodeEnum;
import com.dreadMyst.proxy.opcode.Opcode;

public class C_MoveItemInventory extends Opcode {
    private byte originalPos;
    private final int ORIGINAL_POS_INDEX = 6;

    private byte destinationPos;
    private final int DESTINATION_POS_INDEX = 7;


    public C_MoveItemInventory(byte originalPos, byte destinationPos) {
        super(OpcodeEnum.C_MOVE_ITEM_INVENTORY);
        this.originalPos = originalPos;
        this.destinationPos = destinationPos;

        //[(originalPos/destinationPos) - START -> 00; END -> 30] - (inventory)

        getOpcodeBuffer().put(originalPos);
        getOpcodeBuffer().put(destinationPos);
        getOpcodeBuffer().flip();
    }

    public byte getOriginalPos() {
        return originalPos;
    }

    public void setOriginalPos(byte originalPos) {
        this.originalPos = originalPos;
        getOpcodeBuffer().put(ORIGINAL_POS_INDEX, originalPos);
    }

    public byte getDestinationPos() {
        return destinationPos;
    }

    public void setDestinationPos(byte destinationPos) {
        this.destinationPos = destinationPos;
        getOpcodeBuffer().put(DESTINATION_POS_INDEX, destinationPos);
    }
}
