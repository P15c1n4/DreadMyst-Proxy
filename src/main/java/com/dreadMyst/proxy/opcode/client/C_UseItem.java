package com.dreadMyst.proxy.opcode.client;

import com.dreadMyst.proxy.enums.OpcodeEnum;
import com.dreadMyst.proxy.opcode.Opcode;

public class C_UseItem extends Opcode {

    private byte itemPos;
    private final int ITEM_POS_INDEX = 6;

    private short itemId;
    private final int ITEM_ID_INDEX = 7;

    private byte inventoryDstPos;
    private final int INVENTORY_DST_POS_INDEX = 9;

    private byte paperDollDstPos;
    private final int PAPER_DOLL_DST_POS_INDEX = 10;

    private long clickPosition;
    private final int CLICK_POSITION_INDEX = 11;


    public C_UseItem(byte itemPos, short itemId, byte inventoryDstPos, byte paperDollDstPos, long clickPosition) {
        super(OpcodeEnum.C_USE_ITEM);
        this.itemPos = itemPos;
        this.itemId = itemId;
        this.inventoryDstPos = inventoryDstPos;
        this.paperDollDstPos = paperDollDstPos;
        this.clickPosition = clickPosition;

        // [(inventoryDstPos) FF - No inventory pos]
        // [(paperDollDstPos) FF - No paper doll poss]
        // [(clickPosition) 0000000000000000 - No map Pos]

        getOpcodeBuffer().put(itemPos);
        getOpcodeBuffer().putShort(itemId);
        getOpcodeBuffer().put(inventoryDstPos);
        getOpcodeBuffer().put(paperDollDstPos);
        getOpcodeBuffer().putLong(clickPosition);
        getOpcodeBuffer().flip();
    }


    public byte getItemPos() {
        return itemPos;
    }

    public void setItemPos(byte itemPos) {
        this.itemPos = itemPos;
        getOpcodeBuffer().put(ITEM_POS_INDEX ,itemPos);
    }

    public short getItemId() {
        return itemId;
    }

    public void setItemId(short itemId) {
        this.itemId = itemId;
        getOpcodeBuffer().putShort(ITEM_ID_INDEX, itemId);
    }

    public byte getInventoryDstPos() {
        return inventoryDstPos;
    }

    public void setInventoryDstPos(byte inventoryDstPos) {
        this.inventoryDstPos = inventoryDstPos;
        getOpcodeBuffer().put(INVENTORY_DST_POS_INDEX, inventoryDstPos);
    }

    public byte getPaperDollDstPos() {
        return paperDollDstPos;
    }

    public void setPaperDollDstPos(byte paperDollDstPos) {
        this.paperDollDstPos = paperDollDstPos;
        getOpcodeBuffer().put(PAPER_DOLL_DST_POS_INDEX, paperDollDstPos);
    }

    public long getClickPosition() {
        return clickPosition;
    }

    public void setClickPosition(long clickPosition) {
        this.clickPosition = clickPosition;
        getOpcodeBuffer().putLong(CLICK_POSITION_INDEX,clickPosition);
    }
}
