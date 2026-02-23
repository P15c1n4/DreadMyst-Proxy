package com.dreadMyst.proxy.opcode.client;

import com.dreadMyst.proxy.enums.OpcodeEnum;
import com.dreadMyst.proxy.opcode.Opcode;

public class C_TakeLoot extends Opcode {
    private short targetId;
    private final int TARGET_ID_INDEX = 6;

    private short unk1;
    private final int UNK1_INDEX = 8;

    private short itemId;
    private final int ITEM_ID_INDEX = 10;

    private short unk2;
    private final int UNK2_INDEX = 12;

    private byte tier;
    private final int TIER_INDEX = 14;

    private byte rarity;
    private final int RARITY_INDEX = 15;

    public C_TakeLoot(short targetId, short unk1, short itemId, short unk2, byte tier, byte rarity) {
        super(OpcodeEnum.C_TAKE_LOOT);
        this.targetId = targetId;
        this.unk1 = unk1;
        this.itemId = itemId;
        this.unk2 = unk2;
        this.tier = tier;
        this.rarity = rarity;

        //[(unk1) maybe FFFF ?]
        //[(unk2) maybe Item enchant rolls ??]

        getOpcodeBuffer().putShort(targetId);
        getOpcodeBuffer().putShort(unk1);
        getOpcodeBuffer().putShort(itemId);
        getOpcodeBuffer().putShort(unk2);
        getOpcodeBuffer().putShort(tier);
        getOpcodeBuffer().put(rarity);
        getOpcodeBuffer().flip();
    }


    public short getTargetId() {
        return targetId;
    }

    public void setTargetId(short targetId) {
        this.targetId = targetId;
        getOpcodeBuffer().putShort(TARGET_ID_INDEX, targetId);
    }

    public short getUnk1() {
        return unk1;
    }

    public void setUnk1(short unk1) {
        this.unk1 = unk1;
        getOpcodeBuffer().putShort(UNK1_INDEX, unk1);
    }

    public short getItemId() {
        return itemId;
    }

    public void setItemId(short itemId) {
        this.itemId = itemId;
        getOpcodeBuffer().putShort(ITEM_ID_INDEX, itemId);
    }

    public short getUnk2() {
        return unk2;
    }

    public void setUnk2(short unk2) {
        this.unk2 = unk2;
        getOpcodeBuffer().putShort(UNK2_INDEX, unk2);
    }

    public byte getTier() {
        return tier;
    }

    public void setTier(byte tier) {
        this.tier = tier;
        getOpcodeBuffer().put(TIER_INDEX, tier);
    }

    public byte getRarity() {
        return rarity;
    }

    public void setRarity(byte rarity) {
        this.rarity = rarity;
        getOpcodeBuffer().put(RARITY_INDEX, rarity);
    }
}
