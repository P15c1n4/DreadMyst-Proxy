package com.dreadMyst.proxy.opcode.client;

import com.dreadMyst.proxy.enums.OpcodeEnum;
import com.dreadMyst.proxy.opcode.Opcode;

public class C_UserMove extends Opcode {

    private float x;
    private final int X_INDEX = 6;

    private float y;
    private final int Y_INDEX = 10;

    private byte isWalking;
    private final int IS_WALKING_INDEX = 14;

    public C_UserMove(float x, float y, byte isWalking) {
        super(OpcodeEnum.C_USER_MOVE);
        this.x = x;
        this.y = y;
        this.isWalking = isWalking;

        getOpcodeBuffer().putFloat(x);
        getOpcodeBuffer().putFloat(y);
        getOpcodeBuffer().put(isWalking);
        getOpcodeBuffer().flip();
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
        getOpcodeBuffer().putFloat(X_INDEX, x);
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
        getOpcodeBuffer().putFloat(Y_INDEX, y);
    }

    public byte isWalking() {
        return isWalking;
    }

    public void setIsWalking(byte isWalking) {
        this.isWalking = isWalking;
        getOpcodeBuffer().put(IS_WALKING_INDEX, isWalking);
    }
}
