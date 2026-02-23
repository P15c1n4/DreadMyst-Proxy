package com.dreadMyst.proxy.opcode.client;

import com.dreadMyst.proxy.enums.OpcodeEnum;
import com.dreadMyst.proxy.opcode.Opcode;

public class C_PutItemBank extends Opcode {
    private int itemPos;
    private final int ITEM_POS_INDEX = 6;

    private int itemDstPos;
    private final int ITEM_DST_POS_INDEX = 10;

    private byte autoShort;
    private final int AUTO_SHORT_INDEX = 14;

    private int bankTabDst;
    private final int BANK_TAB_DST_INDEX = 15;

    public C_PutItemBank(int itemPos, int itemDstPos, byte autoShort, int bankTabDst) {
        super(OpcodeEnum.C_PUT_ITEM_BANK);
        this.itemPos = itemPos;
        this.itemDstPos = itemDstPos;
        this.autoShort = autoShort;
        this.bankTabDst = bankTabDst;

        getOpcodeBuffer().putInt(itemPos);
        getOpcodeBuffer().putInt(itemDstPos);
        getOpcodeBuffer().put(autoShort);
        getOpcodeBuffer().putInt(bankTabDst);
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

    public byte getAutoShort() {
        return autoShort;
    }

    public void setAutoShort(byte autoShort) {
        this.autoShort = autoShort;
        getOpcodeBuffer().put(AUTO_SHORT_INDEX, autoShort);
    }

    public int getBankTabDst() {
        return bankTabDst;
    }

    public void setBankTabDst(int bankTabDst) {
        this.bankTabDst = bankTabDst;
        getOpcodeBuffer().putInt(BANK_TAB_DST_INDEX, bankTabDst);
    }
}
