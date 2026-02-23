package com.dreadMyst.proxy.opcode;

import com.dreadMyst.proxy.UTILs.OutputUtils;
import com.dreadMyst.proxy.enums.OpcodeEnum;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

public abstract class Opcode {
    private final int FIRST_FIELD_SIZE_LENGTH  = 4;
    private final short SECOND_FIELD_SIZE_LENGTH = 2;
    private ByteBuffer opcodeBuffer;
    private String opcodeName;
    private OpcodeEnum opcodeEnum;

    public Opcode(OpcodeEnum opcodeEnum) {
        this.opcodeName = opcodeEnum.name();
        this.opcodeEnum = opcodeEnum;

        this.opcodeBuffer = ByteBuffer.allocate(FIRST_FIELD_SIZE_LENGTH + SECOND_FIELD_SIZE_LENGTH + opcodeEnum.getOpcodePayloadSize());
        this.opcodeBuffer.putInt(opcodeBuffer.limit());
        this.opcodeBuffer.putShort(opcodeEnum.getOpcodeId());
    }

    public String getOpcodeName(){
        return opcodeName;
    }

    public int getFIRST_FIELD_SIZE_LENGTH() {
        return FIRST_FIELD_SIZE_LENGTH;
    }

    public short getSECOND_FIELD_SIZE_LENGTH() {
        return SECOND_FIELD_SIZE_LENGTH;
    }

    public OpcodeEnum getOpcodeEnum() {
        return opcodeEnum;
    }

    public ByteBuffer getOpcodeBuffer() {
        return opcodeBuffer;
    }

    public void setOpcodeBuffer(ByteBuffer opcodeBuffer) {
        this.opcodeBuffer = opcodeBuffer;
    }

    public byte[] toByteArray() {
        opcodeBuffer.flip();
        return opcodeBuffer.array();
    }

    public void changeString(int index, String text){
        if(index < 0 || index >= opcodeBuffer.limit()){
            OutputUtils.error(this, "(changeString): Index out of range");
            return;
        }

        byte[] newStringBytes = text.getBytes(StandardCharsets.UTF_8);
        byte[] oldBuffer = opcodeBuffer.array();
        int oldStringLength = 0;

        for(int i = index; i < oldBuffer.length; i++){
            if(oldBuffer[i] == 0){
                oldStringLength++;
                break;
            }
            oldStringLength++;
        }

        int newBufferLength = oldBuffer.length - oldStringLength + (newStringBytes.length + 1);

        ByteBuffer newBuffer = ByteBuffer.allocate(newBufferLength);

        newBuffer.put(oldBuffer, 0, index);
        newBuffer.put(newStringBytes);
        newBuffer.put((byte) 0);
        newBuffer.put(oldBuffer, index + oldStringLength, oldBuffer.length - (index + oldStringLength));

        newBuffer.flip();
        opcodeBuffer = newBuffer;
    }

    public void increaseBufferLength(int value){
        int newBufferLength = opcodeBuffer.capacity() + value;
        this.opcodeBuffer = ByteBuffer.allocate(newBufferLength);
    }

    public void decreaseBufferLength(int value){
        int newBufferLength = opcodeBuffer.capacity() - value;
        this.opcodeBuffer = ByteBuffer.allocate(newBufferLength);
    }

}

