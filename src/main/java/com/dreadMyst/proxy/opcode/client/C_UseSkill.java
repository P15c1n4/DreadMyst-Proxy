package com.dreadMyst.proxy.opcode.client;

import com.dreadMyst.proxy.enums.OpcodeEnum;
import com.dreadMyst.proxy.opcode.Opcode;

import java.nio.ByteBuffer;

public class C_UseSkill extends Opcode {
    private int skillId;
    private final short SKILL_ID_INDEX = 6;

    private int targetId;
    private final short TARGET_ID_INDEX = 10;

    private long clickPosition;
    private final short CLICK_POSITION_INDEX = 14;

    public C_UseSkill(int skillId, int targetId, long clickPosition) {
        super(OpcodeEnum.C_USE_SKILL);
        this.clickPosition = clickPosition;

        //[(clickPosition) 0000000000000000 - No Pos]
        //[(skillId) 55000000 - Get Loot Skill]
        //[(skillId) 58000000 - NPC Interact]
        //[(skillId) 80000000 - Send Duel Request]
        //[(skillId) 11010000 - Use Lok Pick]
        //[(skillId) F5000000 - sleep]

        getOpcodeBuffer().putInt(skillId);
        getOpcodeBuffer().putInt(targetId);
        getOpcodeBuffer().putLong(clickPosition);
        getOpcodeBuffer().clear();
    }

    public C_UseSkill(ByteBuffer buffer) {
        super(OpcodeEnum.C_USE_SKILL);

        buffer.clear();
        setOpcodeBuffer(buffer);
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
        getOpcodeBuffer().putInt(SKILL_ID_INDEX, skillId);
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
        getOpcodeBuffer().putInt(TARGET_ID_INDEX, targetId);
    }

    public long getClickPosition() {
        return clickPosition;
    }

    public void setClickPosition(long clickPosition) {
        this.clickPosition = clickPosition;
        getOpcodeBuffer().putLong(CLICK_POSITION_INDEX, clickPosition);
    }
}
