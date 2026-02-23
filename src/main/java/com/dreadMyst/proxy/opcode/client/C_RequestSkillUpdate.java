package com.dreadMyst.proxy.opcode.client;

import com.dreadMyst.proxy.enums.OpcodeEnum;
import com.dreadMyst.proxy.opcode.Opcode;

public class C_RequestSkillUpdate extends Opcode {
    private short skillId;
    private final int SKILL_ID_INDEX = 6;

    private short level;
    private final int LEVEL_INDEX = 8;

    public C_RequestSkillUpdate(short skillId, short level) {
        super(OpcodeEnum.C_REQUEST_SKILL_UPDATE);
        this.skillId = skillId;
        this.level = level;

        getOpcodeBuffer().putShort(skillId);
        getOpcodeBuffer().putShort(level);
        getOpcodeBuffer().flip();
    }

    public short getSkillId() {
        return skillId;
    }

    public void setSkillId(short skillId) {
        this.skillId = skillId;
        getOpcodeBuffer().putShort(SKILL_ID_INDEX, skillId);
    }

    public short getLevel() {
        return level;
    }

    public void setLevel(short level) {
        this.level = level;
        getOpcodeBuffer().putShort(LEVEL_INDEX, level);
    }
}
