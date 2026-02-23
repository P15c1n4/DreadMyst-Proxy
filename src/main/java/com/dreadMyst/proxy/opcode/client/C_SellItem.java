package com.dreadMyst.proxy.opcode.client;

import com.dreadMyst.proxy.enums.OpcodeEnum;
import com.dreadMyst.proxy.opcode.Opcode;

public class C_SellItem extends Opcode {
    private byte itemSlot;
    private final int ITEM_SLOT_INDEX = 6;

    private short itemId;
    private final int ITEM_ID_INDEX = 7;

    public C_SellItem(byte itemSlot, short itemId) {
        super(OpcodeEnum.C_SELL_ITEM);
        this.itemSlot = itemSlot;
        this.itemId = itemId;

        getOpcodeBuffer().put(itemSlot);
        getOpcodeBuffer().putShort(itemId);
        getOpcodeBuffer().flip();
    }

    public byte getItemSlot() {
        return itemSlot;
    }

    public void setItemSlot(byte itemSlot) {
        this.itemSlot = itemSlot;
        getOpcodeBuffer().put(ITEM_SLOT_INDEX, itemSlot);
    }

    public short getItemId() {
        return itemId;
    }

    public void setItemId(short itemId) {
        this.itemId = itemId;
        getOpcodeBuffer().putShort(ITEM_ID_INDEX, itemId);
    }

}
