package com.dreadMyst.proxy.enums;

public enum OpcodeEnum {

    C_SELECT_NPC_OPTION((short) 73, 4),
    C_SHORT_INVENTORY((short) 71, 0),
    C_MOVE_ITEM_BANK((short) 70, 8),
    C_REQUEST_SKILL_UPDATE((short) 68, 4),
    C_REQUEST_REPAIR_ITEMS((short) 67, 1),
    C_SET_GUILD_DAILY_MESSAGE((short) 66, 0),
    C_RESET_USER_DUNGEONS((short) 65, 0),
    C_RESPONSE_PARTY_CONTACT((short) 64, 1),
    C_PUT_ITEM_BANK((short) 62, 13),
    C_CHAT((short) 60, 9),
    C_CONFIRM_SPEND_EXP((short) 59, 4),
    C_GET_ITEM_BANK((short) 58, 9),
    C_REQUEST_GUILD_WINDOW((short) 55, 0),
    C_USER_MOVE((short) 51, 9),
    C_SEND_TRADE((short) 49, 0 ),
    C_SELECT_TARGET((short) 48, 4),
    C_CLOSE_CONTACT((short) 45, 0),
    C_USE_ITEM((short) 43, 13),
    C_SEND_PARTY((short) 38, 0 ),
    C_USE_SKILL((short) 32, 16),
    C_TAKE_LOOT((short)27, 10),
    C_RESPONSE_DUEL_CONTACT((short) 17, 1),
    C_KICK_PARTY((short) 16, 9),
    C_SELL_ITEM((short) 11, 3),
    C_MOVE_ITEM_INVENTORY((short) 6, 2),
    C_REQUEST_SPEND_EXP_WINDOW((short) 5, 0);

    private short opcodeId;
    private int opcodePayloadSize;


    OpcodeEnum(short opcodeId, int opcodePayloadSize) {
        this.opcodeId = opcodeId;
        this.opcodePayloadSize = opcodePayloadSize;
    }

    public short getOpcodeId() {
        return opcodeId;
    }
    public int getOpcodePayloadSize() {
        return opcodePayloadSize;
    }

}
