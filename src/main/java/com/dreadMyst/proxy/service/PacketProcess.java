package com.dreadMyst.proxy.service;

import com.dreadMyst.proxy.UTILs.OutputUtils;
import com.dreadMyst.proxy.UTILs.ServicesUtil;
import com.dreadMyst.proxy.opcode.client.C_ConfirmSpendExp;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
import java.util.Random;

public class PacketProcess {
    private short opcodeId;

    public void packerProcess(String from, ByteBuffer packet){
        opcodeId = packet.order(ByteOrder.LITTLE_ENDIAN).getShort(4);

        if(from.equals("Server") || opcodeId == 51 || opcodeId == 12 || opcodeId == 1) {
            return;
        }

        if(opcodeId == 73) {
            OutputUtils.info("" + packet.getInt(6));
        }

        short[][] teste1 = new short[4][2];
        short[][] teste2 = new short[4][2];

        var random = new Random();
        for(int i = 0; i < 4; i++){
            teste1[i][0] = (short) random.nextInt(64000);
            teste1[i][1] = (short) random.nextInt(100);

            teste2[i][0] = (short) random.nextInt(64000);
            teste2[i][1] = (short) random.nextInt(100);
        }

        var teste = new C_ConfirmSpendExp((short) 4, (short) 4, teste1, teste2);
        System.out.println(teste);

        //TODO: MAYBE CHANGE, REMOVE ARRAY COPY
        byte[] outPut = Arrays.copyOfRange(packet.array(), 6, packet.array().length);

        OutputUtils.debug(from + " total bytes size: " + packet.array().length);
        OutputUtils.print(from + " payload bytes size: " + outPut.length);
        OutputUtils.print("Packet opcode: " + opcodeId);
        OutputUtils.print("Packet content as bytes: " + ServicesUtil.byteToString(outPut, true));
    }
}
