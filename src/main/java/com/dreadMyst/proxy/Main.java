package com.dreadMyst.proxy;

import java.util.Scanner;
import com.dreadMyst.proxy.UTILs.OutputUtils;
import com.dreadMyst.proxy.client.FakeClientInitializer;
import com.dreadMyst.proxy.enums.OpcodeEnum;
import com.dreadMyst.proxy.server.FakeServerInitializer;
import com.dreadMyst.proxy.service.FakeClientPacketReceive;
import com.dreadMyst.proxy.service.PacketSend;
import com.dreadMyst.proxy.service.FakeServerPacketReceive;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        OpcodeEnum[] opcodeEnumsLoaded = OpcodeEnum.values();
        OutputUtils.info("PROTOCOL OPCODES LOADED: " + opcodeEnumsLoaded.length);

        for (OpcodeEnum opcodeEnum : opcodeEnumsLoaded) {
            OutputUtils.print("OK: "+ opcodeEnum.name());
        }

        FakeServerInitializer fakeServer = new FakeServerInitializer();
        FakeClientInitializer fakeClient = new FakeClientInitializer();

        PacketSend packetSend = new PacketSend(fakeClient.getOut(),fakeServer.getOut());

        //REAL SERVER > FAKE CLIENT > FAKE SERVER > REAL CLIENT
        FakeClientPacketReceive toRealClient = new FakeClientPacketReceive(fakeClient.getIn(), packetSend);
        toRealClient.start();

        //REAL CLIENT > FAKE SERVER > FAKE CLIENT > REAL SERVER
        FakeServerPacketReceive toRealServer = new FakeServerPacketReceive(fakeServer.getIn(), packetSend);
        toRealServer.start();

        while(true) {
            Scanner ler = new Scanner(System.in);
            int code = ler.nextInt();

            if (code == 1) {
                fakeClient.closeFakeClientConnection();
            }
            if (code == 2) {
                fakeServer.closeFakeServerConnection();
            }
            if (code == 3) {
                System.exit(0);
            }
        }
    }
}