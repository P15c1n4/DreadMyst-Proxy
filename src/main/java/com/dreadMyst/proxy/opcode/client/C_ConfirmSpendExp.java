package com.dreadMyst.proxy.opcode.client;

import com.dreadMyst.proxy.UTILs.OutputUtils;
import com.dreadMyst.proxy.enums.OpcodeEnum;
import com.dreadMyst.proxy.opcode.Opcode;

import java.util.Arrays;

public class C_ConfirmSpendExp extends Opcode {
    private short totalStatus;
    private final int TOTAL_STATUS_INDEX = 6;

    private short[][] statusArray;
    private int STATUS_ARRAY_INDEX;

    private short totalSkills;
    private int TOTAL_SKILLS_INDEX;

    private short[][] skillsArray;
    private int SKILLS_ARRAY_INDEX;

    public C_ConfirmSpendExp(short totalSkills, short totalStatus, short[][] statusArray, short[][] skillsArray) {
        super(OpcodeEnum.C_CONFIRM_SPEND_EXP);

        this.totalSkills = totalSkills;
        this.totalStatus = totalStatus;

        this.statusArray = statusArray;
        this.skillsArray = skillsArray;

        if(totalSkills > 0 || totalStatus > 0){
            increaseBufferLength((totalSkills * 4) + (totalStatus * 4));
        }

        recalcDataIndex();

        putDataInBuffer(this.statusArray, statusArray, STATUS_ARRAY_INDEX);
        putDataInBuffer(this.skillsArray, skillsArray, SKILLS_ARRAY_INDEX);
    }

    public short getTotalStatus() {
        return totalStatus;
    }

    public void setTotalStatus(short totalStatus) {
        this.totalStatus = totalStatus;
    }

    public short[][] getStatusArray() {
        return statusArray;
    }

    public void setStatusArray(short[][] statusArray) {
        if (this.statusArray.length != statusArray.length) {
            OutputUtils.error(this, "(setStatusArray) Error: Arrays have different lengths.");
            return;
        }

        putDataInBuffer(this.statusArray, statusArray, STATUS_ARRAY_INDEX);
        this.statusArray = statusArray;
    }

    public short getTotalSkills() {
        return totalSkills;
    }

    public void setTotalSkills(short totalSkills) {
        this.totalSkills = totalSkills;
    }

    public short[][] getSkillsArray() {
        return skillsArray;
    }

    public void setSkillsArray(short[][] skillsArray) {
        if (this.skillsArray.length != skillsArray.length) {
            OutputUtils.error(this, "(setSkillsArray) Error: Arrays have different lengths.");
            return;
        }

        putDataInBuffer(this.skillsArray, skillsArray, SKILLS_ARRAY_INDEX);
        this.skillsArray = skillsArray;
    }

    private void recalcDataIndex(){
        this.STATUS_ARRAY_INDEX = TOTAL_STATUS_INDEX + 2;

        this.TOTAL_SKILLS_INDEX = STATUS_ARRAY_INDEX + (totalStatus * 4);

        this.SKILLS_ARRAY_INDEX = TOTAL_SKILLS_INDEX + 2;
    }

    private void putDataInBuffer(short[][] oldData, short[][] newData, int startIndex){
        getOpcodeBuffer().position(startIndex);

        try {
            for (int i = 0; i < newData.length; i++) {
                getOpcodeBuffer().putShort(newData[i][0]);
                getOpcodeBuffer().putShort(newData[i][1]);
            }

        }catch (Exception e){
            if (Arrays.deepEquals(oldData, newData)) {
                OutputUtils.error(this, "(putDataInBuffer) Error: Infinite recursion detected.");
                return;
            }

            putDataInBuffer(oldData, oldData, startIndex);
        }
    }
}
