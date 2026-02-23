package com.dreadMyst.proxy.opcode.client;

import com.dreadMyst.proxy.enums.OpcodeEnum;
import com.dreadMyst.proxy.opcode.Opcode;

import java.nio.charset.StandardCharsets;

public class C_Chat extends Opcode {
    private byte channelId;
    private final int CHANNEL_ID_INDEX = 6;

    private String messageText;
    private int stringLength;
    private final int MESSAGE_TEXT_INDEX = 7;

    private byte unk1;
    private int UNK1_INDEX;

    private short item_Id;
    private int ITEM_ID_INDEX;

    private short unk2;
    private int UNK2_INDEX;

    private byte tier;
    private int TIER_INDEX;

    private byte gem1;
    private int GEM1_INDEX;

    private byte gem2;
    private int GEM2_INDEX;

    private byte gem3;
    private int GEM3_INDEX;

    private byte gem4;
    private int GEM4_INDEX;

    private short unk3;
    private int UNK3_INDEX;

    private byte rarity;
    private int RARITY_INDEX;


    public C_Chat(byte channelId, String messageText, byte unk1, short item_Id, short unk2, byte tier, byte gem1, byte gem2, byte gem3, byte gem4, short unk3, byte rarity) {
        super(OpcodeEnum.C_CHAT);
        byte[] stringBytes = messageText.getBytes(StandardCharsets.US_ASCII);

        this.channelId = channelId;
        this.messageText = messageText;
        this.stringLength =  stringBytes.length;
        this.unk1 = unk1;
        this.item_Id = item_Id;
        this.unk2 = unk2;
        this.tier = tier;
        this.gem1 = gem1;
        this.gem2 = gem2;
        this.gem3 = gem3;
        this.gem4 = gem4;
        this.unk3 = unk3;
        this.rarity = rarity;

        byte startBufferIndex = 7;
        int textLength = (stringBytes.length + 1) + startBufferIndex;

        getOpcodeBuffer().put(channelId);

        getOpcodeBuffer().put(stringBytes);
        getOpcodeBuffer().put((byte) 0);

        getOpcodeBuffer().putShort(unk1);
        this.UNK1_INDEX = textLength;

        getOpcodeBuffer().putShort(item_Id);
        this.ITEM_ID_INDEX =  textLength + 2;

        getOpcodeBuffer().putShort(unk2);
        this.UNK2_INDEX = textLength + 4;

        getOpcodeBuffer().put(tier);
        this.TIER_INDEX = textLength + 6;

        getOpcodeBuffer().put(gem1);
        this.GEM1_INDEX = textLength + 7;

        getOpcodeBuffer().put(gem2);
        this.GEM2_INDEX = textLength + 8;

        getOpcodeBuffer().put(gem3);
        this.GEM3_INDEX = textLength + 9;

        getOpcodeBuffer().put(gem4);
        this.GEM4_INDEX = textLength + 10;

        getOpcodeBuffer().putShort(unk3);
        this.UNK3_INDEX = textLength + 11;

        getOpcodeBuffer().put(rarity);
        this.RARITY_INDEX = textLength + 13;

        getOpcodeBuffer().flip();
    }


    public byte getChannelId() {
        return channelId;
    }

    public void setChannelId(byte channelId) {
        this.channelId = channelId;
        getOpcodeBuffer().put(CHANNEL_ID_INDEX, channelId);
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        changeString(MESSAGE_TEXT_INDEX, messageText);
        this.messageText = messageText;
        this.stringLength = messageText.getBytes(StandardCharsets.US_ASCII).length;
        recalcFieldsIndex();
    }

    public byte getUnk1() {
        return unk1;
    }

    public void setUnk1(byte unk1) {
        this.unk1 = unk1;
        getOpcodeBuffer().putShort(UNK1_INDEX, unk1);
    }

    public short getItem_Id() {
        return item_Id;
    }

    public void setItem_Id(short item_Id) {
        this.item_Id = item_Id;
        getOpcodeBuffer().putShort(ITEM_ID_INDEX, item_Id);
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

    public byte getGem1() {
        return gem1;
    }

    public void setGem1(byte gem1) {
        this.gem1 = gem1;
        getOpcodeBuffer().put(GEM1_INDEX, gem1);
    }

    public byte getGem2() {
        return gem2;
    }

    public void setGem2(byte gem2) {
        this.gem2 = gem2;
        getOpcodeBuffer().put(GEM2_INDEX, gem2);
    }

    public byte getGem3() {
        return gem3;
    }

    public void setGem3(byte gem3) {
        this.gem3 = gem3;
        getOpcodeBuffer().put(GEM3_INDEX, gem3);
    }

    public byte getGem4() {
        return gem4;
    }

    public void setGem4(byte gem4) {
        this.gem4 = gem4;
        getOpcodeBuffer().put(GEM4_INDEX, gem4);
    }

    public short getUnk3() {
        return unk3;
    }

    public void setUnk3(short unk3) {
        this.unk3 = unk3;
        getOpcodeBuffer().putShort(UNK3_INDEX, unk3);
    }

    public byte getRarity() {
        return rarity;
    }

    public void setRarity(byte rarity) {
        this.rarity = rarity;
        getOpcodeBuffer().putShort(RARITY_INDEX, rarity);
    }

    private void recalcFieldsIndex() {
        byte startBufferIndex = 7;
        int bufferStringPosEnd = (stringLength + 1) + startBufferIndex;

        this.UNK1_INDEX = bufferStringPosEnd;
        this.ITEM_ID_INDEX =  bufferStringPosEnd + 2;
        this.UNK2_INDEX = bufferStringPosEnd + 4;
        this.TIER_INDEX = bufferStringPosEnd + 6;
        this.GEM1_INDEX = bufferStringPosEnd + 7;
        this.GEM2_INDEX = bufferStringPosEnd + 8;
        this.GEM3_INDEX = bufferStringPosEnd + 9;
        this.GEM4_INDEX = bufferStringPosEnd + 10;
        this.UNK3_INDEX = bufferStringPosEnd + 11;
        this.RARITY_INDEX = bufferStringPosEnd + 13;
    }
}
