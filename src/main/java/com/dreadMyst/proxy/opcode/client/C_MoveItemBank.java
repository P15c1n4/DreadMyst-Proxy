package com.dreadMyst.proxy.opcode.client;

import com.dreadMyst.proxy.enums.OpcodeEnum;
import com.dreadMyst.proxy.opcode.Opcode;

public class C_MoveItemBank extends Opcode {
    private int itemPos;
    private final int ITEM_POS_INDEX = 6;

    private int itemDstPos;
    private final int ITEM_DST_POS_INDEX = 10;


    public C_MoveItemBank(int itemPos, int itemDstPos) {
        super(OpcodeEnum.C_MOVE_ITEM_BANK);
        this.itemPos = itemPos;
        this.itemDstPos = itemDstPos;

        getOpcodeBuffer().putInt(itemPos);
        getOpcodeBuffer().putInt(itemDstPos);
        getOpcodeBuffer().flip();
    }

    public int getItemPos() {
        return itemPos;
    }

    public void setItemPos(int itemPos) {
        this.itemPos = itemPos;
        getOpcodeBuffer().putInt(ITEM_POS_INDEX, itemPos);
    }

    public int getItemDstPos() {
        return itemDstPos;
    }

    public void setItemDstPos(int itemDstPos) {
        this.itemDstPos = itemDstPos;
        getOpcodeBuffer().putInt(ITEM_DST_POS_INDEX, itemDstPos);
    }
}
